package cn.liaozh.pojo.vo;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Pattern;

public class ModifyUserInfoVo {
    private @URL String avatar;
    private String userName;
    private String signature;
    private @Pattern(
            regexp = "^[0|12]",
            message = "性别格式不正确"
    ) String sex;
    private String phoneNumber;
    private String wxNum;

    public ModifyUserInfoVo() {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSex() {
        return this.sex;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getWxNum() {
        return this.wxNum;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWxNum(final String wxNum) {
        this.wxNum = wxNum;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ModifyUserInfoVo)) {
            return false;
        } else {
            ModifyUserInfoVo other = (ModifyUserInfoVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                Object this$userName = this.getUserName();
                Object other$userName = other.getUserName();
                if (this$userName == null) {
                    if (other$userName != null) {
                        return false;
                    }
                } else if (!this$userName.equals(other$userName)) {
                    return false;
                }

                Object this$signature = this.getSignature();
                Object other$signature = other.getSignature();
                if (this$signature == null) {
                    if (other$signature != null) {
                        return false;
                    }
                } else if (!this$signature.equals(other$signature)) {
                    return false;
                }

                Object this$sex = this.getSex();
                Object other$sex = other.getSex();
                if (this$sex == null) {
                    if (other$sex != null) {
                        return false;
                    }
                } else if (!this$sex.equals(other$sex)) {
                    return false;
                }

                Object this$phoneNumber = this.getPhoneNumber();
                Object other$phoneNumber = other.getPhoneNumber();
                if (this$phoneNumber == null) {
                    if (other$phoneNumber != null) {
                        return false;
                    }
                } else if (!this$phoneNumber.equals(other$phoneNumber)) {
                    return false;
                }

                Object this$wxNum = this.getWxNum();
                Object other$wxNum = other.getWxNum();
                if (this$wxNum == null) {
                    if (other$wxNum != null) {
                        return false;
                    }
                } else if (!this$wxNum.equals(other$wxNum)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ModifyUserInfoVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $signature = this.getSignature();
        result = result * 59 + ($signature == null ? 43 : $signature.hashCode());
        Object $sex = this.getSex();
        result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
        Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        Object $wxNum = this.getWxNum();
        result = result * 59 + ($wxNum == null ? 43 : $wxNum.hashCode());
        return result;
    }

    public String toString() {
        return "ModifyUserInfoVo(avatar=" + this.getAvatar() + ", userName=" + this.getUserName() + ", signature=" + this.getSignature() + ", sex=" + this.getSex() + ", phoneNumber=" + this.getPhoneNumber() + ", wxNum=" + this.getWxNum() + ")";
    }
}
