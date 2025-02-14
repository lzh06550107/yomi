package cn.liaozh.pojo.vo;

public class EntityVo {
    private String name;
    private String title;
    private String imageLink;
    private String familyName;
    private String content;

    public EntityVo() {
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getContent() {
        return this.content;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setImageLink(final String imageLink) {
        this.imageLink = imageLink;
    }

    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EntityVo)) {
            return false;
        } else {
            EntityVo other = (EntityVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$title = this.getTitle();
                Object other$title = other.getTitle();
                if (this$title == null) {
                    if (other$title != null) {
                        return false;
                    }
                } else if (!this$title.equals(other$title)) {
                    return false;
                }

                Object this$imageLink = this.getImageLink();
                Object other$imageLink = other.getImageLink();
                if (this$imageLink == null) {
                    if (other$imageLink != null) {
                        return false;
                    }
                } else if (!this$imageLink.equals(other$imageLink)) {
                    return false;
                }

                Object this$familyName = this.getFamilyName();
                Object other$familyName = other.getFamilyName();
                if (this$familyName == null) {
                    if (other$familyName != null) {
                        return false;
                    }
                } else if (!this$familyName.equals(other$familyName)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EntityVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $imageLink = this.getImageLink();
        result = result * 59 + ($imageLink == null ? 43 : $imageLink.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "EntityVo(name=" + this.getName() + ", title=" + this.getTitle() + ", imageLink=" + this.getImageLink() + ", familyName=" + this.getFamilyName() + ", content=" + this.getContent() + ")";
    }
}

