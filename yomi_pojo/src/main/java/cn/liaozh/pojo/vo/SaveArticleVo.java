package cn.liaozh.pojo.vo;

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
public class SaveArticleVo {

    private @NotBlank String familyId;
    private @NotBlank String title;
    private String content;
    private String[] imageLink;

}


