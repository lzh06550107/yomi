package cn.liaozh.dao;

import cn.liaozh.pojo.YmFans;
import cn.liaozh.pojo.YmQueryUser;
import cn.liaozh.pojo.vo.UserInfoVo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface YmFansMapper extends MPJBaseMapper<YmFans> {
    int updateFans(YmFans fans);

    int selectFans(YmFans fans);

    int deleteFansData();

    List<UserInfoVo> findByIds(@Param("ids") ArrayList<String> ids);

    YmFans getOneFans(@Param("userId") String userId, @Param("id") String id);

    void attention(@Param("fansId") String fansId);

    void noAttention(@Param("fansId") String fansId);

    List<YmQueryUser> queryUserId(@Param("collect") List<String> collect);
}
