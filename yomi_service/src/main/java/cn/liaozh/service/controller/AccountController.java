package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmCaptcha;
import cn.liaozh.pojo.YmQueryUser;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.pojo.dto.LoginParams;
import cn.liaozh.pojo.vo.LoginUserVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.pojo.vo.WxLoginVo;
import cn.liaozh.service.service.AccountService;
import cn.liaozh.service.service.YmCaptchaService;
import cn.liaozh.service.service.YmQueryUserService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service.service.service_utils.UserTagUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping({"/ym_server/account"})
@CrossOrigin
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;
    @Autowired
    private YmUserService ymUserService;
    @Autowired
    private UserTagUtils userTagUtils;
    @Autowired
    private YmQueryUserService queryUserService;
    @Autowired
    private YmCaptchaService captchaService;

    public AccountController() {
    }

    @PostMapping({"/login"})
    public R Login(@RequestBody WxLoginVo loginVo) throws IOException {
        LoginUserVo userData = this.accountService.loginUser(loginVo);
        log.info(String.valueOf(userData));
        return R.ok().data("login", userData);
    }

    @GetMapping({"/userInfo"})
    public R getUserInfo(String userId) {
        YmUser ymUser = this.ymUserService.lambdaQuery().eq(YmUser::getUserId, userId).one();
        if (ymUser == null) {
            throw new YmException(ExecutionResult.USER_CODE_101);
        } else {
            UserInfoVo userInfoVo = new UserInfoVo();
            BeanUtils.copyProperties(ymUser, userInfoVo);
            if (this.userTagUtils.isGoodUser(ymUser.getUserId())) {
                userInfoVo.setGoodUser(1);
            }

            YmQueryUser ymQueryUser = this.queryUserService.lambdaQuery().eq(YmQueryUser::getUserId, userId).one();
            userInfoVo.setId(ymQueryUser.getQueryId());
            return R.ok().data("user", userInfoVo);
        }
    }

    @PostMapping({"register"})
    public R register(@RequestBody LoginParams params) {
        boolean isReg = this.accountService.register(params);
        return isReg ? R.ok() : R.error();
    }

    @PostMapping({"captcha"})
    public R captcha(@RequestBody YmCaptcha captcha) {
        boolean isSend = this.accountService.captcha(captcha.getEmail());
        return isSend ? R.ok() : R.error();
    }

    @PostMapping({"auth"})
    public R pwdLogin(@RequestBody LoginParams params) {
        LoginUserVo loginUserVo = this.accountService.pwdLogin(params);
        return R.ok().data("user", loginUserVo);
    }

    @PostMapping({"validation-captcha/{type}"})
    public R validationCaptcha(@RequestBody YmCaptcha captcha, @PathVariable String type) {
        boolean isRemove = false;
        if (type.equals("ruin")) {
            isRemove = true;
        } else if (!type.equals("nay")) {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }

        boolean isFlag = this.accountService.validationCaptcha(captcha, isRemove);
        return isFlag ? R.ok() : R.error();
    }

    @PostMapping({"reset-password"})
    public R resetPassword(@RequestBody LoginParams loginParams) {
        boolean isReset = this.accountService.resetPassword(loginParams);
        return isReset ? R.ok() : R.error();
    }

    @GetMapping({"captcha"})
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public void getCaptcha(@RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.accountService.deleteCaptchaByEmail(email);
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        specCaptcha.setCharType(2);
        CaptchaUtil.out(specCaptcha, request, response);
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        String captcha = (String)request.getSession().getAttribute("captcha");
        log.info("生成图像验证码:{}", captcha);
        this.captchaService.save(new YmCaptcha(email, captcha));
    }
}

