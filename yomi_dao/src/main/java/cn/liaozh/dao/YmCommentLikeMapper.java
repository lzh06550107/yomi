package cn.liaozh.dao;

import cn.liaozh.pojo.YmCommentLike;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YmCommentLikeMapper extends MPJBaseMapper<YmCommentLike> {
    int updateState(String userId, String commentId);
}
