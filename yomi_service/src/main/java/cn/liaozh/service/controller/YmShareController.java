package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmShare;
import cn.liaozh.service.service.YmShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ym_server/share"})
public class YmShareController {
    @Autowired
    private YmShareService shareService;

    public YmShareController() {
    }

    @PostMapping({"addShare"})
    public R addShare(String userId, @RequestBody YmShare share) {
        share.setUserId(userId);
        boolean flag = this.shareService.insertShare(share);
        return flag ? R.ok() : R.error();
    }
}
