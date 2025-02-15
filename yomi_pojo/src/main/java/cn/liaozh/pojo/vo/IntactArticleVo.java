package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class IntactArticleVo implements Serializable {

    private String intactArticleId;
    private ArticleVo article;
    private UserVo user;
    private ImageVo image;
    private FamilyVo family;

}
