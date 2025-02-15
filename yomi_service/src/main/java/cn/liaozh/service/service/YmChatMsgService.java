package cn.liaozh.service.service;

import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.vo.MsgChatVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

public interface YmChatMsgService extends MPJBaseService<YmChatMsg> {

    List<YmChatMsg> notSignedMsg(String userId);

    List<MsgChatVo> getMsg(String userId);

    Page<YmChatMsg> getTypeMsg(String userId, String type, Integer page, Integer size);

    boolean sendMsg(YmChatMsg chatMsg);

    Page<YmChatMsg> getMsgDetail(String userId, String sendUserId, Integer page, Integer size);
}
