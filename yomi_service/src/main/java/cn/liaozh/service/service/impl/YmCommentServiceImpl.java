package cn.liaozh.service.service.impl;

import cn.liaozh.common.oss.UploadUtils;
import cn.liaozh.dao.YmCommentMapper;
import cn.liaozh.pojo.*;
import cn.liaozh.pojo.vo.*;
import cn.liaozh.service.service.*;
import cn.liaozh.service.service.service_utils.StringUtils;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class YmCommentServiceImpl extends MPJBaseServiceImpl<YmCommentMapper, YmComment> implements YmCommentService {
    @Resource
    private ImgUploadService imgUploadService;
    @Resource
    private YmCommentMapper ymCommentMapper;
    @Resource
    private YmCommentService commentService;
    @Resource
    private YmCommentLikeService commentLikeService;
    @Resource
    private YmUserService userService;
    @Autowired
    private YmArticleService articleService;
    @Autowired
    private YmIntactArticleService intactArticleService;
    @Autowired
    private WebSocketUtils webSocketUtils;
    @Autowired
    private StringUtils stringUtils;

    public YmCommentServiceImpl() {
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public void saveComment(YmComment ymComment) {
        boolean commentSave = this.save(ymComment);
        if (!commentSave) {
            throw new YmException(ExecutionResult.DATA_CODE_301);
        }
    }

    public Page<CommentsVo> queryOneComment(String userId, String articleId, Integer page) {
        Page<CommentsVo> userInfoVoPage = new Page();
        YmIntactArticle ymIntactArticle = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, articleId).one();
        String user = ymIntactArticle.getUserId();
        List<String> commentIds = this.commentService.lambdaQuery().eq(YmComment::getIsDeleted, "0").eq(YmComment::getParentId, "0").eq(YmComment::getUserId, user).eq(YmComment::getArticleId, articleId).list().stream().map(YmComment::getCommentId).collect(Collectors.toList());
        List<YmComment> hotComment = this.commentService.lambdaQuery().eq(YmComment::getIsDeleted, "0").eq(YmComment::getParentId, "0").eq(YmComment::getArticleId, articleId).ne(YmComment::getUserId, user).list();
        Map<String, Double> map = new HashMap();

        for(YmComment comment : hotComment) {
            map.put(comment.getCommentId(), (double)comment.getLikeNum() * 0.3 + (double)((int)this.getTowLevelCommentNum(userId, articleId, comment.getCommentId(), page).getTotal()) * 0.7);
        }

        List<Map.Entry<String, Double>> entries = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).filter((r) -> (Double)r.getValue() != (double)0.0F).collect(Collectors.toList());
        if (entries.size() >= 3) {
            entries = entries.subList(0, 3);
        }

        if (entries.size() > 0) {
            commentIds.addAll(entries.stream().map((r) -> (String)r.getKey()).collect(Collectors.toList()));
        }

        List<String> otherCommentIds = this.commentService.lambdaQuery()
                .ne(YmComment::getUserId, user) // 排除当前用户的评论
                .eq(YmComment::getParentId, "0") // 只查询顶级评论
                .eq(YmComment::getArticleId, articleId) // 根据文章ID查询
                .notIn(commentIds != null && !commentIds.isEmpty(), YmComment::getCommentId, commentIds) // 排除已处理的评论ID
                .orderByDesc(YmComment::getCreateTime) // 按创建时间降序排序
                .list() // 查询结果列表
                .stream() // 转换为流
                .map(YmComment::getCommentId) // 提取评论ID
                .collect(Collectors.toList()); // 收集为List

        commentIds.addAll(otherCommentIds);
        StringBuilder builder = new StringBuilder();
        builder.append("order by field(comment_id,");
        int length = commentIds.size();

        for(int i = 0; i < length; ++i) {
            if (i == 0) {
                builder.append((String)commentIds.get(i));
            } else {
                builder.append(",").append((String)commentIds.get(i));
            }

            if (i == length - 1) {
                builder.append(")");
            }
        }

        if (commentIds.size() == 0) {
            return userInfoVoPage;
        } else {
            Page<YmComment> ymCommentPage = this.commentService.lambdaQuery().in(YmComment::getCommentId, commentIds).last(builder.toString()).page(new Page((long)page, 20L));
            Set<String> users = ymCommentPage.getRecords().stream().map(YmComment::getUserId).collect(Collectors.toSet());
            List<YmUser> ymUsers = this.userService.lambdaQuery().in(YmUser::getUserId, users).list();
            List<String> ymCommentLikes = this.commentLikeService.lambdaQuery().eq(YmCommentLike::getUserId, userId).eq(YmCommentLike::getLikeState, "0").list().stream().map(YmCommentLike::getCommentId).collect(Collectors.toList());
            List<CommentsVo> vos = ymCommentPage.getRecords().stream().map((r) -> {
                CommentsVo commentsVo = new CommentsVo();
                BeanUtils.copyProperties(r, commentsVo);
                List<YmUser> collect = ymUsers.stream().filter((ymUser) -> ymUser.getUserId().equals(commentsVo.getUserId())).collect(Collectors.toList());
                if (collect.size() != 0) {
                    YmUser u = collect.get(0);
                    commentsVo.setUserName(u.getUserName());
                    commentsVo.setAvatar(u.getAvatar());
                    commentsVo.setCommentsNum((int)this.getTowLevelCommentNum(userId, articleId, commentsVo.getCommentId(), page).getTotal());
                    commentsVo.setStatus(ymCommentLikes.contains(r.getCommentId()));
                }

                return commentsVo;
            }).collect(Collectors.toList());
            Integer rowNum = this.commentService.lambdaQuery().eq(YmComment::getIsDeleted, "0").eq(YmComment::getArticleId, articleId).count();
            userInfoVoPage.setRecords(vos);
            userInfoVoPage.setSize(20L);
            userInfoVoPage.setTotal((long)rowNum);
            return userInfoVoPage;
        }
    }

    public Page<YmComment> getTowLevelCommentNum(String userId, String articleId, String commentId, Integer page) {
        QueryWrapper<YmComment> wrapper = new QueryWrapper();
        List<YmComment> ymCommentList = this.lambdaQuery().eq(YmComment::getArticleId, articleId).eq(YmComment::getParentId, commentId).list();
        ArrayList<String> commentIdList = new ArrayList();
        if (ymCommentList.size() == 0) {
            return new Page();
        } else {
            this.cycleGetCommentId(ymCommentList, commentIdList);
           wrapper.lambda().eq(YmComment::getArticleId, articleId).eq(YmComment::getParentId, commentId).or().in(YmComment::getParentId, commentIdList);
            Page<YmComment> ymFansPage = new Page((long)page, 3L);
            Page<YmComment> ymFansIPages = this.baseMapper.selectPage(ymFansPage, wrapper);
            return ymFansIPages;
        }
    }

    public Page<CommentsVo> queryTwoComment(String userId, String articleId, String commentId, Integer page) {
        Page<CommentsVo> userInfoVoPage = new Page();
        QueryWrapper<YmComment> wrapper = new QueryWrapper();
        List<YmComment> ymCommentList = this.lambdaQuery().eq(YmComment::getArticleId, articleId).eq(YmComment::getParentId, commentId).list();
        ArrayList<String> commentIdList = new ArrayList();
        if (ymCommentList.size() == 0) {
            return userInfoVoPage;
        } else {
            this.cycleGetCommentId(ymCommentList, commentIdList);
            wrapper.lambda().eq(YmComment::getArticleId, articleId).eq(YmComment::getParentId, commentId).or().in(YmComment::getParentId, commentIdList).orderBy(true, false, YmComment::getLikeNum, YmComment::getCreateTime);
            List<YmComment> list = this.list(wrapper);
            Page<YmComment> ymFansPage = new Page((long)page, 3L);
            Page<YmComment> ymFansIPages = this.baseMapper.selectPage(ymFansPage, wrapper);
            if (ymFansIPages.getRecords().size() == 0) {
                BeanUtils.copyProperties(ymFansIPages, userInfoVoPage);
                return userInfoVoPage;
            } else {
                List<String> userIdList = list.stream().map(YmComment::getUserId).collect(Collectors.toList());
                YmComment byId = this.commentService.getById(commentId);
                userIdList.add(byId.getUserId());
                List<YmUser> ymUsers = this.userService.listByIds(userIdList);
                HashMap<String, YmUser> userName = new HashMap();
                ymUsers.forEach((temp) -> userName.put(temp.getUserId(), temp));
                List<String> likeList = this.commentLikeService.lambdaQuery().in(YmCommentLike::getCommentId, list.stream().map(YmComment::getCommentId).collect(Collectors.toList())).eq(YmCommentLike::getUserId, userId).eq(YmCommentLike::getLikeState, "0").list().stream().map((temp) -> temp.getCommentId() + "::" + temp.getUserId()).collect(Collectors.toList());
                HashMap<String, YmComment> stringYmCommentHashMap = new HashMap();
                list.forEach((temp) -> stringYmCommentHashMap.put(temp.getCommentId(), temp));
                stringYmCommentHashMap.put(commentId, this.getById(commentId));
                List<CommentsVo> collect = ymFansIPages.getRecords().stream().map((temp) -> {
                    CommentsVo commentsVo = new CommentsVo();
                    commentsVo.setLink(temp.getLink());
                    commentsVo.setContent(temp.getContent());
                    BeanUtils.copyProperties(temp, commentsVo);
                    commentsVo.setUserName((userName.get(temp.getUserId())).getUserName());
                    commentsVo.setWasRepliedName((userName.get((stringYmCommentHashMap.get(temp.getParentId())).getUserId())).getUserName());
                    commentsVo.setCommentsNum(temp.getLikeNum());
                    commentsVo.setAvatar((userName.get((stringYmCommentHashMap.get(temp.getCommentId())).getUserId())).getAvatar());
                    commentsVo.setLikeNum(this.commentLikeService.lambdaQuery().eq(YmCommentLike::getCommentId, temp.getCommentId()).eq(YmCommentLike::getLikeState, "0").list().size());
                    commentsVo.setStatus(likeList.contains(temp.getCommentId() + "::" + userId));
                    return commentsVo;
                }).collect(Collectors.toList());
                BeanUtils.copyProperties(ymFansIPages, userInfoVoPage);
                userInfoVoPage.setRecords(collect);
                return userInfoVoPage;
            }
        }
    }

    public List<String> cycleGetCommentId(List<YmComment> ymCommentList, List<String> parentIdList) {
        int stop = ymCommentList.size();
        parentIdList.addAll(ymCommentList.stream().map(YmComment::getCommentId).collect(Collectors.toList()));
        List<YmComment> list = this.lambdaQuery().in(YmComment::getParentId, parentIdList).list();
        return stop != list.size() && !list.isEmpty() ? this.cycleGetCommentId(list, parentIdList) : new ArrayList<>();
    }

    public List<OneComment> queryComment(String userId, String articleId, int current) {
        List<YmCommentLike> list = this.commentLikeService.lambdaQuery().eq(YmCommentLike::getUserId, userId).list();
        List<OneComment> oneCommentList = new ArrayList<>();
        List<TwoComment> allOneComment = this.ymCommentMapper.findAllOneComment(articleId);
        List<TwoComment> allTwoComment = this.ymCommentMapper.findAllTwoComment(articleId);

        for(TwoComment ymComment : allOneComment) {
            OneComment oneComment = new OneComment();
            List<TwoComment> twoCommentList = allTwoComment.stream().filter((twoComment) -> ymComment.getCommentId().equals(twoComment.getParentId())).collect(Collectors.toList());
            BeanUtils.copyProperties(ymComment, oneComment);
            List<TwoComment> collect = twoCommentList.stream().map((temp) -> {
                list.forEach((temps) -> {
                    if (temp.getCommentId().equals(temps.getCommentId()) && temps.getLikeState().equals("0")) {
                        temp.setLikeStatus(true);
                    }

                });
                return temp;
            }).collect(Collectors.toList());
            oneComment.setChildren(collect);
            list.forEach((temp) -> {
                if (temp.getCommentId().equals(oneComment.getCommentId()) && temp.getLikeState().equals("0")) {
                    oneComment.setLikeStatus(true);
                }

            });
            oneCommentList.add(oneComment);
        }

        return oneCommentList;
    }

    @Transactional
    public boolean removeTwoComment(String commentId, String userId) {
        QueryWrapper<YmComment> qw = new QueryWrapper();
        qw.eq("comment_id", commentId);
        qw.eq("user_id", userId);
        YmComment ymComment = this.commentService.lambdaQuery().eq(YmComment::getCommentId, commentId).one();
        YmIntactArticle ymIntactArticle = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, ymComment.getArticleId()).one();
        this.baseMapper.delete(qw);
        return this.articleService.lambdaUpdate().eq(YmArticle::getArticleId, ymIntactArticle.getArticleId()).setSql("comment_num = comment_num -1").update();
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean removeOneComment(String commentId, String userId) {
        QueryWrapper<YmComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", commentId).eq("user_id", userId);
        this.commentService.remove(queryWrapper);

        IntactArticleDTO article = this.intactArticleService.selectJoinOne(
                IntactArticleDTO.class,
                new MPJLambdaWrapper<YmIntactArticle>()
                        .select(YmIntactArticle::getIntactArticleId)
                        .selectAll(YmArticle.class)
                        .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                        .leftJoin(YmComment.class, YmComment::getArticleId, YmIntactArticle::getIntactArticleId)
                        .eq(YmComment::getCommentId, commentId)
        );

        Page<YmComment> towLevelCommentNum = this.getTowLevelCommentNum(userId, article.getIntactArticleId(), commentId, 1);
        int num = (long)((int)towLevelCommentNum.getTotal()) == 0L ? 1 : (int)towLevelCommentNum.getTotal() + 1;
        List<String> list = towLevelCommentNum.getRecords().stream().map(YmComment::getCommentId).collect(Collectors.toList());
        if (list.size() != 0) {
            QueryWrapper<YmComment> qr = new QueryWrapper();
            qr.in("comment_id", list);
            this.commentService.remove(qr);
        }

        return this.articleService.lambdaUpdate().set(YmArticle::getCommentNum, article.getCommentNum() - num).eq(YmArticle::getArticleId, article.getArticleId()).update();
    }

    public void saveCommentParent(CommentVo commentVo) {
        YmComment ymComment = new YmComment();
        BeanUtils.copyProperties(commentVo, ymComment);
        ymComment.setParentId(commentVo.getOneCommentId());
        ymComment.setArticleId(commentVo.getArticleId());
        if (ymComment.getParentId() != null) {
            if (this.save(ymComment)) {
                YmChatMsg ymChatMsg = new YmChatMsg();
                ymChatMsg.setType(MsgEnumType.COMMENT_ARTICLE.getType());
                ymChatMsg.setSendUserId(commentVo.getUserId());
                YmIntactArticle one = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, ymComment.getArticleId()).one();
                ymChatMsg.setAcceptUserId(one.getUserId());
                ymChatMsg.setImage("");
                ymChatMsg.setSignFlag("0");
                ymChatMsg.setMsg((new JSONObject((Map<String, Object>) ymComment)).toString());
                this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
            }

        } else {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }
    }

    public void saveCommentImg(MultipartFile file, String articleId, String userId) {
        String originalFilename = this.imgUploadService.commonUpload(file, 10);
        YmComment ymComment = new YmComment();
        ymComment.setContent(originalFilename);
        ymComment.setUserId(userId);
        ymComment.setArticleId(articleId);
        boolean commentSave = this.save(ymComment);
        if (!commentSave) {
            throw new YmException(ExecutionResult.DATA_CODE_301);
        }
    }

    public void saveCommentImgParent(MultipartFile file, String commentId, String userId) {
        String originalFilename = UploadUtils.uploadLocalFileAvatar(file);
        YmComment comment = (YmComment)((LambdaQueryChainWrapper)this.commentService.lambdaQuery().eq(YmComment::getCommentId, commentId)).one();
        YmComment ymComment = new YmComment();
        ymComment.setArticleId(comment.getArticleId());
        ymComment.setParentId(commentId);
        ymComment.setUserId(userId);
        ymComment.setContent(originalFilename);
        this.save(ymComment);
    }

    public Object updateComment(String userId, CommentDTO commentVo) {
        YmComment ymComment = new YmComment();
        if (this.stringUtils.strFilter(commentVo.getContent())) {
            throw new YmException(ExecutionResult.ARTICLE_CODE_405);
        } else {
            BeanUtils.copyProperties(commentVo, ymComment);
            ymComment.setUserId(userId);
            String commentUserId = null;
            if (this.save(ymComment)) {
                YmChatMsg ymChatMsg = new YmChatMsg();
                System.out.println(ymComment);
                String parentId = ymComment.getParentId();
                if (parentId.equals("0")) {
                    YmIntactArticle intactArticle = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, ymComment.getArticleId()).one();
                    ymChatMsg.setAcceptUserId(intactArticle.getUserId());
                    ymChatMsg.setType(MsgEnumType.COMMENT_ARTICLE.getType());
                } else {
                    YmComment comment = this.lambdaQuery().eq(YmComment::getCommentId, parentId).one();
                    ymChatMsg.setType(MsgEnumType.COMMENT_TO_COMMENT.getType());
                    commentUserId = comment.getUserId();
                    ymChatMsg.setAcceptUserId(commentUserId);
                }

                ymChatMsg.setSendUserId(userId);
                ymChatMsg.setImage("");
                ymChatMsg.setSignFlag("0");
                ymChatMsg.setMsg((new JSONObject((Map<String, Object>) ymComment)).toString());
                this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
            }

            YmArticle article = this.intactArticleService.selectJoinOne(
                    YmArticle.class,
                    new MPJLambdaWrapper<YmArticle>()
                            .selectAll(YmArticle.class)
                            .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                            .eq(YmIntactArticle::getIsDeleted, "0")
                            .eq(YmIntactArticle::getIntactArticleId, commentVo.getArticleId())
            );

            YmUser user = this.userService.getById(userId);
            CommentsVo commentsVo = new CommentsVo();
            BeanUtils.copyProperties(ymComment, commentsVo);
            String wasRepliedName = null;
            if (!Objects.isNull(commentUserId)) {
                wasRepliedName = this.userService.lambdaQuery().eq(YmUser::getUserId, commentUserId).one().getUserName();
            }

            commentsVo.setAvatar(user.getAvatar()).setUserName(user.getUserName()).setWasRepliedName(wasRepliedName);
            return commentsVo;
        }
    }
}

