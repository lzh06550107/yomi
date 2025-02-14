package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class CommentDTO {
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
    private String link;
    @ApiModelProperty("用于回复")
    private String parentId;
    @ApiModelProperty("点赞数")
    private Integer commentNum;
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
    private String articleId;
    private String oneCommentId;

    public CommentDTO() {
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

    public String getLink() {
        return this.link;
    }

    public String getParentId() {
        return this.parentId;
    }

    public Integer getCommentNum() {
        return this.commentNum;
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

    public String getArticleId() {
        return this.articleId;
    }

    public String getOneCommentId() {
        return this.oneCommentId;
    }

    public void setCommentId(final String commentId) {
        this.commentId = commentId;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public void setCommentNum(final Integer commentNum) {
        this.commentNum = commentNum;
    }

    @JsonIgnore
    public void setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    public void setOneCommentId(final String oneCommentId) {
        this.oneCommentId = oneCommentId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommentDTO)) {
            return false;
        } else {
            CommentDTO other = (CommentDTO)o;
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

                Object this$link = this.getLink();
                Object other$link = other.getLink();
                if (this$link == null) {
                    if (other$link != null) {
                        return false;
                    }
                } else if (!this$link.equals(other$link)) {
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

                Object this$articleId = this.getArticleId();
                Object other$articleId = other.getArticleId();
                if (this$articleId == null) {
                    if (other$articleId != null) {
                        return false;
                    }
                } else if (!this$articleId.equals(other$articleId)) {
                    return false;
                }

                Object this$oneCommentId = this.getOneCommentId();
                Object other$oneCommentId = other.getOneCommentId();
                if (this$oneCommentId == null) {
                    if (other$oneCommentId != null) {
                        return false;
                    }
                } else if (!this$oneCommentId.equals(other$oneCommentId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentDTO;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $commentNum = this.getCommentNum();
        result = result * 59 + ($commentNum == null ? 43 : $commentNum.hashCode());
        Object $commentId = this.getCommentId();
        result = result * 59 + ($commentId == null ? 43 : $commentId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $oneCommentId = this.getOneCommentId();
        result = result * 59 + ($oneCommentId == null ? 43 : $oneCommentId.hashCode());
        return result;
    }

    public String toString() {
        return "CommentDTO(commentId=" + this.getCommentId() + ", content=" + this.getContent() + ", userId=" + this.getUserId() + ", link=" + this.getLink() + ", parentId=" + this.getParentId() + ", commentNum=" + this.getCommentNum() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", articleId=" + this.getArticleId() + ", oneCommentId=" + this.getOneCommentId() + ")";
    }
}

