package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmArticle;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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
}

