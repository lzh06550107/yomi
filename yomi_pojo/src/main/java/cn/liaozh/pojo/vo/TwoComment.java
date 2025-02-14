package cn.liaozh.pojo.vo;

public class TwoComment {
    private String commentId;
    private String content;
    private Integer commentNum;
    private Long createTime;
    private String userId;
    private String userName;
    private String avatar;
    private String parentId;
    private boolean likeStatus;
    private String type;

    public TwoComment() {
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getCommentNum() {
        return this.commentNum;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getParentId() {
        return this.parentId;
    }

    public boolean isLikeStatus() {
        return this.likeStatus;
    }

    public String getType() {
        return this.type;
    }

    public void setCommentId(final String commentId) {
        this.commentId = commentId;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setCommentNum(final Integer commentNum) {
        this.commentNum = commentNum;
    }

    public void setCreateTime(final Long createTime) {
        this.createTime = createTime;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public void setLikeStatus(final boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TwoComment)) {
            return false;
        } else {
            TwoComment other = (TwoComment)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isLikeStatus() != other.isLikeStatus()) {
                return false;
            } else {
                Object this$commentNum = this.getCommentNum();
                Object other$commentNum = other.getCommentNum();
                if (this$commentNum == null) {
                    if (other$commentNum != null) {
                        return false;
                    }
                } else if (!this$commentNum.equals(other$commentNum)) {
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

                Object this$commentId = this.getCommentId();
                Object other$commentId = other.getCommentId();
                if (this$commentId == null) {
                    if (other$commentId != null) {
                        return false;
                    }
                } else if (!this$commentId.equals(other$commentId)) {
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

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
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

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TwoComment;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isLikeStatus() ? 79 : 97);
        Object $commentNum = this.getCommentNum();
        result = result * 59 + ($commentNum == null ? 43 : $commentNum.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $commentId = this.getCommentId();
        result = result * 59 + ($commentId == null ? 43 : $commentId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "TwoComment(commentId=" + this.getCommentId() + ", content=" + this.getContent() + ", commentNum=" + this.getCommentNum() + ", createTime=" + this.getCreateTime() + ", userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", avatar=" + this.getAvatar() + ", parentId=" + this.getParentId() + ", likeStatus=" + this.isLikeStatus() + ", type=" + this.getType() + ")";
    }
}

