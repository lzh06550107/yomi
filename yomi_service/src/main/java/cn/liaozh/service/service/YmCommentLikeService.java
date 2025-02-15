package cn.liaozh.service.service;

import cn.liaozh.pojo.YmCommentLike;
import com.github.yulichang.base.MPJBaseService;

public interface YmCommentLikeService extends MPJBaseService<YmCommentLike> {

    YmCommentLike queryUserLike(String userId, String commentId);

    Integer insertLike(YmCommentLike ymCommentLike);

    Integer updateLike(YmCommentLike likeList);

    void updateState(String userId, String commentId);

    void updateLikeState(YmCommentLike ymCommentLike);

    boolean commentsLike(String userId, String id);
}
