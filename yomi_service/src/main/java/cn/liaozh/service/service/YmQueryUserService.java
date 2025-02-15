package cn.liaozh.service.service;

import cn.liaozh.pojo.YmQueryUser;
import cn.liaozh.pojo.vo.UserInfoVo;
import com.github.yulichang.base.MPJBaseService;

public interface YmQueryUserService extends MPJBaseService<YmQueryUser> {

    UserInfoVo selectOne(String queryId);

    Integer selectIdByUserId(String userId);
}
