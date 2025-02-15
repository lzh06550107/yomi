package cn.liaozh.service.controller;

import cn.hutool.json.JSONObject;
import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.YmIdeafeedback;
import cn.liaozh.service.service.YmIdeafeedbackService;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/ym_server/ideafeedback"})
public class YmIdeafeedbackController {

    @Autowired
    private YmIdeafeedbackService ideafeedbackService;
    @Autowired
    private WebSocketUtils webSocketUtils;

    @PostMapping({"feedback"})
    public R feedback(String userId, @RequestBody YmIdeafeedback ymIdeafeedback) {
        ymIdeafeedback.setUserId(userId);
        YmChatMsg ymChatMsg = new YmChatMsg();
        ymChatMsg.setType(MsgEnumType.SYSTEM.getType());
        ymChatMsg.setSendUserId("0");
        ymChatMsg.setAcceptUserId(userId);
        ymChatMsg.setSignFlag("0");
        boolean save = this.ideafeedbackService.save(ymIdeafeedback);
        if (save) {
            ymChatMsg.setMsg((new JSONObject(ymIdeafeedback)).toString());
            this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
        }

        return save ? R.ok() : R.error();
    }

    @GetMapping({"contact"})
    public R contactWe() {
        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        jsonObject.put("qq", "514545803");
        jsonObject.put("wx", "启嘉网");
        return R.ok().data("list", jsonObject);
    }
}

