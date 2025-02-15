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

@ApiModel("YmCommodityFamily对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmCommodityFamily implements Serializable {
    @TableId(
        value = "family_id",
        type = IdType.ASSIGN_ID
    )
    private String familyId;

    @ApiModelProperty("分类名称")
    private String familyName;

    @ApiModelProperty("分类图片")
    private String familyImage;

    @TableField(
        fill = FieldFill.INSERT
    )
    private String createTime;

    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
}

