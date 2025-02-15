package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel("YmIntactGoods对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmIntactGoods implements Serializable {
    @TableId(
        value = "intact_goods_id",
        type = IdType.ASSIGN_ID
    )
    @JsonProperty("goodsId")
    private String intactGoodsId;

    @ApiModelProperty("分类id")
    private String familyId;

    @ApiModelProperty("物品id")
    @JsonIgnore
    private String goodsId;

    private String userId;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

    private String type;
}

