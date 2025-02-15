package cn.liaozh.service.service;

import cn.liaozh.pojo.YmCommentsLike;
import com.github.yulichang.base.MPJBaseService;

public interface YmCommentsLikeService extends MPJBaseService<YmCommentsLike> {

    boolean commentsLike(String userId, String id);
}
