package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommodityVos {
    @JsonProperty("goodsId")
    private String intactGoodsId;
    private String userId;
    private String userName;
    private String avatar;
    private String familyName;
    private String goodsName;
    private String viewsNum;
    private String goodsDescribe;
    private Double goodsPrice;
    private String createTime;
    private String goodsImage;
    private int numberOfComments;
    private boolean fansState;
    private String type;
    private List<String> tag;
    private boolean followState;
}
