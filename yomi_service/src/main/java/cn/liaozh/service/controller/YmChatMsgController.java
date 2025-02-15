package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.vo.MsgChatVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.service.service.YmChatMsgService;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping({"/ym_server/chatMsg"})
public class YmChatMsgController {

    @Autowired
    private YmChatMsgService chatMsgService;

    public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap();

    @GetMapping
    public R notSignedMsg(String userId) {
        List<MsgChatVo> msgList = this.chatMsgService.getMsg(userId);
        return R.ok().data("list", msgList);
    }

    @GetMapping({"{sendUserId}"})
    public R getMsgDetail(String userId, @PathVariable String sendUserId, @PathVariable Integer page, @PathVariable Integer size) {
        Map<String, Object> map = new HashMap();
        Page<YmChatMsg> msgPage = this.chatMsgService.getMsgDetail(userId, sendUserId, page, size);

        if (msgPage.getTotal() > 0L) {
            map.put("records", this.cleanData(msgPage));
            map.put("total", msgPage.getTotal());
            map.put("size", msgPage.getSize());
            map.put("pages", msgPage.getPages());
            map.put("current", msgPage.getCurrent());
        } else {
            map.put("records", new ArrayList());
            map.put("total", 0);
            map.put("size", size);
            map.put("pages", page);
        }

        return R.ok().data(map);
    }

    @GetMapping({"list"})
    public R getTypeMsg(String userId, @RequestParam String type, @RequestParam Integer page, @RequestParam Integer size) {
        Map<String, Object> map = new HashMap();
        Page<YmChatMsg> typeMsg = this.chatMsgService.getTypeMsg(userId, type, page, size);
        if (typeMsg.getTotal() > 0L) {
            map.put("records", this.cleanData(typeMsg));
            map.put("total", typeMsg.getTotal());
            map.put("size", typeMsg.getSize());
            map.put("pages", typeMsg.getPages());
            map.put("current", typeMsg.getCurrent());
        } else {
            map.put("records", new ArrayList());
            map.put("total", 0);
            map.put("size", size);
            map.put("pages", page);
        }

        return R.ok().data(map);
    }

    private List<Map<String, Object>> cleanData(Page<YmChatMsg> pageData) {
        List<Map<String, Object>> resultList = new ArrayList();

        for (YmChatMsg chatMsg : pageData.getRecords()) {
            Map<String, Object> resultMap = (Map) JSON.parseObject(JSON.toJSONString(chatMsg), HashMap.class);
            final UserInfoVo sendUser = chatMsg.getSendUser();
            final String sendUserName = sendUser.getUserName();
            resultMap.put("sendUser", new HashMap<String, Object>() {
                {
                    this.put("userId", sendUser.getUserId());
                    this.put("userName", sendUserName);
                    this.put("avatar", sendUser.getAvatar());
                }
            });
            resultList.add(resultMap);
        }

        return resultList;
    }

    @PostMapping({"send"})
    public R sendMsg(String userId, @RequestBody YmChatMsg chatMsg) {
        chatMsg.setSendUserId(userId);
        chatMsg.setType(MsgEnumType.USER_SEND_MSG.getType());
        boolean isSend = this.chatMsgService.sendMsg(chatMsg);
        return isSend ? R.ok() : R.error();
    }
}

