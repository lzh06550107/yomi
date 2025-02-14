package cn.liaozh.service.websocket.util;

import cn.hutool.json.JSONObject;
import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.service.service.YmChatMsgService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service.websocket.entity.Message;
import cn.liaozh.service.websocket.entity.UnreadMessages;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketUtils {
    private static final Logger log = LoggerFactory.getLogger(WebSocketUtils.class);
    public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap();

    public WebSocketUtils() {
    }

    public static boolean sendMessage(Session session, String message) {
        if (session == null) {
            return false;
        } else {
            RemoteEndpoint.Async async = session.getAsyncRemote();
            if (async == null) {
                return false;
            } else {
                async.sendText(message);
                return true;
            }
        }
    }

    public void sendMessageSingle(Message msg) {
        YmChatMsg ymChatMsg = new YmChatMsg();
        ymChatMsg.setMsg(msg.getContent());
        ymChatMsg.setType(msg.getMsgType().toString());
        ymChatMsg.setSendUserId(msg.getUserId());
        ymChatMsg.setAcceptUserId(msg.getToUserId());
        ymChatMsg.setSignFlag("0");
        ymChatMsg.setType(msg.getMsgType().getType());
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        YmUserService userService = act.getBean(YmUserService.class);
        YmChatMsgService service = act.getBean(YmChatMsgService.class);
        service.save(ymChatMsg);
        msg.setMsgChatId(ymChatMsg.getId());
        YmUser user = (YmUser)((LambdaQueryChainWrapper)userService.lambdaQuery().eq(YmUser::getUserId, msg.getUserId())).one();
        YmUser toUser = (YmUser)((LambdaQueryChainWrapper)userService.lambdaQuery().eq(YmUser::getUserId, msg.getToUserId())).one();
        msg.setAvatar(user.getAvatar());
        msg.setUserName(user.getUserName());
        msg.setToUserAvatar(toUser.getAvatar());
        msg.setToUserName(toUser.getUserName());
        Session session = (Session)ONLINE_USER_SESSIONS.get(msg.getToUserId());
        if (session != null) {
            sendMessage(session, (new JSONObject(msg)).toString());
        }

    }

    public boolean sendUnreadMessagesNum(YmChatMsg ymChatMsg) {
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        YmChatMsgService service = (YmChatMsgService)act.getBean(YmChatMsgService.class);
        if (!ymChatMsg.getAcceptUserId().equals(ymChatMsg.getSendUserId()) && service.save(ymChatMsg)) {
            Session session = (Session)ONLINE_USER_SESSIONS.get(ymChatMsg.getAcceptUserId());
            return session != null ? sendMessage(session, (new JSONObject(this.getUnreadMessages(ymChatMsg.getAcceptUserId()))).toString()) : true;
        } else {
            return false;
        }
    }

    public void flushUnreadMessagesNum(String userId) {
        Session session = (Session)ONLINE_USER_SESSIONS.get(userId);
        if (session != null) {
            sendMessage(session, (new JSONObject(this.getUnreadMessages(userId))).toString());
        }

    }

    public UnreadMessages getUnreadMessages(String userId) {
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        YmChatMsgService service = act.getBean(YmChatMsgService.class);
        List<YmChatMsg> list = service.lambdaQuery().eq(YmChatMsg::getAcceptUserId, userId).eq(YmChatMsg::getSignFlag, "0").list();
        UnreadMessages unreadMessages = new UnreadMessages();
        unreadMessages.setUserId(userId);
        unreadMessages.setMsgNum(list == null ? 0L : (long)list.size());
        return unreadMessages;
    }

    public static void sendMessageAll(String message) {
        ONLINE_USER_SESSIONS.forEach((sessionId, session) -> sendMessage(session, message));
    }
}

