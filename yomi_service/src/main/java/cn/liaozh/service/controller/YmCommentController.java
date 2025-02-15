package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.vo.CommentDTO;
import cn.liaozh.pojo.vo.CommentVo;
import cn.liaozh.pojo.vo.CommentsVo;
import cn.liaozh.pojo.vo.OneComment;
import cn.liaozh.service.service.YmCommentService;
import cn.liaozh.service.service.service_utils.AuthUserUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping({"/ym_server/comment"})
@Validated
public class YmCommentController {

    @Resource
    private YmCommentService ymCommentService;
    @Autowired
    private AuthUserUtils authUserUtils;

    public YmCommentController() {
    }

    @PostMapping({"/commentParent"})
    public R addCommentParent(String userId, @RequestBody CommentVo commentVo) {
        if (userId.equals(commentVo.getUserId())) {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }

        if (!this.authUserUtils.isAuthUser(userId)) {
            return R.error().message("未认证，请先认证再发布商品");
        } else {
            this.ymCommentService.saveCommentParent(commentVo);
            return R.ok().message("回复成功");
        }
    }

    @GetMapping({"/commentList/{articleId}/{current}"})
    public R queryComment(String userId, @PathVariable("articleId") String articleId, @PathVariable("current") int current) {
        List<OneComment> ymComments = this.ymCommentService.queryComment(userId, articleId, current);
        return R.ok().data("list", ymComments);
    }

    @DeleteMapping({"{commentId}"})
    public R removeOneComment(String userId, @PathVariable String commentId) {
        boolean isRemove = this.ymCommentService.removeOneComment(commentId, userId);
        return isRemove ? R.ok() : R.error();
    }

    @PostMapping({"imgComment"})
    public R uploadImgComment(@RequestParam MultipartFile file, @RequestParam("articleId") String articleId, String userId) {
        if (!this.authUserUtils.isAuthUser(userId)) {
            return R.error().message("未认证，请先认证再发布商品");
        } else {
            this.ymCommentService.saveCommentImg(file, articleId, userId);
            return R.ok().message("添加成功");
        }
    }

    @GetMapping
    public R queryOneComment(String userId, @PathParam("articleId") String articleId, @RequestParam(required = false) String parentId, @PathParam("page") Integer page) {
        boolean commentIdIsEmpty = Objects.isNull(parentId) || parentId.equals("0");
        Page<CommentsVo> commentsVoPage = commentIdIsEmpty ? this.ymCommentService.queryOneComment(userId, articleId, page) : this.ymCommentService.queryTwoComment(userId, articleId, parentId, page);
        return R.ok().data("list", commentsVoPage);
    }

    @PostMapping
    public R comment(String userId, @RequestBody CommentDTO commentVo) {
        if (!this.authUserUtils.isAuthUser(userId)) {
            return R.error().message("未认证，请先认证再发布商品");
        } else {
            Object comment = this.ymCommentService.updateComment(userId, commentVo);
            return R.ok().data("comment", comment);
        }
    }
}
