package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmArticleLikeMapper;
import cn.liaozh.pojo.YmArticle;
import cn.liaozh.pojo.YmArticleLike;
import cn.liaozh.pojo.YmChatMsg;
import cn.liaozh.pojo.YmIntactArticle;
import cn.liaozh.pojo.vo.ArticleIdVo;
import cn.liaozh.pojo.vo.ArticleLikeStatus;
import cn.liaozh.service.service.YmArticleLikeService;
import cn.liaozh.service.service.YmArticleService;
import cn.liaozh.service.service.YmIntactArticleService;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class YmArticleLikeServiceImpl extends MPJBaseServiceImpl<YmArticleLikeMapper, YmArticleLike> implements YmArticleLikeService {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    YmIntactArticleService intactArticleService;
    @Autowired
    YmArticleService articleService;
    @Autowired
    YmArticleLikeService likeService;
    @Autowired
    private WebSocketUtils webSocketUtils;

    public YmArticleLikeServiceImpl() {
    }

    public List<ArticleLikeStatus> likeStatus(String userid, ArticleIdVo vo) {
        String s = vo.getId();
        String[] userids = s.split(",");
        List<String> strings = Arrays.asList(userids);
        ArrayList<ArticleLikeStatus> articleLikeStatuses = new ArrayList();
        strings.forEach((temp) -> {
            String JSONStr = (String)this.redisTemplate.opsForHash().get("ArticleLikeStatus", userid + "::" + temp);
            if (JSONStr != null) {
                ArticleLikeStatus articleLikeStatus = new ArticleLikeStatus();
                articleLikeStatus.setArticleId(temp);
                articleLikeStatus.setLikeState(JSONStr);
                articleLikeStatuses.add(articleLikeStatus);
            }

        });
        return articleLikeStatuses;
    }

    public boolean findLike(String userId, String articleId) {
        boolean flag = this.redisTemplate.opsForSet().isMember("articleId_" + articleId, "user_" + userId);
        boolean bl;
        if (flag) {
            this.redisTemplate.opsForSet().remove("articleId_" + articleId, new Object[]{"user_" + userId});
            bl = false;
        } else {
            YmArticleLike articleLike = this.lambdaQuery().eq(YmArticleLike::getUserId, userId).eq(YmArticleLike::getArticleId, articleId).one();
            this.redisTemplate.opsForSet().add("articleId_" + articleId, new String[]{"user_" + userId});
            bl = true;
        }

        return bl;
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean updateLike(String userId, String articleId) {
        YmIntactArticle ymIntactArticle = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, articleId).one();
        String id = ymIntactArticle.getArticleId();
        YmArticleLike one = this.likeService.lambdaQuery().eq(YmArticleLike::getUserId, userId).eq(YmArticleLike::getArticleId, id).one();
        LambdaQueryChainWrapper<YmArticle> qr = this.articleService.lambdaQuery();
        YmArticle ymArticle = qr.eq(YmArticle::getArticleId, id).eq(YmArticle::getIsDeleted, "0").one();
        YmChatMsg ymChatMsg = new YmChatMsg();
        ymChatMsg.setType(MsgEnumType.LIKE_ARTICLE.getType());
        ymChatMsg.setSendUserId(userId);
        ymChatMsg.setAcceptUserId(ymIntactArticle.getUserId());
        ymChatMsg.setImage("");
        ymChatMsg.setSignFlag("0");
        if (one == null) {
            YmArticleLike articleLike = new YmArticleLike();
            articleLike.setArticleId(id);
            articleLike.setLikeState("0");
            articleLike.setUserId(userId);
            ymArticle.setLikeNum(ymArticle.getLikeNum() + 1);
            if (this.likeService.saveOrUpdate(articleLike) && this.articleService.saveOrUpdate(ymArticle)) {
                ymChatMsg.setMsg((new JSONObject(articleLike)).toString());
                this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
                return true;
            } else {
                throw new YmException(ExecutionResult.LIKE_CODE_501);
            }
        } else {
            if (one.getLikeState().equals("1")) {
                one.setLikeState("0");
                ymArticle.setLikeNum(ymArticle.getLikeNum() + 1);
            } else if (ymArticle.getLikeNum() >= 1) {
                one.setLikeState("1");
                ymArticle.setLikeNum(ymArticle.getLikeNum() - 1);
            }

            return this.likeService.saveOrUpdate(one) && this.articleService.saveOrUpdate(ymArticle);
        }
    }
}
