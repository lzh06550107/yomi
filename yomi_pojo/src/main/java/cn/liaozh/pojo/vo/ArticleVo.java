package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmArticle;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public class ArticleVo {
    @TableId(
            value = "article_id",
            type = IdType.ASSIGN_ID
    )
    @JsonIgnore
    private String articleId;
    private @NotBlank(
            message = "标题不能为空"
    ) String title;
    private @NotBlank String content;
    private String createTime;
    private Integer commentNum;
    private Integer viewsNum;
    private Integer shareNum;
    private Integer likeNum;

    public ArticleVo(YmArticle ymArticle) {
        this.articleId = ymArticle.getArticleId();
        this.title = ymArticle.getTitle();
        this.content = ymArticle.getContent();
        this.createTime = ymArticle.getCreateTime();
        this.commentNum = ymArticle.getCommentNum();
        this.viewsNum = ymArticle.getViewsNum();
        this.shareNum = ymArticle.getShareNum();
        this.likeNum = ymArticle.getLikeNum();
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
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

    @JsonIgnore
    public void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setCommentNum(final Integer commentNum) {
        this.commentNum = commentNum;
    }

    public void setViewsNum(final Integer viewsNum) {
        this.viewsNum = viewsNum;
    }

    public void setShareNum(final Integer shareNum) {
        this.shareNum = shareNum;
    }

    public void setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ArticleVo)) {
            return false;
        } else {
            ArticleVo other = (ArticleVo)o;
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArticleVo;
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
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }

    public String toString() {
        return "ArticleVo(articleId=" + this.getArticleId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", createTime=" + this.getCreateTime() + ", commentNum=" + this.getCommentNum() + ", viewsNum=" + this.getViewsNum() + ", shareNum=" + this.getShareNum() + ", likeNum=" + this.getLikeNum() + ")";
    }

    public ArticleVo(final String articleId, final String title, final String content, final String createTime, final Integer commentNum, final Integer viewsNum, final Integer shareNum, final Integer likeNum) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.commentNum = commentNum;
        this.viewsNum = viewsNum;
        this.shareNum = shareNum;
        this.likeNum = likeNum;
    }

    public ArticleVo() {
    }
}

