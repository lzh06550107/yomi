package cn.liaozh.service.websocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnreadMessages {

    private String userId;
    private String type = "UnreadMessages";
    private long msgNum;

}

