package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class YmCaptcha implements Serializable {
    @TableId(
            value = "captcha_id",
            type = IdType.ASSIGN_ID
    )
    private String captchaId;
    private String email;
    private String code;
    private String isValidation;
    @TableLogic
    @JsonIgnore
    private String isDeleted;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    public YmCaptcha(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public String getCaptchaId() {
        return this.captchaId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCode() {
        return this.code;
    }

    public String getIsValidation() {
        return this.isValidation;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public YmCaptcha setCaptchaId(final String captchaId) {
        this.captchaId = captchaId;
        return this;
    }

    public YmCaptcha setEmail(final String email) {
        this.email = email;
        return this;
    }

    public YmCaptcha setCode(final String code) {
        this.code = code;
        return this;
    }

    public YmCaptcha setIsValidation(final String isValidation) {
        this.isValidation = isValidation;
        return this;
    }

    @JsonIgnore
    public YmCaptcha setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmCaptcha setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmCaptcha setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmCaptcha)) {
            return false;
        } else {
            YmCaptcha other = (YmCaptcha)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$captchaId = this.getCaptchaId();
                Object other$captchaId = other.getCaptchaId();
                if (this$captchaId == null) {
                    if (other$captchaId != null) {
                        return false;
                    }
                } else if (!this$captchaId.equals(other$captchaId)) {
                    return false;
                }

                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$isValidation = this.getIsValidation();
                Object other$isValidation = other.getIsValidation();
                if (this$isValidation == null) {
                    if (other$isValidation != null) {
                        return false;
                    }
                } else if (!this$isValidation.equals(other$isValidation)) {
                    return false;
                }

                Object this$isDeleted = this.getIsDeleted();
                Object other$isDeleted = other.getIsDeleted();
                if (this$isDeleted == null) {
                    if (other$isDeleted != null) {
                        return false;
                    }
                } else if (!this$isDeleted.equals(other$isDeleted)) {
                    return false;
                }

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                Object this$updateTime = this.getUpdateTime();
                Object other$updateTime = other.getUpdateTime();
                if (this$updateTime == null) {
                    if (other$updateTime != null) {
                        return false;
                    }
                } else if (!this$updateTime.equals(other$updateTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmCaptcha;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $captchaId = this.getCaptchaId();
        result = result * 59 + ($captchaId == null ? 43 : $captchaId.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $isValidation = this.getIsValidation();
        result = result * 59 + ($isValidation == null ? 43 : $isValidation.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    public String toString() {
        return "YmCaptcha(captchaId=" + this.getCaptchaId() + ", email=" + this.getEmail() + ", code=" + this.getCode() + ", isValidation=" + this.getIsValidation() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public YmCaptcha() {
    }

    public YmCaptcha(final String captchaId, final String email, final String code, final String isValidation, final String isDeleted, final String createTime, final String updateTime) {
        this.captchaId = captchaId;
        this.email = email;
        this.code = code;
        this.isValidation = isValidation;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
