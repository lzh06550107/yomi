package cn.liaozh.common.email;

import cn.liaozh.pojo.YmCaptcha;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MailUtils {
    @Value("${mail.domail}")
    private String doMail;
    @Value("${mail.smtp}")
    private String smtp;
    @Value("${mail.password}")
    private String password;

    public MailUtils() {
    }

    public boolean sendAuthCodeEmail(YmCaptcha params) {
        String code = params.getCode();

        try {
            HtmlEmail mail = new HtmlEmail();
            mail.setHostName(this.smtp);
            mail.setCharset("UTF-8");
            mail.setAuthentication(this.doMail, this.password);
            mail.setFrom(this.doMail, "启嘉校园");
            mail.setSSLOnConnect(true);
            mail.addTo(params.getEmail());
            mail.setSubject("启嘉校园验证码");
            mail.setMsg("尊敬的启嘉校园用户:您好! 您的验证码为:" + code + "(有效期为三分钟)");
            mail.send();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String generateVerifyCode(int number) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for(int i = 1; i <= number; ++i) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }

    public boolean checkEmail(String email) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*@[A-Za-z\\d]+(([.\\-])[A-Za-z\\d]+)*\\.[A-Za-z\\d]+$";
        Pattern p = Pattern.compile(RULE_EMAIL);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
