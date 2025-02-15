package cn.liaozh.service.controller;

import cn.liaozh.common.nonEmptyJudgment.ObjectUtils;
import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmConfig;
import cn.liaozh.service.service.YmConfigService;
import cn.liaozh.service_base.enums.ConfigKey;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/ym_server/config"})
public class YmConfigController {

    @Autowired
    private YmConfigService configService;

    private boolean isAdmin(String userId) {
        return userId.equals("1610801362600222722");
    }

    @PostMapping
    public R addConfig(String userId, @RequestBody YmConfig config) {
        if (!this.isAdmin(userId)) {
            return R.error().message("Auth Error");
        } else {
            boolean isSave = this.configService.save(config);
            return isSave ? R.ok() : R.error();
        }
    }

    @PostMapping({"msg"})
    public R addMsgConfig(String userId, @RequestBody List<YmConfig> configList) {
        if (!this.isAdmin(userId)) {
            return R.error().message("Auth Error");
        } else {
            configList = configList.stream().filter((p) -> ObjectUtils.isNotEmpty(p.getImageLink())).peek((c) -> c.setConfigKey(ConfigKey.CHAT_MSG.getKey())).collect(Collectors.toList());
            boolean isSave = this.configService.saveBatch(configList);
            return isSave ? R.ok() : R.error();
        }
    }

    @GetMapping({"msg"})
    public R getMsgConfig() {
        List<YmConfig> configList = this.configService.lambdaQuery().eq(YmConfig::getConfigKey, ConfigKey.CHAT_MSG.getKey()).orderByAsc(YmConfig::getSort).list();
        return R.ok().data("list", configList);
    }

    @PutMapping({"msg"})
    public R editMsgConfig(String userId, @RequestBody List<YmConfig> configList) {
        if (!this.isAdmin(userId)) {
            return R.error().message("Auth Error");
        } else {
            configList = configList.stream().filter((p) -> ObjectUtils.isNotEmpty(p.getImageLink()) || ObjectUtils.isNotEmpty(p.getConfigId())).peek((c) -> c.setConfigKey(ConfigKey.CHAT_MSG.getKey())).collect(Collectors.toList());
            boolean isUpdate = this.configService.updateBatchById(configList);
            return isUpdate ? R.ok() : R.error();
        }
    }
}
