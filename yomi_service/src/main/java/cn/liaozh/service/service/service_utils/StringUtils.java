package cn.liaozh.service.service.service_utils;

import cn.liaozh.pojo.YmSensitiveWord;
import cn.liaozh.service.service.YmSensitiveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringUtils {
    @Autowired
    private YmSensitiveWordService ymSensitiveWordService;
    @Autowired
    private AuthUserUtils authUserUtils;

    public StringUtils() {
    }

    public boolean strFilter(String str) {
        for(YmSensitiveWord ymSensitiveWord : this.ymSensitiveWordService.lambdaQuery().list()) {
            if (str.contains(ymSensitiveWord.getName())) {
                return true;
            }
        }

        return false;
    }
}
