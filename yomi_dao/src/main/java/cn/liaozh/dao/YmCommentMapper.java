package cn.liaozh.dao;

import cn.liaozh.pojo.YmComment;
import cn.liaozh.pojo.vo.TwoComment;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YmCommentMapper extends MPJBaseMapper<YmComment> {
    List<TwoComment> findAllComment(List<String> commentList);

    List<TwoComment> findAllTwoComment(String articleId);

    int updateLike(int num, String commentId);

    List<TwoComment> findAllOneComment(String articleId);
}
