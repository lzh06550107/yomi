package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmCommentLike;
import cn.liaozh.service.service.YmCommentLikeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping({"/ym_server/comment-like"})
public class YmCommentLikeController {
    @Resource
    private YmCommentLikeService ymCommentLikeService;

    public YmCommentLikeController() {
    }

    @PostMapping
    public R commentsLike(String userId, @PathParam("commentId") String commentId) {
        boolean isSuccess = this.ymCommentLikeService.commentsLike(userId, commentId);
        return isSuccess ? R.ok() : R.error();
    }

    @Transactional
    @PutMapping({"like"})
    public R likeComment(@RequestBody YmCommentLike ymCommentLike) {
        this.ymCommentLikeService.updateLikeState(ymCommentLike);
        return R.ok();
    }

    @Transactional
    @PutMapping({"state/{userId}/{commentId}"})
    public R likeState(@PathVariable("userId") String userId, @PathVariable("commentId") String commentId) {
        this.ymCommentLikeService.updateState(userId, commentId);
        return R.ok();
    }
}

