package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class UserSort {
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
    @ApiModelProperty("在线状态")
    @JsonIgnore
    private String online;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("是否消息推送")
    @JsonIgnore
    private String notice;
    @ApiModelProperty("关注状态")
    private boolean fansState;
    @ApiModelProperty("互关状态")
    private boolean followState;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
    @ApiModelProperty("排序")
    private int sort;

    public UserSort() {
    }

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

    public String getOnline() {
        return this.online;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNotice() {
        return this.notice;
    }

    public boolean isFansState() {
        return this.fansState;
    }

    public boolean isFollowState() {
        return this.followState;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public int getSort() {
        return this.sort;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setId(final int id) {
        this.id = id;
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

    public void setFansNum(final int fansNum) {
        this.fansNum = fansNum;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    @JsonIgnore
    public void setIsDisabled(final String isDisabled) {
        this.isDisabled = isDisabled;
    }

    @JsonIgnore
    public void setOnline(final String online) {
        this.online = online;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    @JsonIgnore
    public void setNotice(final String notice) {
        this.notice = notice;
    }

    public void setFansState(final boolean fansState) {
        this.fansState = fansState;
    }

    public void setFollowState(final boolean followState) {
        this.followState = followState;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public void setSort(final int sort) {
        this.sort = sort;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserSort)) {
            return false;
        } else {
            UserSort other = (UserSort)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getFansNum() != other.getFansNum()) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
                return false;
            } else if (this.isFollowState() != other.isFollowState()) {
                return false;
            } else if (this.getSort() != other.getSort()) {
                return false;
            } else {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserSort;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getFansNum();
        result = result * 59 + (this.isFansState() ? 79 : 97);
        result = result * 59 + (this.isFollowState() ? 79 : 97);
        result = result * 59 + this.getSort();
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
        return result;
    }

    public String toString() {
        return "UserSort(userId=" + this.getUserId() + ", id=" + this.getId() + ", userName=" + this.getUserName() + ", classId=" + this.getClassId() + ", phoneNumber=" + this.getPhoneNumber() + ", signature=" + this.getSignature() + ", fansNum=" + this.getFansNum() + ", sex=" + this.getSex() + ", isDisabled=" + this.getIsDisabled() + ", online=" + this.getOnline() + ", avatar=" + this.getAvatar() + ", notice=" + this.getNotice() + ", fansState=" + this.isFansState() + ", followState=" + this.isFollowState() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", sort=" + this.getSort() + ")";
    }
}
