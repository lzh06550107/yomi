package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.service.service.YmArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ym_server/article-like"})
public class YmArticleLikeController {

    @Autowired
    YmArticleLikeService ymArticleLikeService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping({"{articleId}"})
    public R updateLike(String userId, @PathVariable String articleId) {
        boolean isLike = this.ymArticleLikeService.updateLike(userId, articleId);
        return isLike ? R.ok() : R.error();
    }
}
