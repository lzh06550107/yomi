package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmFans对象",
        description = "粉丝表"
)
public class YmFans implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(
            value = "fans_id",
            type = IdType.ASSIGN_ID
    )
    private String fansId;
    @ApiModelProperty("被关注者id")
    private String answerUserId;
    @ApiModelProperty("关注者id")
    private String userId;
    @ApiModelProperty("关注来源")
    private String source;
    @ApiModelProperty("关注状态 0关注 1取消")
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

    public YmFans() {
    }

    public String getFansId() {
        return this.fansId;
    }

    public String getAnswerUserId() {
        return this.answerUserId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getSource() {
        return this.source;
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

    public YmFans setFansId(final String fansId) {
        this.fansId = fansId;
        return this;
    }

    public YmFans setAnswerUserId(final String answerUserId) {
        this.answerUserId = answerUserId;
        return this;
    }

    public YmFans setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmFans setSource(final String source) {
        this.source = source;
        return this;
    }

    @JsonIgnore
    public YmFans setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmFans setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmFans setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmFans(fansId=" + this.getFansId() + ", answerUserId=" + this.getAnswerUserId() + ", userId=" + this.getUserId() + ", source=" + this.getSource() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmFans)) {
            return false;
        } else {
            YmFans other = (YmFans)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$fansId = this.getFansId();
                Object other$fansId = other.getFansId();
                if (this$fansId == null) {
                    if (other$fansId != null) {
                        return false;
                    }
                } else if (!this$fansId.equals(other$fansId)) {
                    return false;
                }

                Object this$answerUserId = this.getAnswerUserId();
                Object other$answerUserId = other.getAnswerUserId();
                if (this$answerUserId == null) {
                    if (other$answerUserId != null) {
                        return false;
                    }
                } else if (!this$answerUserId.equals(other$answerUserId)) {
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

                Object this$source = this.getSource();
                Object other$source = other.getSource();
                if (this$source == null) {
                    if (other$source != null) {
                        return false;
                    }
                } else if (!this$source.equals(other$source)) {
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
        return other instanceof YmFans;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $fansId = this.getFansId();
        result = result * 59 + ($fansId == null ? 43 : $fansId.hashCode());
        Object $answerUserId = this.getAnswerUserId();
        result = result * 59 + ($answerUserId == null ? 43 : $answerUserId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $source = this.getSource();
        result = result * 59 + ($source == null ? 43 : $source.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}

