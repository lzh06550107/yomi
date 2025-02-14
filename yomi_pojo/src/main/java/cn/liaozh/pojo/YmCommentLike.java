package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmCommentLike对象",
        description = ""
)
public class YmCommentLike implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("点赞id")
    @TableId(
            value = "like_id",
            type = IdType.ASSIGN_ID
    )
    private String likeId;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("评论id")
    private String commentId;
    @ApiModelProperty("点赞状态 0点赞 1取消")
    private String likeState;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    public YmCommentLike() {
    }

    public String getLikeId() {
        return this.likeId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getLikeState() {
        return this.likeState;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public YmCommentLike setLikeId(final String likeId) {
        this.likeId = likeId;
        return this;
    }

    public YmCommentLike setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmCommentLike setCommentId(final String commentId) {
        this.commentId = commentId;
        return this;
    }

    public YmCommentLike setLikeState(final String likeState) {
        this.likeState = likeState;
        return this;
    }

    public YmCommentLike setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmCommentLike setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmCommentLike(likeId=" + this.getLikeId() + ", userId=" + this.getUserId() + ", commentId=" + this.getCommentId() + ", likeState=" + this.getLikeState() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmCommentLike)) {
            return false;
        } else {
            YmCommentLike other = (YmCommentLike)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$likeId = this.getLikeId();
                Object other$likeId = other.getLikeId();
                if (this$likeId == null) {
                    if (other$likeId != null) {
                        return false;
                    }
                } else if (!this$likeId.equals(other$likeId)) {
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

                Object this$commentId = this.getCommentId();
                Object other$commentId = other.getCommentId();
                if (this$commentId == null) {
                    if (other$commentId != null) {
                        return false;
                    }
                } else if (!this$commentId.equals(other$commentId)) {
                    return false;
                }

                Object this$likeState = this.getLikeState();
                Object other$likeState = other.getLikeState();
                if (this$likeState == null) {
                    if (other$likeState != null) {
                        return false;
                    }
                } else if (!this$likeState.equals(other$likeState)) {
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
        return other instanceof YmCommentLike;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $likeId = this.getLikeId();
        result = result * 59 + ($likeId == null ? 43 : $likeId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $commentId = this.getCommentId();
        result = result * 59 + ($commentId == null ? 43 : $commentId.hashCode());
        Object $likeState = this.getLikeState();
        result = result * 59 + ($likeState == null ? 43 : $likeState.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}

