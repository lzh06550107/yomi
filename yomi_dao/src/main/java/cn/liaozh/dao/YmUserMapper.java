package cn.liaozh.dao;

import cn.liaozh.pojo.YmIdeafeedback;
import cn.liaozh.pojo.YmUser;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface YmUserMapper extends MPJBaseMapper<YmUser> {
    int updateFansNum(@Param("userId") String userId, @Param("flagNum") int flagNum);

    @Select({"select * from ym_ideafeedback where user_id = #{userId}"})
    List<YmIdeafeedback> getNewsByUserId(@Param("userId") String userId);

    YmUser getUserById(@Param("userId") String userId);
}
