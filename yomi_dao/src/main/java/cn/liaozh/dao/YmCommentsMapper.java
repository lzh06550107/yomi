package cn.liaozh.dao;

import cn.liaozh.pojo.YmComments;
import cn.liaozh.pojo.vo.CommentsVo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YmCommentsMapper extends MPJBaseMapper<YmComments> {
    List<CommentsVo> getLevelOneComments(@Param("id") String id);

    List<CommentsVo> getLevelTwoComments(@Param("id") String id);

    Integer removeComment(@Param("userId") String userId, @Param("commentId") String commentId);
}
