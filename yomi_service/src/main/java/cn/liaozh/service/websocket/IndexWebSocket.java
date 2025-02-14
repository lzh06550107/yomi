package cn.liaozh.service.websocket;

import cn.hutool.json.JSONObject;
import cn.liaozh.common.jwt.JwtUtil;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service.websocket.util.ApplicationContextRegister;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint("/ws/{token}")
public class IndexWebSocket {
    private static final Logger log = LoggerFactory.getLogger(IndexWebSocket.class);

    @OnOpen
    public void openSession(@PathParam("token") String token, Session session) {
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        YmUserService userService = act.getBean(YmUserService.class);
        JwtUtil.checkToken(token);
        String userId = JwtUtil.getUserIdByToken(token);
        YmUser user = userService.getById(userId);
        if (user == null) {
            log.info("客户端: [" + userId + "] : 用户不存在！");
        } else {
            WebSocketUtils.ONLINE_USER_SESSIONS.put(userId, session);
            log.info("客户端: [" + user.getUserName() + "] : 连接成功！");
            WebSocketUtils.sendMessage(session, (new JSONObject((new WebSocketUtils()).getUnreadMessages(userId))).toString());
        }
    }

    @OnMessage
    public void onMessage(@PathParam("token") String token, String message) {
        JwtUtil.checkToken(token);
        String userId = JwtUtil.getUserIdByToken(token);
        log.info("服务器收到：[" + userId + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("token") String token, Session session) throws IOException {
        JwtUtil.checkToken(token);
        String userId = JwtUtil.getUserIdByToken(token);
        WebSocketUtils.ONLINE_USER_SESSIONS.remove(userId);
        log.info("[" + userId + "] : 断开连接！");
        WebSocketUtils.sendMessageAll("[" + userId + "] : 断开连接！");
        session.close();
    }

    @OnError
    public void onError(Session session, Throwable throwable) throws IOException {
        session.close();
    }

    public IndexWebSocket() {
    }
}
