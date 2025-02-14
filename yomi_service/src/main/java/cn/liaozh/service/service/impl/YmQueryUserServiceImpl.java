package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmQueryUserMapper;
import cn.liaozh.pojo.YmQueryUser;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.service.service.YmQueryUserService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service.service.service_utils.CommonUserUtil;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;

import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class YmQueryUserServiceImpl extends MPJBaseServiceImpl<YmQueryUserMapper, YmQueryUser> implements YmQueryUserService {
    @Resource
    private YmUserService userService;

    public YmQueryUserServiceImpl() {
    }

    public UserInfoVo selectOne(String queryId) {
        YmQueryUser queryUser = (YmQueryUser)((YmQueryUserMapper)this.baseMapper).selectById(queryId);
        if (queryUser == null) {
            throw new YmException(ExecutionResult.USER_CODE_101);
        } else {
            YmUser user = CommonUserUtil.verificationUser(this.userService.selectUserById(queryUser.getUserId()));
            UserInfoVo userVo = new UserInfoVo();
            BeanUtils.copyProperties(user, userVo);
            userVo.setId(Integer.parseInt(queryId));
            return userVo;
        }
    }

    public Integer selectIdByUserId(String userId) {
        return ((YmQueryUser)((LambdaQueryChainWrapper)this.lambdaQuery().eq(YmQueryUser::getUserId, userId)).one()).getQueryId();
    }
}

