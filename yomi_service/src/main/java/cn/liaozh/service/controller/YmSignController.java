package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmSign;
import cn.liaozh.service.service.YmSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ym_server/sign"})
public class YmSignController {

    @Autowired
    private YmSignService ymSignService;

    @PostMapping({"/in"})
    public R postSignIn(String userId) {
        YmSign signListByUserId = this.ymSignService.findSignListByUserId(userId);
        if (userId.equals(signListByUserId.getUserId())) {
            return R.ok().message("今天已经签到了");
        } else {
            this.ymSignService.postSignIn(userId);
            return R.ok().message("签到成功");
        }
    }

    @GetMapping({"/count"})
    public R findSignCount(String userId) {
        YmSign signCount = this.ymSignService.findSignCount(userId);
        return R.ok().data("sign", signCount);
    }
}
