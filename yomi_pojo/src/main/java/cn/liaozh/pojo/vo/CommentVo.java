package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@ApiModel(
        value = "YmComment对象",
        description = "评论主表"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommentVo {

    @ApiModelProperty("评论主键id")
    @TableId(
            value = "comment_id",
            type = IdType.ASSIGN_ID
    )
    private String commentId;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用于回复")
    private String parentId;

    @ApiModelProperty("点赞数")
    private Integer commentNum;

    @ApiModelProperty("软删除 0可用 1删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

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

    private String articleId;

    private String oneCommentId;
}

