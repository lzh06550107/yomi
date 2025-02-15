package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel("YmGoods对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmGoods implements Serializable {
    @TableId(
            value = "goods_id",
            type = IdType.ASSIGN_ID
    )
    @JsonIgnore
    private String goodsId;

    private String goodsName;

    private String goodsDescribe;

    @ApiModelProperty("浏览量")
    private Integer viewsNum;

    private String contact;

    private String goodsImage;

    private Double goodsPrice;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;

    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
}
