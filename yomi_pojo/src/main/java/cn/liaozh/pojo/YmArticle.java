package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(
        value = "YmArticle对象",
        description = ""
)
@Document(
        indexName = "articles"
)
public class YmArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("文章id")
    @JsonIgnore
    @TableId(
            value = "article_id",
            type = IdType.ASSIGN_ID
    )
    private String articleId;
    @ApiModelProperty("删除状态 0 1")
    @TableLogic
    @JsonIgnore
    private String isDeleted;
    @Field(
            type = FieldType.Text,
            analyzer = "ik_max_word",
            searchAnalyzer = "ik_max_word"
    )
    @ApiModelProperty("标题")
    private @NotBlank(
            message = "标题不能为空"
    ) String title;
    @Field(
            type = FieldType.Text,
            analyzer = "ik_max_word",
            searchAnalyzer = "ik_max_word"
    )
    @ApiModelProperty("正文")
    private @NotBlank String content;
    @ApiModelProperty("特殊文章，0是正常文章，1是特殊文章")
    private String special;
    @ApiModelProperty("评论数")
    private Integer commentNum;
    @ApiModelProperty("浏览量")
    private Integer viewsNum;
    @ApiModelProperty("转发数")
    private Integer shareNum;
    @ApiModelProperty("点赞数")
    private Integer likeNum;
    @ApiModelProperty("创建时间")
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @ApiModelProperty("修改时间")
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    public YmArticle() {
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getSpecial() {
        return this.special;
    }

    public Integer getCommentNum() {
        return this.commentNum;
    }

    public Integer getViewsNum() {
        return this.viewsNum;
    }

    public Integer getShareNum() {
        return this.shareNum;
    }

    public Integer getLikeNum() {
        return this.likeNum;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    @JsonIgnore
    public YmArticle setArticleId(final String articleId) {
        this.articleId = articleId;
        return this;
    }

    @JsonIgnore
    public YmArticle setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmArticle setTitle(final String title) {
        this.title = title;
        return this;
    }

    public YmArticle setContent(final String content) {
        this.content = content;
        return this;
    }

    public YmArticle setSpecial(final String special) {
        this.special = special;
        return this;
    }

    public YmArticle setCommentNum(final Integer commentNum) {
        this.commentNum = commentNum;
        return this;
    }

    public YmArticle setViewsNum(final Integer viewsNum) {
        this.viewsNum = viewsNum;
        return this;
    }

    public YmArticle setShareNum(final Integer shareNum) {
        this.shareNum = shareNum;
        return this;
    }

    public YmArticle setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
        return this;
    }

    public YmArticle setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmArticle setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmArticle(articleId=" + this.getArticleId() + ", isDeleted=" + this.getIsDeleted() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", special=" + this.getSpecial() + ", commentNum=" + this.getCommentNum() + ", viewsNum=" + this.getViewsNum() + ", shareNum=" + this.getShareNum() + ", likeNum=" + this.getLikeNum() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmArticle)) {
            return false;
        } else {
            YmArticle other = (YmArticle)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$commentNum = this.getCommentNum();
                Object other$commentNum = other.getCommentNum();
                if (this$commentNum == null) {
                    if (other$commentNum != null) {
                        return false;
                    }
                } else if (!this$commentNum.equals(other$commentNum)) {
                    return false;
                }

                Object this$viewsNum = this.getViewsNum();
                Object other$viewsNum = other.getViewsNum();
                if (this$viewsNum == null) {
                    if (other$viewsNum != null) {
                        return false;
                    }
                } else if (!this$viewsNum.equals(other$viewsNum)) {
                    return false;
                }

                Object this$shareNum = this.getShareNum();
                Object other$shareNum = other.getShareNum();
                if (this$shareNum == null) {
                    if (other$shareNum != null) {
                        return false;
                    }
                } else if (!this$shareNum.equals(other$shareNum)) {
                    return false;
                }

                Object this$likeNum = this.getLikeNum();
                Object other$likeNum = other.getLikeNum();
                if (this$likeNum == null) {
                    if (other$likeNum != null) {
                        return false;
                    }
                } else if (!this$likeNum.equals(other$likeNum)) {
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

                Object this$isDeleted = this.getIsDeleted();
                Object other$isDeleted = other.getIsDeleted();
                if (this$isDeleted == null) {
                    if (other$isDeleted != null) {
                        return false;
                    }
                } else if (!this$isDeleted.equals(other$isDeleted)) {
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

                Object this$special = this.getSpecial();
                Object other$special = other.getSpecial();
                if (this$special == null) {
                    if (other$special != null) {
                        return false;
                    }
                } else if (!this$special.equals(other$special)) {
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
        return other instanceof YmArticle;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $commentNum = this.getCommentNum();
        result = result * 59 + ($commentNum == null ? 43 : $commentNum.hashCode());
        Object $viewsNum = this.getViewsNum();
        result = result * 59 + ($viewsNum == null ? 43 : $viewsNum.hashCode());
        Object $shareNum = this.getShareNum();
        result = result * 59 + ($shareNum == null ? 43 : $shareNum.hashCode());
        Object $likeNum = this.getLikeNum();
        result = result * 59 + ($likeNum == null ? 43 : $likeNum.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $special = this.getSpecial();
        result = result * 59 + ($special == null ? 43 : $special.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}
