package cn.liaozh.service.service;

import cn.liaozh.pojo.YmComment;
import cn.liaozh.pojo.vo.CommentDTO;
import cn.liaozh.pojo.vo.CommentVo;
import cn.liaozh.pojo.vo.CommentsVo;
import cn.liaozh.pojo.vo.OneComment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface YmCommentService extends MPJBaseService<YmComment> {
    Page<CommentsVo> queryTwoComment(String userId, String articleId, String commentId, Integer page);

    Page<CommentsVo> queryOneComment(String userId, String articleId, Integer page);

    void saveComment(YmComment ymComment);

    List<OneComment> queryComment(String userId, String articleId, int current);

    boolean removeTwoComment(String commentId, String userId);

    boolean removeOneComment(String commentId, String userId);

    void saveCommentParent(CommentVo commentVo);

    void saveCommentImg(MultipartFile file, String articleId, String userId);

    void saveCommentImgParent(MultipartFile file, String commentId, String userId);

    Object updateComment(String userId, CommentDTO commentVo);
}
