package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntactArticleVos {
    @JsonProperty("articleId")
    private String intactArticleId;
    private ArticleVo article;
    private UserVo user;
    private ImageVo image;
    private FamilyVo family;
    private boolean likeStatus;
    private boolean fansState;
    private String privateState;
    private boolean followState;

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

    public boolean isLikeStatus() {
        return this.likeStatus;
    }

    public boolean isFansState() {
        return this.fansState;
    }

    public String getPrivateState() {
        return this.privateState;
    }

    public boolean isFollowState() {
        return this.followState;
    }

    @JsonProperty("articleId")
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

    public void setLikeStatus(final boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public void setFansState(final boolean fansState) {
        this.fansState = fansState;
    }

    public void setPrivateState(final String privateState) {
        this.privateState = privateState;
    }

    public void setFollowState(final boolean followState) {
        this.followState = followState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof IntactArticleVos)) {
            return false;
        } else {
            IntactArticleVos other = (IntactArticleVos)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isLikeStatus() != other.isLikeStatus()) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
                return false;
            } else if (this.isFollowState() != other.isFollowState()) {
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

                Object this$privateState = this.getPrivateState();
                Object other$privateState = other.getPrivateState();
                if (this$privateState == null) {
                    if (other$privateState != null) {
                        return false;
                    }
                } else if (!this$privateState.equals(other$privateState)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IntactArticleVos;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isLikeStatus() ? 79 : 97);
        result = result * 59 + (this.isFansState() ? 79 : 97);
        result = result * 59 + (this.isFollowState() ? 79 : 97);
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
        Object $privateState = this.getPrivateState();
        result = result * 59 + ($privateState == null ? 43 : $privateState.hashCode());
        return result;
    }

    public String toString() {
        return "IntactArticleVos(intactArticleId=" + this.getIntactArticleId() + ", article=" + this.getArticle() + ", user=" + this.getUser() + ", image=" + this.getImage() + ", family=" + this.getFamily() + ", likeStatus=" + this.isLikeStatus() + ", fansState=" + this.isFansState() + ", privateState=" + this.getPrivateState() + ", followState=" + this.isFollowState() + ")";
    }

    public IntactArticleVos(final String intactArticleId, final ArticleVo article, final UserVo user, final ImageVo image, final FamilyVo family, final boolean likeStatus, final boolean fansState, final String privateState, final boolean followState) {
        this.intactArticleId = intactArticleId;
        this.article = article;
        this.user = user;
        this.image = image;
        this.family = family;
        this.likeStatus = likeStatus;
        this.fansState = fansState;
        this.privateState = privateState;
        this.followState = followState;
    }

    public IntactArticleVos() {
    }
}
