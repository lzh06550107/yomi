package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmChatMsgMapper;
import cn.liaozh.pojo.*;
import cn.liaozh.pojo.vo.MsgChatVo;
import cn.liaozh.pojo.vo.OperObjVo;
import cn.liaozh.pojo.vo.PaginationVO;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.service.service.*;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.AppIsDel;
import cn.liaozh.service_base.enums.ContentType;
import cn.liaozh.service_base.enums.MsgType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.Session;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class YmChatMsgServiceImpl extends MPJBaseServiceImpl<YmChatMsgMapper, YmChatMsg> implements YmChatMsgService {
    @Autowired
    private YmUserService ymUserService;
    @Autowired
    private WebSocketUtils webSocketUtils;
    @Autowired
    private YmIntactArticleService ymIntactArticleService;
    @Autowired
    private YmArticleService ymArticleService;
    @Autowired
    private YmIntactGoodsService ymIntactGoodsService;
    @Autowired
    private YmGoodsService ymGoodsService;
    @Autowired
    private YmCommentService commentService;
    @Autowired
    private YmCommentsService commentsService;

    public List<YmChatMsg> notSignedMsg(String userId) {
        return this.lambdaQuery().eq(YmChatMsg::getType, "0").eq(YmChatMsg::getAcceptUserId, userId).list();
    }

    public List<MsgChatVo> getMsg(String userId) {
        List<MsgChatVo> msgList = new ArrayList<>();
        LambdaQueryChainWrapper<YmUser> userQr = this.ymUserService.lambdaQuery();
        LambdaQueryChainWrapper<YmChatMsg> eq = this.lambdaQuery().eq(YmChatMsg::getAcceptUserId, userId).eq(YmChatMsg::getSignFlag, "0");
        List<YmChatMsg> likeList = eq.in(YmChatMsg::getType, "1", "3", "4", "6").orderByDesc(YmChatMsg::getCreateTime).list();
        List<String> unlikeUserIds = likeList.stream().map(YmChatMsg::getSendUserId).collect(Collectors.toList());
        StringBuffer unlikeStr = new StringBuffer("暂无新消息");
        if (!unlikeUserIds.isEmpty()) {
            unlikeStr = new StringBuffer();
            List<String> unlikeUsers = userQr.in(YmUser::getUserId, unlikeUserIds).list().stream().map(YmUser::getUserName).collect(Collectors.toList());
            int unLikeSize = unlikeUsers.size();
            if (unLikeSize > 3) {
                unlikeUsers = unlikeUsers.subList(0, 3);
            }

            for(int i = 0; i < unlikeUsers.size(); ++i) {
                if (i == unlikeUsers.size() - 1) {
                    unlikeStr.append((String)unlikeUsers.get(i));
                } else {
                    unlikeStr.append((String)unlikeUsers.get(i) + "、");
                }
            }

            if (unLikeSize > 3) {
                unlikeStr.append("等" + unlikeUsers.size() + "人点赞了你");
            } else {
                unlikeStr.append("点赞了你");
            }
        }

        msgList.add(new MsgChatVo(likeList.size(), unlikeStr.toString(), MsgType.LIKE.getCode()));
        LambdaQueryChainWrapper<YmChatMsg> systemQr = this.lambdaQuery().eq(YmChatMsg::getAcceptUserId, userId).eq(YmChatMsg::getSignFlag, "0").eq(YmChatMsg::getType, "0");
        List<YmChatMsg> list = systemQr.orderByDesc(YmChatMsg::getCreateTime).list();
        String sysMsg = !list.isEmpty() ? "您收到新的系统通知" : "暂无新消息";
        msgList.add(new MsgChatVo(systemQr.count(), sysMsg, MsgType.SYSTEM.getCode()));
        List<YmChatMsg> commentList = this.lambdaQuery().eq(YmChatMsg::getAcceptUserId, userId).eq(YmChatMsg::getSignFlag, "0").in(YmChatMsg::getType, "2", "5", "7").orderByDesc(YmChatMsg::getCreateTime).list();
        List<String> uncommentUserIds = commentList.stream().map(YmChatMsg::getSendUserId).collect(Collectors.toList());
        StringBuffer commentUserBuffer = new StringBuffer("暂无新消息");
        if (uncommentUserIds.size() != 0) {
            commentUserBuffer = new StringBuffer();
            List<String> unComments = this.ymUserService.lambdaQuery().in(YmUser::getUserId, uncommentUserIds).list().stream().map(YmUser::getUserName).collect(Collectors.toList());
            int unCommentSize = unComments.size();
            if (unCommentSize > 3) {
                unComments = unComments.subList(0, 3);
            }

            for(int i = 0; i < unComments.size(); ++i) {
                if (i == unComments.size() - 1) {
                    commentUserBuffer.append((String)unComments.get(i));
                } else {
                    commentUserBuffer.append((String)unComments.get(i) + "、");
                }
            }

            if (unCommentSize > 3) {
                commentUserBuffer.append("等" + unCommentSize + "人评论了你");
            } else {
                commentUserBuffer.append("评论了你");
            }
        }

        msgList.add(new MsgChatVo(commentList.size(), commentUserBuffer.toString(), MsgType.COMMENT.getCode()));
        int msgUnreadNum = this.lambdaQuery().eq(YmChatMsg::getAcceptUserId, userId).eq(YmChatMsg::getType, MsgEnumType.USER_SEND_MSG.getType()).eq(YmChatMsg::getSignFlag, AppIsDel.NOT_DELETE.getCode()).list().size();
        String msgTips = msgUnreadNum == 0 ? "暂无私信消息" : MsgType.MSG.getTips();
        msgList.add(new MsgChatVo(msgUnreadNum, msgTips, MsgType.MSG.getCode()));
        return msgList;
    }

    public Page<YmChatMsg> getTypeMsg(String userId, String type, Integer page, Integer size) {
        boolean isMsgType = type.equals(MsgType.MSG.getCode());
        LambdaQueryChainWrapper<YmChatMsg> eq = this.lambdaQuery().eq(YmChatMsg::getAcceptUserId, userId);
        LambdaQueryChainWrapper<YmChatMsg> qr = null;
        if (type.equals(MsgType.LIKE.getCode())) {
            qr = eq.in(YmChatMsg::getType, "1", "3", "4", "6");
        } else if (type.equals(MsgType.SYSTEM.getCode())) {
            qr = eq.eq(YmChatMsg::getType, "0");
        } else if (type.equals(MsgType.COMMENT.getCode())) {
            qr = eq.in(YmChatMsg::getType, "2", "5", "7");
        } else if (isMsgType) {
            qr = eq.eq(YmChatMsg::getType, "8");
        }

        List<String> idList = qr.list().stream().map(YmChatMsg::getId).collect(Collectors.toList());
        if (idList.isEmpty()) {
            return new Page();
        } else {
            Page<YmChatMsg> chatMsgPage = new Page();
            if (isMsgType) {
                List<YmChatMsg> msgList = this.baseMapper.selectMsgList(userId, PaginationVO.pageBuild(page, size));
                long total = this.lambdaQuery().select(YmChatMsg::getId).eq(YmChatMsg::getType, MsgEnumType.USER_SEND_MSG.getType()).eq(YmChatMsg::getAcceptUserId, userId).groupBy(YmChatMsg::getSendUserId).list().size();
                chatMsgPage.setRecords(msgList).setSize((long)size).setCurrent((long)page).setTotal(total).setPages((total - 1L) / (long)size + 1L);
            } else {
                this.updateUnReadNum(idList, userId);
                chatMsgPage = qr.orderByDesc(YmChatMsg::getCreateTime).page(new Page((long)page, (long)size));
            }

            List<YmChatMsg> records = chatMsgPage.getRecords();
            List<YmChatMsg> resultList = new ArrayList();

            for(YmChatMsg item : records) {
                String msg = item.getMsg();
                JSONObject jsonObject = new JSONObject();
                String msgType = item.getType();
                if (!isMsgType) {
                    new JSONObject();
                    jsonObject = JSONObject.parseObject(msg);
                }

                OperObjVo operObjVo = new OperObjVo();
                if (!msgType.equals("1") && !msgType.equals("4")) {
                    if (!msgType.equals("2") && !msgType.equals("5") && !msgType.equals("7")) {
                        if (msgType.equals("6")) {
                            String commentId = jsonObject.getString("commentId");
                            YmComments comments = this.commentsService.lambdaQuery().eq(YmComments::getCommentId, commentId).one();
                            operObjVo.setType(ContentType.ARTICLE.getCode());
                            item.setContent(comments.getContent());
                            operObjVo.setCommonId(comments.getTargetId());
                            YmIntactGoods intactGoods = this.ymIntactGoodsService.lambdaQuery().eq(YmIntactGoods::getIntactGoodsId, comments.getTargetId()).one();
                            YmGoods ymGoods = this.ymGoodsService.lambdaQuery().eq(YmGoods::getGoodsId, intactGoods.getGoodsId()).one();
                            operObjVo.setType(ContentType.GOODS.getCode());
                            item.setContent(ymGoods.getGoodsName());
                            operObjVo.setCommonId(comments.getTargetId());
                        } else if (msgType.equals("3")) {
                            String commentId = jsonObject.getString("commentId");
                            YmComment comment = this.commentService.lambdaQuery().eq(YmComment::getCommentId, commentId).one();
                            YmIntactArticle intactArticle = this.ymIntactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, comment.getArticleId()).one();
                            if (Objects.isNull(intactArticle)) {
                                continue;
                            }

                            YmArticle article = this.ymArticleService.lambdaQuery().eq(YmArticle::getArticleId, intactArticle.getArticleId()).one();
                            operObjVo.setType(ContentType.ARTICLE.getCode());
                            item.setContent(article.getTitle());
                            operObjVo.setCommonId(comment.getArticleId());
                        } else if (msgType.equals("0")) {
                            item.setContent(jsonObject.getString("idea"));
                        }
                    } else {
                        String targetId = jsonObject.getString("targetId");
                        String articleId = jsonObject.getString("articleId");
                        if (targetId != null) {
                            YmIntactGoods goods = this.ymIntactGoodsService.lambdaQuery().eq(YmIntactGoods::getIntactGoodsId, targetId).one();
                            if (Objects.isNull(goods)) {
                                continue;
                            }

                            YmGoods ymGoods = this.ymGoodsService.lambdaQuery().eq(YmGoods::getGoodsId, goods.getGoodsId()).one();
                            item.setContent(ymGoods.getGoodsName());
                            operObjVo.setType(ContentType.GOODS.getCode());
                            operObjVo.setCommonId(targetId);
                        }

                        if (articleId != null) {
                            YmIntactArticle ymIntactArticle = this.ymIntactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, articleId).one();
                            if (Objects.isNull(ymIntactArticle)) {
                                continue;
                            }

                            YmArticle ymArticle = this.ymArticleService.lambdaQuery().eq(YmArticle::getArticleId, ymIntactArticle.getArticleId()).one();
                            operObjVo.setType(ContentType.ARTICLE.getCode());
                            item.setContent(ymArticle.getTitle());
                            operObjVo.setCommonId(articleId);
                        }

                        if (msgType.equals("7")) {
                            String content = jsonObject.getString("content");
                            item.setContent(content);
                        }
                    }
                } else {
                    String articleId = jsonObject.getString("articleId");
                    if (msgType.equals("1")) {
                        YmArticle ymArticle = this.ymArticleService.lambdaQuery().eq(YmArticle::getArticleId, articleId).one();
                        YmIntactArticle ymIntactArticle = this.ymIntactArticleService.lambdaQuery().eq(YmIntactArticle::getArticleId, articleId).one();
                        if (Objects.isNull(ymIntactArticle)) {
                            continue;
                        }

                        operObjVo.setCommonId(ymIntactArticle.getIntactArticleId());
                        operObjVo.setType(ContentType.ARTICLE.getCode());
                        item.setContent(ymArticle.getTitle());
                    } else if (articleId == null) {
                        String commentId = jsonObject.getString("commentId");
                        YmComment ymComment = this.commentService.lambdaQuery().eq(YmComment::getCommentId, commentId).one();
                        String ymCommentArticleId = ymComment.getArticleId();
                        YmIntactArticle ymIntactArticle = this.ymIntactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, ymCommentArticleId).one();
                        if (Objects.isNull(ymIntactArticle)) {
                            continue;
                        }

                        String articleArticleId = ymIntactArticle.getArticleId();
                        YmArticle ymArticle = this.ymArticleService.lambdaQuery().eq(YmArticle::getArticleId, articleArticleId).one();
                        operObjVo.setCommonId(ymCommentArticleId);
                        operObjVo.setType(ContentType.ARTICLE.getCode());
                        item.setContent(ymArticle.getTitle());
                    }
                }

                String sendUserId = item.getSendUserId();
                item.setSendUser(this.getSendUser(sendUserId));
                if (!isMsgType) {
                    item.setTips(this.getTips(msgType));
                }

                item.setOperObj(operObjVo);
                resultList.add(item);
            }

            chatMsgPage.setRecords(Optional.ofNullable(resultList).orElse(Collections.emptyList()));
            return chatMsgPage;
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean sendMsg(YmChatMsg chatMsg) {
        String acceptUserId = chatMsg.getAcceptUserId();
        WebSocketUtils var10000 = this.webSocketUtils;
        Session acceptSession = WebSocketUtils.ONLINE_USER_SESSIONS.getOrDefault(acceptUserId, null);
        if (Objects.isNull(acceptSession)) {
            return this.webSocketUtils.sendUnreadMessagesNum(chatMsg);
        } else {
            boolean var5;
            if (this.save(chatMsg)) {
                WebSocketUtils var4 = this.webSocketUtils;
                if (WebSocketUtils.sendMessage(acceptSession, JSON.toJSONString(chatMsg))) {
                    var5 = true;
                    return var5;
                }
            }

            var5 = false;
            return var5;
        }
    }

    public Page<YmChatMsg> getMsgDetail(String userId, String sendUserId, Integer page, Integer size) {
        Page<YmChatMsg> resultPage = this.lambdaQuery()
                .eq(YmChatMsg::getType, MsgEnumType.USER_SEND_MSG.getType())
                .and(wrapper -> wrapper
                        .eq(YmChatMsg::getSendUserId, sendUserId)
                        .eq(YmChatMsg::getAcceptUserId, userId)
                        .or(orWrapper -> orWrapper
                                .eq(YmChatMsg::getAcceptUserId, sendUserId)
                                .eq(YmChatMsg::getSendUserId, userId)
                        )
                )
                .page(new Page<>(page, size));
        List<YmChatMsg> resultList = resultPage.getRecords();
        resultList = resultList.stream().sorted(Comparator.comparing(YmChatMsg::getCreateTime).reversed()).collect(Collectors.toList());

        for(YmChatMsg chatMsg : resultList) {
            chatMsg.setSendUser(this.getSendUser(chatMsg.getSendUserId()));
        }

        List<String> idList = resultList.stream().filter((p) -> p.getSignFlag().equals("0")).map(YmChatMsg::getId).collect(Collectors.toList());
        this.updateUnReadNum(idList, userId);

        for(YmChatMsg chatMsg : resultList) {
            chatMsg.setContent(chatMsg.getMsg());
        }

        resultPage.setRecords(resultList);
        return resultPage;
    }

    private UserInfoVo getSendUser(String sendUserId) {
        UserInfoVo userInfoVo = new UserInfoVo();
        if (!sendUserId.equals("0")) {
            YmUser user = this.ymUserService.lambdaQuery().select(YmUser::getUserName, YmUser::getUserId, YmUser::getAvatar).eq(YmUser::getUserId, sendUserId).one();
            userInfoVo.setUserName(user.getUserName()).setAvatar(user.getAvatar()).setUserId(user.getUserId());
        } else {
            userInfoVo = new UserInfoVo();
            userInfoVo.setUserName("管理员");
            userInfoVo.setId(0);
            userInfoVo.setUserId("0");
        }

        return userInfoVo;
    }

    private String getTips(String msgType) {
        String tips = "";
        switch (msgType) {
            case "0":
                tips = "已收到您的反馈：";
                break;
            case "1":
                tips = "赞了您的文章：";
                break;
            case "2":
                tips = "评论了您的文章：";
                break;
            case "3":
                tips = "赞了您的评论：";
                break;
            case "4":
                tips = "赞了您的商品：";
                break;
            case "5":
                tips = "评论了您的商品：";
                break;
            case "6":
                tips = "赞了您的评论：";
                break;
            case "7":
                tips = "回复了您的评论：";
        }

        return tips;
    }

    private boolean updateUnReadNum(List<String> idList, String userId) {
        if (idList.isEmpty()) {
            return true;
        } else {
            boolean isUpdate = this.lambdaUpdate().in(YmChatMsg::getId, idList).set(YmChatMsg::getSignFlag, "1").update();
            this.webSocketUtils.flushUnreadMessagesNum(userId);
            return isUpdate;
        }
    }
}
