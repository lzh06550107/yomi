package cn.liaozh.service.service;

import cn.liaozh.pojo.YmArticleLike;
import cn.liaozh.pojo.vo.ArticleIdVo;
import cn.liaozh.pojo.vo.ArticleLikeStatus;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

public interface YmArticleLikeService extends MPJBaseService<YmArticleLike> {

    List<ArticleLikeStatus> likeStatus(String userid, ArticleIdVo vo);

    boolean updateLike(String userId, String articleId);

    boolean findLike(String userId, String articleId);
}
