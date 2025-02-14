package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmComment对象",
        description = "评论主表"
)
public class YmComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("评论主键id")
    @TableId(
            value = "comment_id",
            type = IdType.ASSIGN_ID
    )
    private String commentId;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("文章id")
    private String articleId;
    @ApiModelProperty("用于回复")
    private String parentId;
    @ApiModelProperty("点赞数")
    private Integer likeNum;
    @ApiModelProperty("图片连接")
    private String link;
    @ApiModelProperty("软删除 0可用 1删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;
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

    public YmComment() {
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public Integer getLikeNum() {
        return this.likeNum;
    }

    public String getLink() {
        return this.link;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public YmComment setCommentId(final String commentId) {
        this.commentId = commentId;
        return this;
    }

    public YmComment setContent(final String content) {
        this.content = content;
        return this;
    }

    public YmComment setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmComment setArticleId(final String articleId) {
        this.articleId = articleId;
        return this;
    }

    public YmComment setParentId(final String parentId) {
        this.parentId = parentId;
        return this;
    }

    public YmComment setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
        return this;
    }

    public YmComment setLink(final String link) {
        this.link = link;
        return this;
    }

    @JsonIgnore
    public YmComment setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmComment setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmComment setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmComment(commentId=" + this.getCommentId() + ", content=" + this.getContent() + ", userId=" + this.getUserId() + ", articleId=" + this.getArticleId() + ", parentId=" + this.getParentId() + ", likeNum=" + this.getLikeNum() + ", link=" + this.getLink() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmComment)) {
            return false;
        } else {
            YmComment other = (YmComment)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$likeNum = this.getLikeNum();
                Object other$likeNum = other.getLikeNum();
                if (this$likeNum == null) {
                    if (other$likeNum != null) {
                        return false;
                    }
                } else if (!this$likeNum.equals(other$likeNum)) {
                    return false;
                }

                Object this$commentId = this.getCommentId();
                Object other$commentId = other.getCommentId();
                if (this$commentId == null) {
                    if (other$commentId != null) {
                        return false;
                    }
                } else if (!this$commentId.equals(other$commentId)) {
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

                Object this$parentId = this.getParentId();
                Object other$parentId = other.getParentId();
                if (this$parentId == null) {
                    if (other$parentId != null) {
                        return false;
                    }
                } else if (!this$parentId.equals(other$parentId)) {
                    return false;
                }

                Object this$link = this.getLink();
                Object other$link = other.getLink();
                if (this$link == null) {
                    if (other$link != null) {
                        return false;
                    }
                } else if (!this$link.equals(other$link)) {
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
        return other instanceof YmComment;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $likeNum = this.getLikeNum();
        result = result * 59 + ($likeNum == null ? 43 : $likeNum.hashCode());
        Object $commentId = this.getCommentId();
        result = result * 59 + ($commentId == null ? 43 : $commentId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}
