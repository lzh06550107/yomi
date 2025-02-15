package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel(
    value = "YmCommentLike对象",
    description = ""
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmCommentsLike implements Serializable {

    @ApiModelProperty("点赞id")
    @TableId(
        value = "like_id",
        type = IdType.ASSIGN_ID
    )
    private String likeId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("评论id")
    private String commentId;

    @ApiModelProperty("点赞状态 0点赞 1取消")
    private String likeState;

    @TableField(
        fill = FieldFill.INSERT
    )
    private String createTime;

    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
}
