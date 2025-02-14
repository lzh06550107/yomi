package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class UserVo {
    private String userId;
    @JsonIgnore
    private String openId;
    private String userName;
    private String classId;
    private String phoneNumber;
    @ApiModelProperty("个性签名")
    private String signature;
    private Integer fansNum;
    private String sex;
    @JsonIgnore
    private String online;
    private String avatar;

    public UserVo(YmUser ymUser) {
        this.userId = ymUser.getUserId();
        this.openId = ymUser.getOpenId();
        this.userName = ymUser.getUserName();
        this.classId = ymUser.getClassId();
        this.phoneNumber = ymUser.getPhoneNumber();
        this.signature = ymUser.getSignature();
        this.fansNum = ymUser.getFansNum();
        this.sex = ymUser.getSex();
        this.online = ymUser.getOnline();
        this.avatar = ymUser.getAvatar();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getClassId() {
        return this.classId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getSignature() {
        return this.signature;
    }

    public Integer getFansNum() {
        return this.fansNum;
    }

    public String getSex() {
        return this.sex;
    }

    public String getOnline() {
        return this.online;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public void setOpenId(final String openId) {
        this.openId = openId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setClassId(final String classId) {
        this.classId = classId;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }

    public void setFansNum(final Integer fansNum) {
        this.fansNum = fansNum;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    @JsonIgnore
    public void setOnline(final String online) {
        this.online = online;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserVo)) {
            return false;
        } else {
            UserVo other = (UserVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$fansNum = this.getFansNum();
                Object other$fansNum = other.getFansNum();
                if (this$fansNum == null) {
                    if (other$fansNum != null) {
                        return false;
                    }
                } else if (!this$fansNum.equals(other$fansNum)) {
                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$openId = this.getOpenId();
                Object other$openId = other.getOpenId();
                if (this$openId == null) {
                    if (other$openId != null) {
                        return false;
                    }
                } else if (!this$openId.equals(other$openId)) {
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

                Object this$classId = this.getClassId();
                Object other$classId = other.getClassId();
                if (this$classId == null) {
                    if (other$classId != null) {
                        return false;
                    }
                } else if (!this$classId.equals(other$classId)) {
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

                Object this$online = this.getOnline();
                Object other$online = other.getOnline();
                if (this$online == null) {
                    if (other$online != null) {
                        return false;
                    }
                } else if (!this$online.equals(other$online)) {
                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $fansNum = this.getFansNum();
        result = result * 59 + ($fansNum == null ? 43 : $fansNum.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $openId = this.getOpenId();
        result = result * 59 + ($openId == null ? 43 : $openId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $classId = this.getClassId();
        result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
        Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        Object $signature = this.getSignature();
        result = result * 59 + ($signature == null ? 43 : $signature.hashCode());
        Object $sex = this.getSex();
        result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
        Object $online = this.getOnline();
        result = result * 59 + ($online == null ? 43 : $online.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        return result;
    }

    public String toString() {
        return "UserVo(userId=" + this.getUserId() + ", openId=" + this.getOpenId() + ", userName=" + this.getUserName() + ", classId=" + this.getClassId() + ", phoneNumber=" + this.getPhoneNumber() + ", signature=" + this.getSignature() + ", fansNum=" + this.getFansNum() + ", sex=" + this.getSex() + ", online=" + this.getOnline() + ", avatar=" + this.getAvatar() + ")";
    }

    public UserVo(final String userId, final String openId, final String userName, final String classId, final String phoneNumber, final String signature, final Integer fansNum, final String sex, final String online, final String avatar) {
        this.userId = userId;
        this.openId = openId;
        this.userName = userName;
        this.classId = classId;
        this.phoneNumber = phoneNumber;
        this.signature = signature;
        this.fansNum = fansNum;
        this.sex = sex;
        this.online = online;
        this.avatar = avatar;
    }

    public UserVo() {
    }
}
