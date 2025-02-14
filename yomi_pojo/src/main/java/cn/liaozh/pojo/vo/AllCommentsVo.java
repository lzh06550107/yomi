package cn.liaozh.pojo.vo;

import java.util.List;

public class AllCommentsVo {
    private String commentId;
    private String parentId;
    private String name;
    private String avatar;
    private String createTime;
    private String content;
    private Integer commentsNum;
    private String wasRepliedName;
    private String link;
    private Integer likeNum;
    private boolean status;
    private List<CommentsVo> list;

    public AllCommentsVo() {
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getName() {
        return this.name;
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

    public List<CommentsVo> getList() {
        return this.list;
    }

    public void setCommentId(final String commentId) {
        this.commentId = commentId;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setCommentsNum(final Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public void setWasRepliedName(final String wasRepliedName) {
        this.wasRepliedName = wasRepliedName;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public void setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
    }

    public void setStatus(final boolean status) {
        this.status = status;
    }

    public void setList(final List<CommentsVo> list) {
        this.list = list;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AllCommentsVo)) {
            return false;
        } else {
            AllCommentsVo other = (AllCommentsVo)o;
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

                Object this$parentId = this.getParentId();
                Object other$parentId = other.getParentId();
                if (this$parentId == null) {
                    if (other$parentId != null) {
                        return false;
                    }
                } else if (!this$parentId.equals(other$parentId)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
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

                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list != null) {
                        return false;
                    }
                } else if (!this$list.equals(other$list)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AllCommentsVo;
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
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
        Object $list = this.getList();
        result = result * 59 + ($list == null ? 43 : $list.hashCode());
        return result;
    }

    public String toString() {
        return "AllCommentsVo(commentId=" + this.getCommentId() + ", parentId=" + this.getParentId() + ", name=" + this.getName() + ", avatar=" + this.getAvatar() + ", createTime=" + this.getCreateTime() + ", content=" + this.getContent() + ", commentsNum=" + this.getCommentsNum() + ", wasRepliedName=" + this.getWasRepliedName() + ", link=" + this.getLink() + ", likeNum=" + this.getLikeNum() + ", status=" + this.isStatus() + ", list=" + this.getList() + ")";
    }
}
