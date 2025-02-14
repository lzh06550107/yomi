package cn.liaozh.pojo.vo;

public class AddCommentsVo {
    private String targetId;
    private String content;
    private String parentId;
    private String link;

    public AddCommentsVo() {
    }

    public String getTargetId() {
        return this.targetId;
    }

    public String getContent() {
        return this.content;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getLink() {
        return this.link;
    }

    public void setTargetId(final String targetId) {
        this.targetId = targetId;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AddCommentsVo)) {
            return false;
        } else {
            AddCommentsVo other = (AddCommentsVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$targetId = this.getTargetId();
                Object other$targetId = other.getTargetId();
                if (this$targetId == null) {
                    if (other$targetId != null) {
                        return false;
                    }
                } else if (!this$targetId.equals(other$targetId)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AddCommentsVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $targetId = this.getTargetId();
        result = result * 59 + ($targetId == null ? 43 : $targetId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        return result;
    }

    public String toString() {
        return "AddCommentsVo(targetId=" + this.getTargetId() + ", content=" + this.getContent() + ", parentId=" + this.getParentId() + ", link=" + this.getLink() + ")";
    }
}

