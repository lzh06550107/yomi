package cn.liaozh.service.service;

import cn.liaozh.pojo.YmComments;
import cn.liaozh.pojo.vo.AddCommentsVo;
import cn.liaozh.pojo.vo.AllCommentsVo;
import cn.liaozh.pojo.vo.CommentsVo;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

public interface YmCommentsService extends MPJBaseService<YmComments> {

    Object getLevelOneComments(String userId, String id, Integer page);

    Object getLevelTwoComments(String userId, String id, Integer page);

    CommentsVo addComments(String userId, AddCommentsVo commentsVo);

    boolean removeComment(String userId, String commentId);

    List<AllCommentsVo> getComments(String userId, String id);

    boolean CommentsLike(String userId, String id);
}
