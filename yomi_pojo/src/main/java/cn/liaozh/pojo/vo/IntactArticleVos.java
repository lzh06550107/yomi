package cn.liaozh.pojo.vo;

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
public class IntactArticleVos {

    @JsonProperty("articleId")
    private String intactArticleId;
    private ArticleVo article;
    private UserVo user;
    private ImageVo image;
    private FamilyVo family;
    private boolean likeStatus;
    private boolean fansState;
    private String privateState;
    private boolean followState;

}
