package cn.liaozh.service.service;

import cn.liaozh.pojo.YmSign;
import com.baomidou.mybatisplus.extension.service.IService;

public interface YmSignService extends IService<YmSign> {

    YmSign findSignListById(String signId);

    void postSignIn(String userId);

    YmSign findSignByUserId(String userId);

    YmSign findSignCount(String token);

    YmSign IsTime(String token);

    YmSign findSignListByUserId(String userId);
}
