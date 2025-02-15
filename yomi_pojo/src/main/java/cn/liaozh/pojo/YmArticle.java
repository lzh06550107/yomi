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
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(
        value = "YmArticle对象",
        description = ""
)
@Document(
        indexName = "articles"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmArticle implements Serializable {

    @ApiModelProperty("文章id")
    @JsonIgnore
    @TableId(
            value = "article_id",
            type = IdType.ASSIGN_ID
    )
    private String articleId;

    @ApiModelProperty("删除状态 0 1")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

    @Field(
            type = FieldType.Text,
            analyzer = "ik_max_word",
            searchAnalyzer = "ik_max_word"
    )
    @ApiModelProperty("标题")
    @NotBlank(
            message = "标题不能为空"
    )
    private String title;

    @Field(
            type = FieldType.Text,
            analyzer = "ik_max_word",
            searchAnalyzer = "ik_max_word"
    )
    @ApiModelProperty("正文")
    @NotBlank
    private String content;

    @ApiModelProperty("特殊文章，0是正常文章，1是特殊文章")
    private String special;

    @ApiModelProperty("评论数")
    private Integer commentNum;

    @ApiModelProperty("浏览量")
    private Integer viewsNum;

    @ApiModelProperty("转发数")
    private Integer shareNum;

    @ApiModelProperty("点赞数")
    private Integer likeNum;

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
}
