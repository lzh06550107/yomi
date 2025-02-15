package cn.liaozh.service.websocket.entity;

import cn.liaozh.service.websocket.enumType.MsgEnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String userId;
    private String userName;
    private String avatar;
    private String toUserId;
    private String toUserName;
    private String toUserAvatar;
    private MsgEnumType msgType;
    private String msgChatId;
    private String content;
}

