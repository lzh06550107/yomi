package cn.liaozh.pojo.vo;

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
public class IntactArticleDTO {

    private String intactArticleId;

    @TableId(
            value = "article_id",
            type = IdType.ASSIGN_ID
    )
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
    private String userId;
    private String openId;
    private String userName;
    private String classId;
    private String phoneNumber;
    private String signature;
    private Integer fansNum;
    private String sex;
    @JsonIgnore
    private String online;
    private String avatar;
    private String imageLink;
    private String familyName;
    private String privateState;
    private boolean likeStatus;
    private boolean fansState;
}
