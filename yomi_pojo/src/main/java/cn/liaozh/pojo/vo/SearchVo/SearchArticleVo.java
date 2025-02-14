package cn.liaozh.pojo.vo.SearchVo;

import cn.liaozh.pojo.vo.ArticleVo;
import cn.liaozh.pojo.vo.ImageVo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchArticleVo {
    @JsonProperty("articleId")
    private String intactArticleId;
    private ArticleVo article;
    private SearchUserVo user;
    private ImageVo image;
    private boolean likeStatus;
    private boolean fansState;
    private String privateState;
    private boolean mutualConcern;

    public String getIntactArticleId() {
        return this.intactArticleId;
    }

    public ArticleVo getArticle() {
        return this.article;
    }

    public SearchUserVo getUser() {
        return this.user;
    }

    public ImageVo getImage() {
        return this.image;
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

    public boolean isMutualConcern() {
        return this.mutualConcern;
    }

    @JsonProperty("articleId")
    public SearchArticleVo setIntactArticleId(final String intactArticleId) {
        this.intactArticleId = intactArticleId;
        return this;
    }

    public SearchArticleVo setArticle(final ArticleVo article) {
        this.article = article;
        return this;
    }

    public SearchArticleVo setUser(final SearchUserVo user) {
        this.user = user;
        return this;
    }

    public SearchArticleVo setImage(final ImageVo image) {
        this.image = image;
        return this;
    }

    public SearchArticleVo setLikeStatus(final boolean likeStatus) {
        this.likeStatus = likeStatus;
        return this;
    }

    public SearchArticleVo setFansState(final boolean fansState) {
        this.fansState = fansState;
        return this;
    }

    public SearchArticleVo setPrivateState(final String privateState) {
        this.privateState = privateState;
        return this;
    }

    public SearchArticleVo setMutualConcern(final boolean mutualConcern) {
        this.mutualConcern = mutualConcern;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SearchArticleVo)) {
            return false;
        } else {
            SearchArticleVo other = (SearchArticleVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isLikeStatus() != other.isLikeStatus()) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
                return false;
            } else if (this.isMutualConcern() != other.isMutualConcern()) {
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
        return other instanceof SearchArticleVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isLikeStatus() ? 79 : 97);
        result = result * 59 + (this.isFansState() ? 79 : 97);
        result = result * 59 + (this.isMutualConcern() ? 79 : 97);
        Object $intactArticleId = this.getIntactArticleId();
        result = result * 59 + ($intactArticleId == null ? 43 : $intactArticleId.hashCode());
        Object $article = this.getArticle();
        result = result * 59 + ($article == null ? 43 : $article.hashCode());
        Object $user = this.getUser();
        result = result * 59 + ($user == null ? 43 : $user.hashCode());
        Object $image = this.getImage();
        result = result * 59 + ($image == null ? 43 : $image.hashCode());
        Object $privateState = this.getPrivateState();
        result = result * 59 + ($privateState == null ? 43 : $privateState.hashCode());
        return result;
    }

    public String toString() {
        return "SearchArticleVo(intactArticleId=" + this.getIntactArticleId() + ", article=" + this.getArticle() + ", user=" + this.getUser() + ", image=" + this.getImage() + ", likeStatus=" + this.isLikeStatus() + ", fansState=" + this.isFansState() + ", privateState=" + this.getPrivateState() + ", mutualConcern=" + this.isMutualConcern() + ")";
    }

    public SearchArticleVo(final String intactArticleId, final ArticleVo article, final SearchUserVo user, final ImageVo image, final boolean likeStatus, final boolean fansState, final String privateState, final boolean mutualConcern) {
        this.intactArticleId = intactArticleId;
        this.article = article;
        this.user = user;
        this.image = image;
        this.likeStatus = likeStatus;
        this.fansState = fansState;
        this.privateState = privateState;
        this.mutualConcern = mutualConcern;
    }

    public SearchArticleVo() {
    }
}

