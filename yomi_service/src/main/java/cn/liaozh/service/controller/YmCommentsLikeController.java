package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.service.service.YmCommentsLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping({"/ym_server/comments-like"})
public class YmCommentsLikeController {

    @Autowired
    YmCommentsLikeService commentsLikeService;

    @PutMapping
    public R commentsLike(String userId, @PathParam("id") String id) {
        boolean bol = this.commentsLikeService.commentsLike(userId, id);
        return R.ok().data("点赞操作", bol);
    }
}
