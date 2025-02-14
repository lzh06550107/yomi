package cn.liaozh.service.service.service_utils;

import cn.liaozh.common.request.RequestUtils;
import cn.liaozh.service.service.YmStrAttestService;
import cn.liaozh.service.service.YmUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class AuthUserUtils {
    @Autowired
    private YmStrAttestService ymStrAttestService;
    @Autowired
    private YmUserService userService;
    @Value("${wechat.appid}")
    private String appid = "wxd751b9be3d3f65b6";
    @Value("${wechat.secret}")
    private String secret = "53ab5c5e906a78a5515573459f8717f7";

    public AuthUserUtils() {
    }

    public boolean isAuthUser(String userId) {
        System.out.println(userId);
        return true;
    }

    public boolean msgCheck(String content) {
        JSONObject accessToken = RequestUtils.getUrlResult("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + this.appid + "&secret=" + this.secret);
        JSONObject paramMap = new JSONObject();
        paramMap.put("content", new String(content.getBytes(), StandardCharsets.UTF_8));
        String result = RequestUtils.sendPost("https://api.weixin.qq.com/wxa/msg_sec_check?access_token=" + accessToken.get("access_token"), paramMap);
        JSONObject json = JSONObject.parseObject(result);
        System.out.println(json);
        boolean flag = false;
        int errCode = 87014;
        if (json.getInteger("errcode") == errCode) {
            flag = true;
        }

        return flag;
    }
}

