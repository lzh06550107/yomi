package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("YmUser对象")
public class YmUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    @TableId(
            value = "user_id",
            type = IdType.ASSIGN_ID
    )
    private String userId;
    @JsonIgnore
    @ApiModelProperty("微信openid")
    private String openId;
    @ApiModelProperty("用户昵称")
    private String userName;
    @ApiModelProperty("班级id")
    private String classId;
    @ApiModelProperty("电话号码")
    private String phoneNumber;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("粉丝数")
    private Integer fansNum;
    @ApiModelProperty("性别")
    private String sex;
    private String wxNum;
    private String qqNum;
    @JsonIgnore
    @ApiModelProperty("是否禁用 0启用 1禁用")
    private String isDisabled;
    @ApiModelProperty("删除状态 0可用 1删除  删除后相关信息不可见")
    @TableLogic
    @JsonIgnore
    private String isDeleted;
    @JsonIgnore
    @ApiModelProperty("在线状态")
    private String online;
    @ApiModelProperty("头像")
    private String avatar;
    @JsonIgnore
    @ApiModelProperty("消息推送")
    private String notice;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
    @JsonIgnore
    private String deleteTime;
    private String email;
    @JsonIgnore
    private String password;

    public YmUser() {
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

    public String getWxNum() {
        return this.wxNum;
    }

    public String getQqNum() {
        return this.qqNum;
    }

    public String getIsDisabled() {
        return this.isDisabled;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getOnline() {
        return this.online;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getDeleteTime() {
        return this.deleteTime;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public YmUser setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    @JsonIgnore
    public YmUser setOpenId(final String openId) {
        this.openId = openId;
        return this;
    }

    public YmUser setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    public YmUser setClassId(final String classId) {
        this.classId = classId;
        return this;
    }

    public YmUser setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public YmUser setSignature(final String signature) {
        this.signature = signature;
        return this;
    }

    public YmUser setFansNum(final Integer fansNum) {
        this.fansNum = fansNum;
        return this;
    }

    public YmUser setSex(final String sex) {
        this.sex = sex;
        return this;
    }

    public YmUser setWxNum(final String wxNum) {
        this.wxNum = wxNum;
        return this;
    }

    public YmUser setQqNum(final String qqNum) {
        this.qqNum = qqNum;
        return this;
    }

    @JsonIgnore
    public YmUser setIsDisabled(final String isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }

    @JsonIgnore
    public YmUser setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @JsonIgnore
    public YmUser setOnline(final String online) {
        this.online = online;
        return this;
    }

    public YmUser setAvatar(final String avatar) {
        this.avatar = avatar;
        return this;
    }

    @JsonIgnore
    public YmUser setNotice(final String notice) {
        this.notice = notice;
        return this;
    }

    public YmUser setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmUser setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @JsonIgnore
    public YmUser setDeleteTime(final String deleteTime) {
        this.deleteTime = deleteTime;
        return this;
    }

    public YmUser setEmail(final String email) {
        this.email = email;
        return this;
    }

    @JsonIgnore
    public YmUser setPassword(final String password) {
        this.password = password;
        return this;
    }

    public String toString() {
        return "YmUser(userId=" + this.getUserId() + ", openId=" + this.getOpenId() + ", userName=" + this.getUserName() + ", classId=" + this.getClassId() + ", phoneNumber=" + this.getPhoneNumber() + ", signature=" + this.getSignature() + ", fansNum=" + this.getFansNum() + ", sex=" + this.getSex() + ", wxNum=" + this.getWxNum() + ", qqNum=" + this.getQqNum() + ", isDisabled=" + this.getIsDisabled() + ", isDeleted=" + this.getIsDeleted() + ", online=" + this.getOnline() + ", avatar=" + this.getAvatar() + ", notice=" + this.getNotice() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", deleteTime=" + this.getDeleteTime() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmUser)) {
            return false;
        } else {
            YmUser other = (YmUser)o;
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

                Object this$wxNum = this.getWxNum();
                Object other$wxNum = other.getWxNum();
                if (this$wxNum == null) {
                    if (other$wxNum != null) {
                        return false;
                    }
                } else if (!this$wxNum.equals(other$wxNum)) {
                    return false;
                }

                Object this$qqNum = this.getQqNum();
                Object other$qqNum = other.getQqNum();
                if (this$qqNum == null) {
                    if (other$qqNum != null) {
                        return false;
                    }
                } else if (!this$qqNum.equals(other$qqNum)) {
                    return false;
                }

                Object this$isDisabled = this.getIsDisabled();
                Object other$isDisabled = other.getIsDisabled();
                if (this$isDisabled == null) {
                    if (other$isDisabled != null) {
                        return false;
                    }
                } else if (!this$isDisabled.equals(other$isDisabled)) {
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

                Object this$notice = this.getNotice();
                Object other$notice = other.getNotice();
                if (this$notice == null) {
                    if (other$notice != null) {
                        return false;
                    }
                } else if (!this$notice.equals(other$notice)) {
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

                Object this$deleteTime = this.getDeleteTime();
                Object other$deleteTime = other.getDeleteTime();
                if (this$deleteTime == null) {
                    if (other$deleteTime != null) {
                        return false;
                    }
                } else if (!this$deleteTime.equals(other$deleteTime)) {
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

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmUser;
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
        Object $wxNum = this.getWxNum();
        result = result * 59 + ($wxNum == null ? 43 : $wxNum.hashCode());
        Object $qqNum = this.getQqNum();
        result = result * 59 + ($qqNum == null ? 43 : $qqNum.hashCode());
        Object $isDisabled = this.getIsDisabled();
        result = result * 59 + ($isDisabled == null ? 43 : $isDisabled.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $online = this.getOnline();
        result = result * 59 + ($online == null ? 43 : $online.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $notice = this.getNotice();
        result = result * 59 + ($notice == null ? 43 : $notice.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $deleteTime = this.getDeleteTime();
        result = result * 59 + ($deleteTime == null ? 43 : $deleteTime.hashCode());
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }
}
