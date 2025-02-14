package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmIntactArticle对象",
        description = ""
)
public class YmIntactArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("发布文章id")
    @TableId(
            value = "intact_article_id",
            type = IdType.ASSIGN_ID
    )
    private String intactArticleId;
    @ApiModelProperty("文章id")
    private String articleId;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("分类id")
    private String familyId;
    @ApiModelProperty("文章图片id")
    private String articleImageId;
    @ApiModelProperty("软删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;
    private String privateState;

    public YmIntactArticle() {
    }

    public String getIntactArticleId() {
        return this.intactArticleId;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getArticleImageId() {
        return this.articleImageId;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getPrivateState() {
        return this.privateState;
    }

    public YmIntactArticle setIntactArticleId(final String intactArticleId) {
        this.intactArticleId = intactArticleId;
        return this;
    }

    public YmIntactArticle setArticleId(final String articleId) {
        this.articleId = articleId;
        return this;
    }

    public YmIntactArticle setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmIntactArticle setFamilyId(final String familyId) {
        this.familyId = familyId;
        return this;
    }

    public YmIntactArticle setArticleImageId(final String articleImageId) {
        this.articleImageId = articleImageId;
        return this;
    }

    @JsonIgnore
    public YmIntactArticle setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmIntactArticle setPrivateState(final String privateState) {
        this.privateState = privateState;
        return this;
    }

    public String toString() {
        return "YmIntactArticle(intactArticleId=" + this.getIntactArticleId() + ", articleId=" + this.getArticleId() + ", userId=" + this.getUserId() + ", familyId=" + this.getFamilyId() + ", articleImageId=" + this.getArticleImageId() + ", isDeleted=" + this.getIsDeleted() + ", privateState=" + this.getPrivateState() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmIntactArticle)) {
            return false;
        } else {
            YmIntactArticle other = (YmIntactArticle)o;
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

                Object this$articleId = this.getArticleId();
                Object other$articleId = other.getArticleId();
                if (this$articleId == null) {
                    if (other$articleId != null) {
                        return false;
                    }
                } else if (!this$articleId.equals(other$articleId)) {
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

                Object this$familyId = this.getFamilyId();
                Object other$familyId = other.getFamilyId();
                if (this$familyId == null) {
                    if (other$familyId != null) {
                        return false;
                    }
                } else if (!this$familyId.equals(other$familyId)) {
                    return false;
                }

                Object this$articleImageId = this.getArticleImageId();
                Object other$articleImageId = other.getArticleImageId();
                if (this$articleImageId == null) {
                    if (other$articleImageId != null) {
                        return false;
                    }
                } else if (!this$articleImageId.equals(other$articleImageId)) {
                    return false;
                }

                Object this$isDeleted = this.getIsDeleted();
                Object other$isDeleted = other.getIsDeleted();
                if (this$isDeleted == null) {
                    if (other$isDeleted != null) {
                        return false;
                    }
                } else if (!this$isDeleted.equals(other$isDeleted)) {
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
        return other instanceof YmIntactArticle;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $intactArticleId = this.getIntactArticleId();
        result = result * 59 + ($intactArticleId == null ? 43 : $intactArticleId.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        Object $articleImageId = this.getArticleImageId();
        result = result * 59 + ($articleImageId == null ? 43 : $articleImageId.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $privateState = this.getPrivateState();
        result = result * 59 + ($privateState == null ? 43 : $privateState.hashCode());
        return result;
    }
}

