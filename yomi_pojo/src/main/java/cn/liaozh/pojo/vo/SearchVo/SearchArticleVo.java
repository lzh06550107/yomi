package cn.liaozh.pojo.vo.SearchVo;

import cn.liaozh.pojo.vo.ArticleVo;
import cn.liaozh.pojo.vo.ImageVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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

}

