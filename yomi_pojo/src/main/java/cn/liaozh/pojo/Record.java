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
        value = "Record对象",
        description = "操作记录"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Record implements Serializable {

    @ApiModelProperty("操作记录id")
    @TableId(
            value = "record_id",
            type = IdType.AUTO
    )
    private Integer recordId;

    @ApiModelProperty("模块标题")
    private String title;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("操作的id")
    private String id;

    @ApiModelProperty("使用的那个方法")
    private String method;

    @ApiModelProperty("请求类型")
    private String requestMethod;

    @ApiModelProperty("当前使用的ip")
    private String operIp;

    @ApiModelProperty("请求的参数")
    private String operParam;

    @ApiModelProperty("返回的参数")
    private String jsonResult;

    @ApiModelProperty("异常信息")
    private String errorMsg;

    @ApiModelProperty("创建时间")
    @TableField(
        fill = FieldFill.INSERT
    )
    private String createTime;
}
