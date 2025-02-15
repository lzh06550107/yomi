package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel(
    value = "YmIntactArticle对象",
    description = ""
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmIntactArticle implements Serializable {

    @ApiModelProperty("发布文章id")
    @TableId(
        value = "intact_article_id",
        type = IdType.ASSIGN_ID
    )
    private String intactArticleId;

    @ApiModelProperty("文章id")
    private String articleId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("分类id")
    private String familyId;

    @ApiModelProperty("文章图片id")
    private String articleImageId;

    @ApiModelProperty("软删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

    private String privateState;
}

