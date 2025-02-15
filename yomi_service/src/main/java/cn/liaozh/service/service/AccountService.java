package cn.liaozh.service.service;

import cn.liaozh.pojo.YmCaptcha;
import cn.liaozh.pojo.dto.LoginParams;
import cn.liaozh.pojo.vo.LoginUserVo;
import cn.liaozh.pojo.vo.WxLoginVo;

import java.io.IOException;

public interface AccountService {

    LoginUserVo loginUser(WxLoginVo loginVo) throws IOException;

    boolean register(LoginParams params);

    boolean captcha(String email);

    LoginUserVo pwdLogin(LoginParams params);

    boolean validationCaptcha(YmCaptcha captcha, boolean isRemove);

    boolean resetPassword(LoginParams loginParams);

    boolean deleteCaptchaByEmail(String email);
}
