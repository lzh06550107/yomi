package cn.liaozh.service.service.impl;

import cn.liaozh.common.EncryptUtil;
import cn.liaozh.common.email.MailUtils;
import cn.liaozh.common.jwt.JwtUtil;
import cn.liaozh.common.request.RequestUtils;
import cn.liaozh.pojo.YmCaptcha;
import cn.liaozh.pojo.YmQueryUser;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.pojo.dto.LoginParams;
import cn.liaozh.pojo.vo.LoginUserVo;
import cn.liaozh.pojo.vo.WxLoginVo;
import cn.liaozh.service.service.AccountService;
import cn.liaozh.service.service.YmCaptchaService;
import cn.liaozh.service.service.YmQueryUserService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service_base.enums.AppIsDel;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private YmUserService userService;
    @Autowired
    StringRedisTemplate fredisTemplate;
    @Autowired
    private YmQueryUserService queryUserService;
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private YmCaptchaService captchaService;
    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.secret}")
    private String secret;

    @Transactional(
            rollbackFor = {ArithmeticException.class}
    )
    public LoginUserVo loginUser(WxLoginVo loginVo) throws IOException {

        LoginUserVo loginUserVo = new LoginUserVo();
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        url = url + "?appid=" + this.appid;
        url = url + "&secret=" + this.secret;
        url = url + "&js_code=" + loginVo.getCode();
        url = url + "&grant_type=authorization_code";
        url = url + "&connect_redirect=1";
        log.info("js_code" + loginVo.getCode());
        JSONObject jo = RequestUtils.getUrlResult(url);
        log.info(String.valueOf(jo));
        String openId = jo.getString("openid");
        log.info("openid>>>" + openId);
        if (openId == null) {
            openId = "openId-" + UUID.randomUUID().toString().substring(0, 8);
        }

        YmUser userData = new YmUser();
        BeanUtils.copyProperties(loginVo, userData);
        userData.setOpenId(openId);
        YmUser user = this.userService.selectByOpenId(openId);
        boolean userNotExist = user == null;
        boolean saveFlag = false;
        if (userNotExist) {
            saveFlag = this.userService.save(userData);
            user = this.userService.selectByOpenId(openId);
        }

        if (!userNotExist && "1".equals(user.getIsDisabled())) {
            throw new YmException(ExecutionResult.USER_CODE_102);
        }

        if (!saveFlag && userNotExist) {
            throw new YmException(ExecutionResult.DATA_CODE_301);
        }

        return this.setUserData(loginUserVo, user);

    }

    public boolean register(LoginParams params) {

        String code = params.getCaptcha();
        String email = params.getEmail();
        String password = params.getPassword();

        if (password.length() < 6) {
            throw new YmException(ExecutionResult.USER_CODE_111);
        }

        boolean isValidation = this.validationCaptcha(new YmCaptcha(email, code), true);
        YmUser user = this.userService.lambdaQuery().eq(YmUser::getEmail, email).one();
        if (!Objects.isNull(user)) {
            throw new YmException(ExecutionResult.USER_CODE_109);
        }

        if (!password.equals(params.getConfirmPwd())) {
            throw new YmException(ExecutionResult.USER_CODE_108);
        }

        if (isValidation) {
            YmUser userData = new YmUser();
            userData.setEmail(email);
            userData.setPassword(EncryptUtil.MD5(password));
            return this.userService.save(userData);
        } else {
            return false;
        }

    }

    public boolean captcha(String email) {

        if (!this.mailUtils.checkEmail(email)) {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }

        long time = System.currentTimeMillis() - 180000L;
        List<YmCaptcha> captchaList = this.captchaService.lambdaQuery().eq(YmCaptcha::getEmail, email).ge(YmCaptcha::getCreateTime, time).list();
        if (!captchaList.isEmpty()) {
            throw new YmException(ExecutionResult.CAPTCHA_CODE_404);
        }

        String code = this.mailUtils.generateVerifyCode(6);
        YmCaptcha captcha = new YmCaptcha();
        captcha.setEmail(email);
        captcha.setCode(code);
        return this.captchaService.save(captcha) && this.mailUtils.sendAuthCodeEmail(captcha);

    }

    public LoginUserVo pwdLogin(LoginParams params) {

        String email = params.getEmail();

        if (!this.mailUtils.checkEmail(email)) {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }

        String captcha = params.getCaptcha();
        this.validationCaptcha(new YmCaptcha(email, captcha), true);
        YmUser user = this.userService.lambdaQuery().eq(YmUser::getEmail, email).one();
        LoginUserVo loginUserVo = new LoginUserVo();
        boolean userNotExist = Objects.isNull(user);
        if (userNotExist) {
            throw new YmException(ExecutionResult.USER_CODE_101);
        }

        if ("1".equals(user.getIsDisabled())) {
            throw new YmException(ExecutionResult.USER_CODE_102);
        }

        if (!Objects.isNull(user.getPassword()) && user.getPassword().equals(EncryptUtil.MD5(params.getPassword()))) {
            return this.setUserData(loginUserVo, user);
        } else {
            throw new YmException(ExecutionResult.USER_CODE_110);
        }

    }

    private LoginUserVo setUserData(LoginUserVo loginUserVo, final YmUser dataUser) {

        final String userId = dataUser.getUserId();
        YmQueryUser queryUser = new YmQueryUser(userId);
        QueryWrapper<YmQueryUser> queryUserWrapper = new QueryWrapper();
        queryUserWrapper.eq("user_id", queryUser.getUserId());
        YmQueryUser queryUserTarget = this.queryUserService.getOne(queryUserWrapper);
        boolean UserIsNullFlag = Objects.isNull(queryUserTarget);
        if (UserIsNullFlag) {
            boolean saveQueryFlag = this.queryUserService.save(queryUser);
            if (!saveQueryFlag) {
                throw new YmException(ExecutionResult.DATA_CODE_301);
            }

            loginUserVo.setId(queryUser.getQueryId());
        } else {
            loginUserVo.setId(queryUserTarget.getQueryId());
        }

        String dataAvatar = dataUser.getAvatar();
        boolean avatarNotExits = Objects.isNull(dataAvatar) || dataAvatar.isEmpty();
        final String avatar = avatarNotExits ? String.format("https://api.multiavatar.com/%s.png", userId) : dataAvatar;
        String dataUserName = dataUser.getUserName();
        boolean userNameNotExits = Objects.isNull(dataUserName) || dataUserName.isEmpty();
        final String userName = userNameNotExits ? String.format("用户%s", loginUserVo.getId()) : dataUserName;
        HashMap<String, String> tokenMessage = new HashMap<String, String>() {
            {
                this.put("name", userName);
                this.put("id", userId);
                this.put("avatar", avatar);
                this.put("sex", dataUser.getSex());
                this.put("time", String.valueOf(System.currentTimeMillis()));
            }
        };
        String token = JwtUtil.createToken(tokenMessage);
        dataUser.setAvatar(avatar);
        dataUser.setUserName(userName);
        boolean isUpdate = this.userService.lambdaUpdate().eq(YmUser::getUserId, userId).update(dataUser);
        if (!isUpdate) {
            throw new YmException(ExecutionResult.DATA_CODE_301);
        } else {
            loginUserVo.setUserId(userId);
            loginUserVo.setToken(token);
            return loginUserVo;
        }
    }

    public boolean validationCaptcha(YmCaptcha captcha, boolean isRemove) {
        String code = captcha.getCode();
        String email = captcha.getEmail();
        if (!this.mailUtils.checkEmail(email)) {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }

        YmCaptcha captchaData = this.captchaService.lambdaQuery().eq(YmCaptcha::getCode, code).eq(YmCaptcha::getEmail, email).one();

        if (Objects.isNull(captchaData)) {
            throw new YmException(ExecutionResult.CAPTCHA_CODE_402);
        }

        long now = System.currentTimeMillis();
        long time = now - Long.parseLong(captchaData.getCreateTime());
        boolean isValidation = captchaData.getIsValidation().equals(AppIsDel.NOT_DELETE.getCode());

        if (isValidation && time > 180000L) {
            throw new YmException(ExecutionResult.CAPTCHA_CODE_403);
        }

        return !isRemove ? this.captchaService.lambdaUpdate().eq(YmCaptcha::getCode, code).eq(YmCaptcha::getEmail, email).update(captchaData.setIsValidation(AppIsDel.DELETED.getCode())) : this.captchaService.lambdaUpdate().eq(YmCaptcha::getCode, code).eq(YmCaptcha::getEmail, email).remove();
    }

    public boolean resetPassword(LoginParams loginParams) {

        String email = loginParams.getEmail();
        String code = loginParams.getCaptcha();

        boolean isValidation = this.validationCaptcha(new YmCaptcha(email, code), true);
        if (!isValidation) {
            return false;
        }

        String password = loginParams.getPassword();
        if (password.length() < 6) {
            throw new YmException(ExecutionResult.USER_CODE_111);
        }

        String confirmPwd = loginParams.getConfirmPwd();
        if (!password.equals(confirmPwd)) {
            throw new YmException(ExecutionResult.USER_CODE_108);
        }

        YmUser user = this.userService.lambdaQuery().eq(YmUser::getEmail, email).one();
        user.setPassword(EncryptUtil.MD5(password));
        return this.userService.lambdaUpdate().eq(YmUser::getUserId, user.getUserId()).update(user);

    }

    public boolean deleteCaptchaByEmail(String email) {

        return this.captchaService.lambdaUpdate().eq(YmCaptcha::getEmail, email).remove();

    }
}
