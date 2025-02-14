package cn.liaozh.service.service.impl;

import cn.hutool.json.JSONObject;
import cn.liaozh.dao.YmCommentsLikeMapper;
import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.YmComments;
import cn.liaozh.pojo.YmCommentsLike;
import cn.liaozh.pojo.vo.OperObjVo;
import cn.liaozh.service.service.YmCommentsLikeService;
import cn.liaozh.service.service.YmCommentsService;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.LikeState;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YmCommentsLikeServiceImpl extends MPJBaseServiceImpl<YmCommentsLikeMapper, YmCommentsLike> implements YmCommentsLikeService {
    @Autowired
    YmCommentsService commentsService;
    @Autowired
    private YmCommentsLikeService ymCommentsLikeService;
    @Autowired
    private WebSocketUtils webSocketUtils;

    public YmCommentsLikeServiceImpl() {
    }

    public boolean commentsLike(String userId, String id) {
        QueryWrapper<YmCommentsLike> queryWrapper = new QueryWrapper();
        queryWrapper.eq("comment_id", id);
        queryWrapper.eq("user_id", userId);
        YmCommentsLike commentsLike = (YmCommentsLike)this.getOne(queryWrapper);
        if (commentsLike == null) {
            ((LambdaUpdateChainWrapper)((LambdaUpdateChainWrapper)this.commentsService.lambdaUpdate().eq(YmComments::getCommentId, id)).setSql(" like_num = like_num+1 ")).update();
            YmCommentsLike commentsLike1 = new YmCommentsLike();
            commentsLike1.setCommentId(id);
            commentsLike1.setUserId(userId);
            if (this.save(commentsLike1)) {
                YmChatMsg ymChatMsg = new YmChatMsg();
                ymChatMsg.setSendUserId(userId);
                YmCommentsLike one = (YmCommentsLike)((LambdaQueryChainWrapper)this.ymCommentsLikeService.lambdaQuery().eq(YmCommentsLike::getCommentId, id)).one();
                ymChatMsg.setAcceptUserId(one.getUserId());
                ymChatMsg.setType(MsgEnumType.LIKE_GOODS_COMMENT.getType());
                ymChatMsg.setOperObj(new OperObjVo());
                ymChatMsg.setMsg((new JSONObject(commentsLike1)).toString());
                ymChatMsg.setImage("");
                ymChatMsg.setSignFlag("0");
                this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
            }

            return true;
        } else {
            boolean bul = commentsLike.getLikeState().equals(LikeState.LIKE.getCode());
            commentsLike.setLikeState(bul ? "1" : "0");
            ((LambdaUpdateChainWrapper)this.commentsService.lambdaUpdate().eq(YmComments::getCommentId, id)).setSql(bul, " like_num = like_num-1 ").setSql(!bul, " like_num = like_num+1 ").update();
            this.updateById(commentsLike);
            return true;
        }
    }
}

