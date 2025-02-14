package cn.liaozh.pojo.vo;

public class ArticleLikeStatus {
    private String articleId;
    private String likeState;

    public ArticleLikeStatus() {
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getLikeState() {
        return this.likeState;
    }

    public void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    public void setLikeState(final String likeState) {
        this.likeState = likeState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ArticleLikeStatus)) {
            return false;
        } else {
            ArticleLikeStatus other = (ArticleLikeStatus)o;
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

                Object this$likeState = this.getLikeState();
                Object other$likeState = other.getLikeState();
                if (this$likeState == null) {
                    if (other$likeState != null) {
                        return false;
                    }
                } else if (!this$likeState.equals(other$likeState)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArticleLikeStatus;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $likeState = this.getLikeState();
        result = result * 59 + ($likeState == null ? 43 : $likeState.hashCode());
        return result;
    }

    public String toString() {
        return "ArticleLikeStatus(articleId=" + this.getArticleId() + ", likeState=" + this.getLikeState() + ")";
    }
}
