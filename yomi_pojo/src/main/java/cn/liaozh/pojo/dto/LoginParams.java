package cn.liaozh.pojo.dto;

public class LoginParams {
    private String email;
    private String password;
    private String confirmPwd;
    private String captcha;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPwd() {
        return this.confirmPwd;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public LoginParams setEmail(final String email) {
        this.email = email;
        return this;
    }

    public LoginParams setPassword(final String password) {
        this.password = password;
        return this;
    }

    public LoginParams setConfirmPwd(final String confirmPwd) {
        this.confirmPwd = confirmPwd;
        return this;
    }

    public LoginParams setCaptcha(final String captcha) {
        this.captcha = captcha;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LoginParams)) {
            return false;
        } else {
            LoginParams other = (LoginParams)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                Object this$confirmPwd = this.getConfirmPwd();
                Object other$confirmPwd = other.getConfirmPwd();
                if (this$confirmPwd == null) {
                    if (other$confirmPwd != null) {
                        return false;
                    }
                } else if (!this$confirmPwd.equals(other$confirmPwd)) {
                    return false;
                }

                Object this$captcha = this.getCaptcha();
                Object other$captcha = other.getCaptcha();
                if (this$captcha == null) {
                    if (other$captcha != null) {
                        return false;
                    }
                } else if (!this$captcha.equals(other$captcha)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginParams;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        Object $confirmPwd = this.getConfirmPwd();
        result = result * 59 + ($confirmPwd == null ? 43 : $confirmPwd.hashCode());
        Object $captcha = this.getCaptcha();
        result = result * 59 + ($captcha == null ? 43 : $captcha.hashCode());
        return result;
    }

    public String toString() {
        return "LoginParams(email=" + this.getEmail() + ", password=" + this.getPassword() + ", confirmPwd=" + this.getConfirmPwd() + ", captcha=" + this.getCaptcha() + ")";
    }

    public LoginParams() {
    }

    public LoginParams(final String email, final String password, final String confirmPwd, final String captcha) {
        this.email = email;
        this.password = password;
        this.confirmPwd = confirmPwd;
        this.captcha = captcha;
    }
}

