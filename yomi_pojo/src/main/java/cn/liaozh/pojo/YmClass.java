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
        value = "YmClass对象",
        description = ""
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmClass implements Serializable {

    @ApiModelProperty("班级id")
    @TableId(
        value = "class_id",
        type = IdType.ASSIGN_ID
    )
    private String classId;

    @ApiModelProperty("子级id")
    private String parentId;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("详细介绍")
    private String info;

    @ApiModelProperty("删除状态 0可用 1删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

    @ApiModelProperty("创建时间")
    @TableField(
        fill = FieldFill.INSERT
    )
    private String createTime;

    @ApiModelProperty("更新时间")
    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    @ApiModelProperty("删除时间")
    private String deleteTime;
}

