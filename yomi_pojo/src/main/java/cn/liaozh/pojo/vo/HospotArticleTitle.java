package cn.liaozh.pojo.vo;

public class HospotArticleTitle {
    private String articleId;
    private String title;

    public HospotArticleTitle() {
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HospotArticleTitle)) {
            return false;
        } else {
            HospotArticleTitle other = (HospotArticleTitle)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$articleId = this.getArticleId();
                Object other$articleId = other.getArticleId();
                if (this$articleId == null) {
                    if (other$articleId != null) {
                        return false;
                    }
                } else if (!this$articleId.equals(other$articleId)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HospotArticleTitle;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        return result;
    }

    public String toString() {
        return "HospotArticleTitle(articleId=" + this.getArticleId() + ", title=" + this.getTitle() + ")";
    }
}
