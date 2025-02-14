package cn.liaozh.pojo.vo;

import java.io.Serializable;

public class IntactArticleVo implements Serializable {
    private String intactArticleId;
    private ArticleVo article;
    private UserVo user;
    private ImageVo image;
    private FamilyVo family;

    public IntactArticleVo() {
    }

    public String getIntactArticleId() {
        return this.intactArticleId;
    }

    public ArticleVo getArticle() {
        return this.article;
    }

    public UserVo getUser() {
        return this.user;
    }

    public ImageVo getImage() {
        return this.image;
    }

    public FamilyVo getFamily() {
        return this.family;
    }

    public void setIntactArticleId(final String intactArticleId) {
        this.intactArticleId = intactArticleId;
    }

    public void setArticle(final ArticleVo article) {
        this.article = article;
    }

    public void setUser(final UserVo user) {
        this.user = user;
    }

    public void setImage(final ImageVo image) {
        this.image = image;
    }

    public void setFamily(final FamilyVo family) {
        this.family = family;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof IntactArticleVo)) {
            return false;
        } else {
            IntactArticleVo other = (IntactArticleVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$intactArticleId = this.getIntactArticleId();
                Object other$intactArticleId = other.getIntactArticleId();
                if (this$intactArticleId == null) {
                    if (other$intactArticleId != null) {
                        return false;
                    }
                } else if (!this$intactArticleId.equals(other$intactArticleId)) {
                    return false;
                }

                Object this$article = this.getArticle();
                Object other$article = other.getArticle();
                if (this$article == null) {
                    if (other$article != null) {
                        return false;
                    }
                } else if (!this$article.equals(other$article)) {
                    return false;
                }

                Object this$user = this.getUser();
                Object other$user = other.getUser();
                if (this$user == null) {
                    if (other$user != null) {
                        return false;
                    }
                } else if (!this$user.equals(other$user)) {
                    return false;
                }

                Object this$image = this.getImage();
                Object other$image = other.getImage();
                if (this$image == null) {
                    if (other$image != null) {
                        return false;
                    }
                } else if (!this$image.equals(other$image)) {
                    return false;
                }

                Object this$family = this.getFamily();
                Object other$family = other.getFamily();
                if (this$family == null) {
                    if (other$family != null) {
                        return false;
                    }
                } else if (!this$family.equals(other$family)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IntactArticleVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $intactArticleId = this.getIntactArticleId();
        result = result * 59 + ($intactArticleId == null ? 43 : $intactArticleId.hashCode());
        Object $article = this.getArticle();
        result = result * 59 + ($article == null ? 43 : $article.hashCode());
        Object $user = this.getUser();
        result = result * 59 + ($user == null ? 43 : $user.hashCode());
        Object $image = this.getImage();
        result = result * 59 + ($image == null ? 43 : $image.hashCode());
        Object $family = this.getFamily();
        result = result * 59 + ($family == null ? 43 : $family.hashCode());
        return result;
    }

    public String toString() {
        return "IntactArticleVo(intactArticleId=" + this.getIntactArticleId() + ", article=" + this.getArticle() + ", user=" + this.getUser() + ", image=" + this.getImage() + ", family=" + this.getFamily() + ")";
    }
}
