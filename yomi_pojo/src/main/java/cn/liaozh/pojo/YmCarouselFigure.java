package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;


@ApiModel(
        value = "YmCarouselFigure对象",
        description = ""
)
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmCarouselFigure extends Model<YmCarouselFigure> {

    @ApiModelProperty("文章id")
    @TableId(
        value = "id",
        type = IdType.ASSIGN_ID
    )
    private String id;

    @ApiModelProperty("删除状态 0 1")
    private String isDelete;

    @ApiModelProperty("标题")
    private @NotBlank(
        message = "标题不能为空"
    ) String title;

    @ApiModelProperty("正文")
    private @NotBlank String content;

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

    @ApiModelProperty("二手轮播图url")
    private String img;

    @ApiModelProperty("作者")
    private String authName;

    private String type;

    private String url;
}

