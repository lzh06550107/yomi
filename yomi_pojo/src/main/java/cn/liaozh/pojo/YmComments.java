package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class YmComments implements Serializable {
    @TableId(
            value = "comment_id",
            type = IdType.ASSIGN_ID
    )
    private String commentId;
    private String targetId;
    private String userId;
    private String content;
    private String parentId;
    private Integer likeNum;
    private String link;
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

    public YmComments() {
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getContent() {
        return this.content;
    }

    public String getParentId() {
        return this.parentId;
    }

    public Integer getLikeNum() {
        return this.likeNum;
    }

    public String getLink() {
        return this.link;
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

    public void setCommentId(final String commentId) {
        this.commentId = commentId;
    }

    public void setTargetId(final String targetId) {
        this.targetId = targetId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public void setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    @JsonIgnore
    public void setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmComments)) {
            return false;
        } else {
            YmComments other = (YmComments)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$likeNum = this.getLikeNum();
                Object other$likeNum = other.getLikeNum();
                if (this$likeNum == null) {
                    if (other$likeNum != null) {
                        return false;
                    }
                } else if (!this$likeNum.equals(other$likeNum)) {
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

                Object this$targetId = this.getTargetId();
                Object other$targetId = other.getTargetId();
                if (this$targetId == null) {
                    if (other$targetId != null) {
                        return false;
                    }
                } else if (!this$targetId.equals(other$targetId)) {
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

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                Object this$parentId = this.getParentId();
                Object other$parentId = other.getParentId();
                if (this$parentId == null) {
                    if (other$parentId != null) {
                        return false;
                    }
                } else if (!this$parentId.equals(other$parentId)) {
                    return false;
                }

                Object this$link = this.getLink();
                Object other$link = other.getLink();
                if (this$link == null) {
                    if (other$link != null) {
                        return false;
                    }
                } else if (!this$link.equals(other$link)) {
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
        return other instanceof YmComments;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $likeNum = this.getLikeNum();
        result = result * 59 + ($likeNum == null ? 43 : $likeNum.hashCode());
        Object $commentId = this.getCommentId();
        result = result * 59 + ($commentId == null ? 43 : $commentId.hashCode());
        Object $targetId = this.getTargetId();
        result = result * 59 + ($targetId == null ? 43 : $targetId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    public String toString() {
        return "YmComments(commentId=" + this.getCommentId() + ", targetId=" + this.getTargetId() + ", userId=" + this.getUserId() + ", content=" + this.getContent() + ", parentId=" + this.getParentId() + ", likeNum=" + this.getLikeNum() + ", link=" + this.getLink() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }
}
