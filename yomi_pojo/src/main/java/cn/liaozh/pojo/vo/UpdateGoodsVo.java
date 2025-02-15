package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UpdateGoodsVo {

    @JsonProperty("goodsId")
    private String intactGoodsId;

    @NotEmpty(
            message = "标题不能为空"
    )
    private String goodsName;

    @NotEmpty(
            message = "内容描述不能为空"
    )
    private String goodsDescribe;

    @NotEmpty(
            message = "类型不能为空"
    )
    private String familyId;

    private String[] goodsImage;

    @Min(1L)
    @NotNull(
            message = "价格不能为空"
    )
    private Double goodsPrice;

}
