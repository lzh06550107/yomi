package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
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
        value = "YmArticleImage对象",
        description = ""
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmArticleImage implements Serializable {

    @ApiModelProperty("图片id")
    @TableId(
        value = "article_image_id",
        type = IdType.ASSIGN_ID
    )
    private String articleImageId;

    @ApiModelProperty("图片连接  用逗号分割")
    private String imageLink;

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

    @JsonIgnore
    @ApiModelProperty("软删除 0是未删除，1是删除")
    @TableLogic
    private String isDeleted;
}
