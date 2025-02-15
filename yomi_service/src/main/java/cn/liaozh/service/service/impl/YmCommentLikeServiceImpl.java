package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmCommentLikeMapper;
import cn.liaozh.dao.YmCommentMapper;
import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.YmComment;
import cn.liaozh.pojo.YmCommentLike;
import cn.liaozh.pojo.vo.OperObjVo;
import cn.liaozh.service.service.YmChatMsgService;
import cn.liaozh.service.service.YmCommentLikeService;
import cn.liaozh.service.service.YmCommentService;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.enums.LikeState;
import cn.liaozh.service_base.exception.YmException;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class YmCommentLikeServiceImpl extends MPJBaseServiceImpl<YmCommentLikeMapper, YmCommentLike> implements YmCommentLikeService {
    @Resource
    private YmCommentMapper ymCommentMapper;
    @Resource
    private YmCommentLikeMapper ymCommentLikeMapper;
    @Resource
    private YmCommentService ymCommentService;
    @Autowired
    private YmCommentLikeService ymCommentLikeService;
    @Autowired
    private WebSocketUtils webSocketUtils;
    @Autowired
    private YmChatMsgService chatMsgService;

    public YmCommentLike queryUserLike(String userId, String commentId) {
        QueryWrapper<YmCommentLike> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("comment_id", commentId);
        return this.ymCommentLikeMapper.selectOne(queryWrapper);
    }

    public Integer insertLike(YmCommentLike ymCommentLike) {
        int rows = this.ymCommentMapper.updateLike(0, ymCommentLike.getCommentId());
        return rows > 0 ? this.ymCommentLikeMapper.insert(ymCommentLike) : 0;
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Integer updateLike(YmCommentLike likeList) {
        likeList.setLikeState(LikeState.LIKE.getCode());
        int rows = this.ymCommentLikeMapper.updateById(likeList);
        this.ymCommentMapper.updateLike(0, likeList.getCommentId());
        return rows;
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public void updateState(String userId, String commentId) {
        int rows = this.baseMapper.updateState(userId, commentId);
        if (rows == 1) {
            this.ymCommentMapper.updateLike(6, "1499577297278083074");
        } else {
            throw new YmException(ExecutionResult.LIKE_CODE_501);
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public void updateLikeState(YmCommentLike ymCommentLike) {
        YmCommentLike likeList = this.queryUserLike(ymCommentLike.getUserId(), ymCommentLike.getCommentId());
        if (likeList == null) {
            this.insertLike(ymCommentLike);
        } else {
            if (likeList.getLikeState().equals(LikeState.LIKE.getCode())) {
                throw new YmException(ExecutionResult.LIKE_CODE_501);
            }

            this.updateLike(likeList);
        }

    }

    @Transactional
    public boolean commentsLike(String userId, String id) {
        QueryWrapper<YmCommentLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", id);
        queryWrapper.eq("user_id", userId);
        YmCommentLike commentsLike = this.getOne(queryWrapper);
        if (commentsLike == null) {
            this.ymCommentService.lambdaUpdate().eq(YmComment::getCommentId, id).setSql(" like_num = like_num+1 ").update();
            YmCommentLike commentLike1 = new YmCommentLike();
            commentLike1.setCommentId(id);
            commentLike1.setUserId(userId);
            boolean save = this.ymCommentLikeService.save(commentLike1);
            YmChatMsg ymChatMsg = new YmChatMsg();
            ymChatMsg.setSendUserId(userId);
            YmComment one = this.ymCommentService.lambdaQuery().eq(YmComment::getCommentId, id).one();
            ymChatMsg.setAcceptUserId(one.getUserId());
            ymChatMsg.setType(MsgEnumType.LIKE_ARTICLE_COMMENT.getType());
            ymChatMsg.setOperObj(new OperObjVo());
            ymChatMsg.setMsg((new JSONObject(commentLike1)).toString());
            ymChatMsg.setImage("");
            ymChatMsg.setSignFlag("0");
            this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
            return save;
        } else {
            boolean bul = commentsLike.getLikeState().equals(LikeState.LIKE.getCode());
            commentsLike.setLikeState(bul ? "1" : "0");
            this.ymCommentService.lambdaUpdate().eq(YmComment::getCommentId, id).setSql(bul, " like_num = like_num-1 ").setSql(!bul, " like_num = like_num+1 ").update();
            return this.updateById(commentsLike);
        }
    }
}
