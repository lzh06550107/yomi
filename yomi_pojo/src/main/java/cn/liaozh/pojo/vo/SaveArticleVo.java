package cn.liaozh.pojo.vo;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;

public class SaveArticleVo {
    private @NotBlank String familyId;
    private @NotBlank String title;
    private String content;
    private String[] imageLink;

    public SaveArticleVo() {
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String[] getImageLink() {
        return this.imageLink;
    }

    public void setFamilyId(final String familyId) {
        this.familyId = familyId;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setImageLink(final String[] imageLink) {
        this.imageLink = imageLink;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SaveArticleVo)) {
            return false;
        } else {
            SaveArticleVo other = (SaveArticleVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$familyId = this.getFamilyId();
                Object other$familyId = other.getFamilyId();
                if (this$familyId == null) {
                    if (other$familyId != null) {
                        return false;
                    }
                } else if (!this$familyId.equals(other$familyId)) {
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

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getImageLink(), other.getImageLink())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SaveArticleVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getImageLink());
        return result;
    }

    public String toString() {
        return "SaveArticleVo(familyId=" + this.getFamilyId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", imageLink=" + Arrays.deepToString(this.getImageLink()) + ")";
    }
}
