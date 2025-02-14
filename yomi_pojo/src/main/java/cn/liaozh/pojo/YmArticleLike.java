package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmArticleLike对象",
        description = ""
)
public class YmArticleLike implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("点赞id")
    @TableId(
            value = "article_like_id",
            type = IdType.ASSIGN_ID
    )
    private String articleLikeId;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("点赞的文章")
    private String articleId;
    @ApiModelProperty("点赞状态 0点赞 1取消")
    private String likeState;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    public YmArticleLike() {
    }

    public String getArticleLikeId() {
        return this.articleLikeId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getLikeState() {
        return this.likeState;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public YmArticleLike setArticleLikeId(final String articleLikeId) {
        this.articleLikeId = articleLikeId;
        return this;
    }

    public YmArticleLike setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmArticleLike setArticleId(final String articleId) {
        this.articleId = articleId;
        return this;
    }

    public YmArticleLike setLikeState(final String likeState) {
        this.likeState = likeState;
        return this;
    }

    public YmArticleLike setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmArticleLike setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmArticleLike(articleLikeId=" + this.getArticleLikeId() + ", userId=" + this.getUserId() + ", articleId=" + this.getArticleId() + ", likeState=" + this.getLikeState() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmArticleLike)) {
            return false;
        } else {
            YmArticleLike other = (YmArticleLike)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$articleLikeId = this.getArticleLikeId();
                Object other$articleLikeId = other.getArticleLikeId();
                if (this$articleLikeId == null) {
                    if (other$articleLikeId != null) {
                        return false;
                    }
                } else if (!this$articleLikeId.equals(other$articleLikeId)) {
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                Object this$updateTime = this.getUpdateTime();
                Object other$updateTime = other.getUpdateTime();
                if (this$updateTime == null) {
                    if (other$updateTime != null) {
                        return false;
                    }
                } else if (!this$updateTime.equals(other$updateTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmArticleLike;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $articleLikeId = this.getArticleLikeId();
        result = result * 59 + ($articleLikeId == null ? 43 : $articleLikeId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $likeState = this.getLikeState();
        result = result * 59 + ($likeState == null ? 43 : $likeState.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}
