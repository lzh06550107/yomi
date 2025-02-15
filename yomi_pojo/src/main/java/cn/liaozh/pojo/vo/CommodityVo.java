package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommodityVo {
    @JsonProperty("goodsId")
    private String intactGoodsId;
    private String userName;
    private String avatar;
    private String familyName;
    private String goodsName;
    private String goodsDescribe;
    private Double goodsPrice;
    private Long createTime;
    private String goodsImage;
    private String userId;
    private boolean fansState;
}
