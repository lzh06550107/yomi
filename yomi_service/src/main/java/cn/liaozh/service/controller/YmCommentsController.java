package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.vo.AddCommentsVo;
import cn.liaozh.pojo.vo.AllCommentsVo;
import cn.liaozh.pojo.vo.CommentsVo;
import cn.liaozh.service.service.YmCommentsService;
import cn.liaozh.service.service.service_utils.AuthUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping({"/ym_server/comments"})
public class YmCommentsController {

    @Autowired
    YmCommentsService commentsService;
    @Autowired
    private AuthUserUtils authUserUtils;

    @GetMapping
    public R getLevelOneComments(String userId, @PathParam("goodsId") String goodsId, @PathParam("page") Integer page, @PathParam("parentId") String parentId) {
        Object levelOneComments = Objects.isNull(parentId) ? this.commentsService.getLevelOneComments(userId, goodsId, page) : this.commentsService.getLevelTwoComments(userId, parentId, page);
        return R.ok().data("list", levelOneComments);
    }

    @GetMapping({"getComments"})
    public R getComments(String userId, @PathParam("id") String id) {
        List<AllCommentsVo> list = this.commentsService.getComments(userId, id);
        return R.ok().data("list", list);
    }

    @PutMapping({"CommentsLike"})
    public R CommentsLike(String userId, @PathParam("id") String id) {
        boolean bul = this.commentsService.CommentsLike(userId, id);
        return R.ok().data("点赞操作", bul);
    }

    @PostMapping
    public R addComments(String userId, @RequestBody AddCommentsVo commentsVo) {
        if (!this.authUserUtils.isAuthUser(userId)) {
            return R.error().message("未认证，请先认证再发布商品");
        } else {
            CommentsVo comments = this.commentsService.addComments(userId, commentsVo);
            return comments == null ? R.error() : R.ok().data("comment", comments);
        }
    }

    @DeleteMapping
    public R deleteComment(String userId, @PathParam("commentId") String commentId) {
        boolean bol = this.commentsService.removeComment(userId, commentId);
        return bol ? R.ok() : R.error();
    }
}
