package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UserInfoVo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    @TableId(
            value = "user_id",
            type = IdType.ASSIGN_ID
    )
    private String userId;
    @ApiModelProperty("用户查询id")
    private int id;
    @ApiModelProperty("用户昵称")
    private String userName;
    @ApiModelProperty("班级id")
    private String classId;
    @ApiModelProperty("电话号码")
    private String phoneNumber;
    @ApiModelProperty("个性签名")
    private String signature;
    @ApiModelProperty("粉丝数")
    private int fansNum;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("是否禁用 0启用 1禁用")
    @JsonIgnore
    private String isDisabled;
    @ApiModelProperty("头像")
    private String avatar;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
    @ApiModelProperty("关注状态")
    private Boolean fansState;
    private Integer userIdentity;
    private boolean followState;
    @JsonProperty("badge")
    private Integer goodUser = 0;

    public String getUserId() {
        return this.userId;
    }

    public int getId() {
        return this.id;
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

    public int getFansNum() {
        return this.fansNum;
    }

    public String getSex() {
        return this.sex;
    }

    public String getIsDisabled() {
        return this.isDisabled;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public Boolean getFansState() {
        return this.fansState;
    }

    public Integer getUserIdentity() {
        return this.userIdentity;
    }

    public boolean isFollowState() {
        return this.followState;
    }

    public Integer getGoodUser() {
        return this.goodUser;
    }

    public UserInfoVo setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public UserInfoVo setId(final int id) {
        this.id = id;
        return this;
    }

    public UserInfoVo setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfoVo setClassId(final String classId) {
        this.classId = classId;
        return this;
    }

    public UserInfoVo setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserInfoVo setSignature(final String signature) {
        this.signature = signature;
        return this;
    }

    public UserInfoVo setFansNum(final int fansNum) {
        this.fansNum = fansNum;
        return this;
    }

    public UserInfoVo setSex(final String sex) {
        this.sex = sex;
        return this;
    }

    @JsonIgnore
    public UserInfoVo setIsDisabled(final String isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }

    public UserInfoVo setAvatar(final String avatar) {
        this.avatar = avatar;
        return this;
    }

    public UserInfoVo setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public UserInfoVo setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public UserInfoVo setFansState(final Boolean fansState) {
        this.fansState = fansState;
        return this;
    }

    public UserInfoVo setUserIdentity(final Integer userIdentity) {
        this.userIdentity = userIdentity;
        return this;
    }

    public UserInfoVo setFollowState(final boolean followState) {
        this.followState = followState;
        return this;
    }

    @JsonProperty("badge")
    public UserInfoVo setGoodUser(final Integer goodUser) {
        this.goodUser = goodUser;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserInfoVo)) {
            return false;
        } else {
            UserInfoVo other = (UserInfoVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getFansNum() != other.getFansNum()) {
                return false;
            } else if (this.isFollowState() != other.isFollowState()) {
                return false;
            } else {
                Object this$fansState = this.getFansState();
                Object other$fansState = other.getFansState();
                if (this$fansState == null) {
                    if (other$fansState != null) {
                        return false;
                    }
                } else if (!this$fansState.equals(other$fansState)) {
                    return false;
                }

                Object this$userIdentity = this.getUserIdentity();
                Object other$userIdentity = other.getUserIdentity();
                if (this$userIdentity == null) {
                    if (other$userIdentity != null) {
                        return false;
                    }
                } else if (!this$userIdentity.equals(other$userIdentity)) {
                    return false;
                }

                Object this$goodUser = this.getGoodUser();
                Object other$goodUser = other.getGoodUser();
                if (this$goodUser == null) {
                    if (other$goodUser != null) {
                        return false;
                    }
                } else if (!this$goodUser.equals(other$goodUser)) {
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

                Object this$isDisabled = this.getIsDisabled();
                Object other$isDisabled = other.getIsDisabled();
                if (this$isDisabled == null) {
                    if (other$isDisabled != null) {
                        return false;
                    }
                } else if (!this$isDisabled.equals(other$isDisabled)) {
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
        return other instanceof UserInfoVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getFansNum();
        result = result * 59 + (this.isFollowState() ? 79 : 97);
        Object $fansState = this.getFansState();
        result = result * 59 + ($fansState == null ? 43 : $fansState.hashCode());
        Object $userIdentity = this.getUserIdentity();
        result = result * 59 + ($userIdentity == null ? 43 : $userIdentity.hashCode());
        Object $goodUser = this.getGoodUser();
        result = result * 59 + ($goodUser == null ? 43 : $goodUser.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
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
        Object $isDisabled = this.getIsDisabled();
        result = result * 59 + ($isDisabled == null ? 43 : $isDisabled.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    public String toString() {
        return "UserInfoVo(userId=" + this.getUserId() + ", id=" + this.getId() + ", userName=" + this.getUserName() + ", classId=" + this.getClassId() + ", phoneNumber=" + this.getPhoneNumber() + ", signature=" + this.getSignature() + ", fansNum=" + this.getFansNum() + ", sex=" + this.getSex() + ", isDisabled=" + this.getIsDisabled() + ", avatar=" + this.getAvatar() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", fansState=" + this.getFansState() + ", userIdentity=" + this.getUserIdentity() + ", followState=" + this.isFollowState() + ", goodUser=" + this.getGoodUser() + ")";
    }

    public UserInfoVo(final String userId, final int id, final String userName, final String classId, final String phoneNumber, final String signature, final int fansNum, final String sex, final String isDisabled, final String avatar, final String createTime, final String updateTime, final Boolean fansState, final Integer userIdentity, final boolean followState, final Integer goodUser) {
        this.userId = userId;
        this.id = id;
        this.userName = userName;
        this.classId = classId;
        this.phoneNumber = phoneNumber;
        this.signature = signature;
        this.fansNum = fansNum;
        this.sex = sex;
        this.isDisabled = isDisabled;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fansState = fansState;
        this.userIdentity = userIdentity;
        this.followState = followState;
        this.goodUser = goodUser;
    }

    public UserInfoVo() {
    }
}

