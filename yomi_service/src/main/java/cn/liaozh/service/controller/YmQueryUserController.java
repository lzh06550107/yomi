package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.service.service.YmQueryUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/ym_server/search"})
@CrossOrigin
public class YmQueryUserController {

    @Resource
    private YmQueryUserService queryUserService;

    @GetMapping({"user/{queryId}"})
    public R searchUser(@PathVariable String queryId) {
        UserInfoVo user = this.queryUserService.selectOne(queryId);
        return R.ok().data("user", user);
    }
}
