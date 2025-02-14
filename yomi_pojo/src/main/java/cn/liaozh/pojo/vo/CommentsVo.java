package cn.liaozh.pojo.vo;

public class CommentsVo {
    private String commentId;
    private String userId;
    private String parentId;
    private String userName;
    private String avatar;
    private String createTime;
    private String content;
    private Integer commentsNum;
    private String wasRepliedName;
    private String link;
    private Integer likeNum;
    private boolean status;

    public CommentsVo() {
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getCommentsNum() {
        return this.commentsNum;
    }

    public String getWasRepliedName() {
        return this.wasRepliedName;
    }

    public String getLink() {
        return this.link;
    }

    public Integer getLikeNum() {
        return this.likeNum;
    }

    public boolean isStatus() {
        return this.status;
    }

    public CommentsVo setCommentId(final String commentId) {
        this.commentId = commentId;
        return this;
    }

    public CommentsVo setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public CommentsVo setParentId(final String parentId) {
        this.parentId = parentId;
        return this;
    }

    public CommentsVo setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    public CommentsVo setAvatar(final String avatar) {
        this.avatar = avatar;
        return this;
    }

    public CommentsVo setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public CommentsVo setContent(final String content) {
        this.content = content;
        return this;
    }

    public CommentsVo setCommentsNum(final Integer commentsNum) {
        this.commentsNum = commentsNum;
        return this;
    }

    public CommentsVo setWasRepliedName(final String wasRepliedName) {
        this.wasRepliedName = wasRepliedName;
        return this;
    }

    public CommentsVo setLink(final String link) {
        this.link = link;
        return this;
    }

    public CommentsVo setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
        return this;
    }

    public CommentsVo setStatus(final boolean status) {
        this.status = status;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommentsVo)) {
            return false;
        } else {
            CommentsVo other = (CommentsVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isStatus() != other.isStatus()) {
                return false;
            } else {
                Object this$commentsNum = this.getCommentsNum();
                Object other$commentsNum = other.getCommentsNum();
                if (this$commentsNum == null) {
                    if (other$commentsNum != null) {
                        return false;
                    }
                } else if (!this$commentsNum.equals(other$commentsNum)) {
                    return false;
                }

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

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
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

                Object this$wasRepliedName = this.getWasRepliedName();
                Object other$wasRepliedName = other.getWasRepliedName();
                if (this$wasRepliedName == null) {
                    if (other$wasRepliedName != null) {
                        return false;
                    }
                } else if (!this$wasRepliedName.equals(other$wasRepliedName)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentsVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isStatus() ? 79 : 97);
        Object $commentsNum = this.getCommentsNum();
        result = result * 59 + ($commentsNum == null ? 43 : $commentsNum.hashCode());
        Object $likeNum = this.getLikeNum();
        result = result * 59 + ($likeNum == null ? 43 : $likeNum.hashCode());
        Object $commentId = this.getCommentId();
        result = result * 59 + ($commentId == null ? 43 : $commentId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $wasRepliedName = this.getWasRepliedName();
        result = result * 59 + ($wasRepliedName == null ? 43 : $wasRepliedName.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        return result;
    }

    public String toString() {
        return "CommentsVo(commentId=" + this.getCommentId() + ", userId=" + this.getUserId() + ", parentId=" + this.getParentId() + ", userName=" + this.getUserName() + ", avatar=" + this.getAvatar() + ", createTime=" + this.getCreateTime() + ", content=" + this.getContent() + ", commentsNum=" + this.getCommentsNum() + ", wasRepliedName=" + this.getWasRepliedName() + ", link=" + this.getLink() + ", likeNum=" + this.getLikeNum() + ", status=" + this.isStatus() + ")";
    }
}
