package cn.liaozh.service.service.impl;

import cn.hutool.json.JSONObject;
import cn.liaozh.dao.YmCommentsMapper;
import cn.liaozh.pojo.*;
import cn.liaozh.pojo.vo.AddCommentsVo;
import cn.liaozh.pojo.vo.AllCommentsVo;
import cn.liaozh.pojo.vo.CommentsVo;
import cn.liaozh.service.service.YmCommentsLikeService;
import cn.liaozh.service.service.YmCommentsService;
import cn.liaozh.service.service.YmIntactGoodsService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service.service.service_utils.StringUtils;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

@Service
public class YmCommentsServiceImpl extends MPJBaseServiceImpl<YmCommentsMapper, YmComments> implements YmCommentsService {
    @Autowired
    YmCommentsLikeService commentsLikeService;
    @Autowired
    private YmCommentsService ymCommentsService;
    @Autowired
    private WebSocketUtils webSocketUtils;
    @Autowired
    private YmIntactGoodsService goodsService;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private YmUserService userService;

    public IPage<CommentsVo> getLevelOneComments(String userId, String id, Integer page) {

        MPJLambdaWrapper<YmComments> wrapper = new MPJLambdaWrapper<YmComments>()
                .select(YmComments::getCommentId, YmComments::getUserId, YmComments::getParentId, YmComments::getContent, YmComments::getLikeNum, YmComments::getLink, YmComments::getCreateTime)
                .select(YmUser::getUserName, YmUser::getAvatar)
                .leftJoin(YmUser.class, YmUser::getUserId, YmComments::getUserId)
                .eq(YmComments::getTargetId, id)
                .eq(YmComments::getIsDeleted, "0")
                .eq(YmComments::getParentId, "0")
                .orderByDesc(YmComments::getLikeNum)
                .orderByDesc(YmComments::getCreateTime, YmComments::getUpdateTime);

        Page<CommentsVo> ymFansIPages = new Page((long)page, 5L);
        IPage<CommentsVo> ymCommentsIPage = this.baseMapper.selectJoinPage(ymFansIPages, CommentsVo.class, wrapper);
        List<String> likeId = this.commentsLikeService.lambdaQuery().eq(YmCommentsLike::getUserId, userId).eq(YmCommentsLike::getLikeState, "0").list().stream().map(YmCommentsLike::getCommentId).collect(Collectors.toList());
        ymCommentsIPage.getRecords().forEach((temp) -> {
            IPage<CommentsVo> levelTwoComments = this.getLevelTwoComments(userId, temp.getCommentId(), page);
            if (levelTwoComments == null) {
                temp.setCommentsNum(0);
            } else {
                temp.setCommentsNum((int)levelTwoComments.getTotal());
            }

            temp.setStatus(likeId.contains(temp.getCommentId()));
        });
        return ymCommentsIPage;
    }

    public IPage<CommentsVo> getLevelTwoComments(String userId, String id, Integer page) {
        List<String> likeId = this.commentsLikeService.lambdaQuery().eq(YmCommentsLike::getUserId, userId).eq(YmCommentsLike::getLikeState, "0").list().stream().map(YmCommentsLike::getCommentId).collect(Collectors.toList());
        List<YmComments> ymCommentsList = this.lambdaQuery().eq(YmComments::getParentId, id).list();
        ArrayList<String> list = new ArrayList<>();
        if (!ymCommentsList.isEmpty()) {
            this.cycleGetCommentId(ymCommentsList, list);
            MPJLambdaWrapper<YmComments> wrapper = new MPJLambdaWrapper<YmComments>()
                    .select(YmComments::getCommentId, YmComments::getUserId, YmComments::getParentId, YmComments::getContent, YmComments::getLikeNum, YmComments::getLink, YmComments::getCreateTime)
                    .select(YmUser::getUserName, YmUser::getAvatar)
                    .leftJoin(YmUser.class, YmUser::getUserId, YmComments::getUserId)
                    .in(YmComments::getCommentId, list)
                    .eq(YmComments::getIsDeleted, "0");

            Page ymFansIPages = new Page((long)page, 5L);
            IPage<CommentsVo> ymCommentsIPage = this.baseMapper.selectJoinPage(ymFansIPages, CommentsVo.class, wrapper);
            list.add(id);

            List<CommentsVo> userNameList = this.baseMapper.selectJoinList(
                    CommentsVo.class,
                    new MPJLambdaWrapper<YmComments>()
                            .select(YmUser::getUserName)
                            .select(YmComments::getCommentId) // 如果 CommentsVo 需要 commentId，则保留
                            .leftJoin(YmUser.class, YmUser::getUserId, YmComments::getUserId)
                            .in(YmComments::getCommentId, list)
            );

            WeakHashMap map = new WeakHashMap();
            userNameList.forEach((temp) -> map.put(temp.getCommentId(), temp.getUserName()));
            ymCommentsIPage.getRecords().forEach((temp) -> {
                Object o = map.get(temp.getParentId());
                if (o != null) {
                    temp.setWasRepliedName(o.toString());
                }

            });
            return ymCommentsIPage;
        } else {
            return null;
        }
    }

    public List<String> cycleGetCommentId(List<YmComments> ymCommentList, List<String> parentIdList) {
        int stop = ymCommentList.size();
        parentIdList.addAll(ymCommentList.stream().map(YmComments::getCommentId).collect(Collectors.toList()));
        List<YmComments> list = this.lambdaQuery().in(YmComments::getParentId, parentIdList).list();
        return stop == list.size() && parentIdList.containsAll(list.stream().map(YmComments::getCommentId).collect(Collectors.toList())) ? null : this.cycleGetCommentId(list, parentIdList);
    }

    public CommentsVo addComments(String userId, AddCommentsVo commentsVo) {
        if (this.stringUtils.strFilter(commentsVo.getContent())) {
            throw new YmException(ExecutionResult.ARTICLE_CODE_405);
        } else {
            YmComments ymComments = new YmComments();
            ymComments.setTargetId(commentsVo.getTargetId());
            ymComments.setContent(commentsVo.getContent());
            ymComments.setParentId(commentsVo.getLink());
            ymComments.setParentId(commentsVo.getParentId());
            ymComments.setUserId(userId);
            String acceptUserId = null;
            if (this.save(ymComments)) {
                YmChatMsg ymChatMsg = new YmChatMsg();
                String parentId = ymComments.getParentId();
                if (parentId.equals("0")) {
                    ymChatMsg.setType(MsgEnumType.COMMENT_GOODS.getType());
                    YmIntactGoods one = this.goodsService.lambdaQuery().eq(YmIntactGoods::getIntactGoodsId, ymComments.getTargetId()).one();
                    ymChatMsg.setAcceptUserId(one.getUserId());
                } else {
                    YmComments one = this.ymCommentsService.lambdaQuery().eq(YmComments::getCommentId, parentId).one();
                    acceptUserId = one.getUserId();
                    ymChatMsg.setAcceptUserId(acceptUserId);
                    ymChatMsg.setType(MsgEnumType.COMMENT_TO_COMMENT.getType());
                }

                ymChatMsg.setSendUserId(userId);
                ymChatMsg.setImage("");
                ymChatMsg.setSignFlag("0");
                ymChatMsg.setMsg((new JSONObject(ymComments)).toString());
                this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
            }

            YmUser user = this.userService.getById(userId);
            CommentsVo comments = new CommentsVo();
            BeanUtils.copyProperties(ymComments, comments);
            String wasRepliedName = null;
            if (!Objects.isNull(acceptUserId)) {
                wasRepliedName = this.userService.lambdaQuery().eq(YmUser::getUserId, acceptUserId).one().getUserName();
            }

            comments.setAvatar(user.getAvatar()).setUserName(user.getUserName()).setWasRepliedName(wasRepliedName);
            return comments;
        }
    }

    @Transactional
    public boolean removeComment(String userId, String commentId) {
        QueryWrapper<YmComments> queryWrapper = new QueryWrapper<YmComments>()
                .eq("comment_id", commentId)
                .eq("user_id", userId);

        YmComments ymComments = this.baseMapper.selectOne(queryWrapper);

        if (ymComments == null) {
            return false;
        } else if (ymComments.getParentId().equals("0")) {
            List<String> list = new ArrayList<>();
            this.cycleGetCommentId(this.baseMapper.selectList(queryWrapper), list);
            QueryWrapper<YmComments> qr = new QueryWrapper<>();
            if (list.isEmpty()) {
                return this.baseMapper.delete(queryWrapper) > 0;
            } else {
                qr.in("comment_id", list);
                return this.baseMapper.delete(qr) > 0;
            }
        } else {
            return this.baseMapper.delete(queryWrapper) > 0;
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public List<AllCommentsVo> getComments(String userId, String id) {
        Page<CommentsVo> levelOneComments = (Page)this.getLevelOneComments(userId, id, 1);
        List<AllCommentsVo> level = new ArrayList<>();
        levelOneComments.getRecords().forEach((temp) -> {
            QueryWrapper<YmCommentsLike> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("comment_id", temp.getCommentId());
            queryWrapper.eq("user_id", userId);
            YmCommentsLike commentsLike = this.commentsLikeService.getOne(queryWrapper);
            if (commentsLike == null) {
                temp.setStatus(false);
            } else {
                temp.setStatus(commentsLike.getLikeState().equals("0"));
            }

            AllCommentsVo allCommentsVo = new AllCommentsVo();
            BeanUtils.copyProperties(temp, allCommentsVo);
            level.add(allCommentsVo);
        });
        level.forEach((temp) -> {
            List<CommentsVo> levelTwoComments = (List)this.getLevelTwoComments(userId, id, 1);
            List<CommentsVo> collect = levelTwoComments.stream().map((temps) -> {
                QueryWrapper<YmCommentsLike> queryWrapper = new QueryWrapper();
                queryWrapper.eq("comment_id", temps.getCommentId());
                queryWrapper.eq("user_id", userId);
                YmCommentsLike commentsLike = this.commentsLikeService.getOne(queryWrapper);
                if (commentsLike == null) {
                    temps.setStatus(false);
                } else {
                    temps.setStatus(commentsLike.getLikeState().equals("0"));
                }

                return temps;
            }).collect(Collectors.toList());
            temp.setList(collect);
        });
        return level;
    }

    public boolean CommentsLike(String userId, String id) {
        return false;
    }
}

