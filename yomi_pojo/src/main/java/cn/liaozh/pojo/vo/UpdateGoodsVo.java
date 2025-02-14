package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class UpdateGoodsVo {
    @JsonProperty("goodsId")
    private String intactGoodsId;
    private @NotEmpty(
            message = "标题不能为空"
    ) String goodsName;
    private @NotEmpty(
            message = "内容描述不能为空"
    ) String goodsDescribe;
    private @NotEmpty(
            message = "类型不能为空"
    ) String familyId;
    private String[] goodsImage;
    private @Min(1L) @NotNull(
            message = "价格不能为空"
    ) Double goodsPrice;

    public UpdateGoodsVo() {
    }

    public String getIntactGoodsId() {
        return this.intactGoodsId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public String getGoodsDescribe() {
        return this.goodsDescribe;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String[] getGoodsImage() {
        return this.goodsImage;
    }

    public @NotNull(
            message = "价格不能为空"
    ) Double getGoodsPrice() {
        return this.goodsPrice;
    }

    @JsonProperty("goodsId")
    public void setIntactGoodsId(final String intactGoodsId) {
        this.intactGoodsId = intactGoodsId;
    }

    public void setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsDescribe(final String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public void setFamilyId(final String familyId) {
        this.familyId = familyId;
    }

    public void setGoodsImage(final String[] goodsImage) {
        this.goodsImage = goodsImage;
    }

    public void setGoodsPrice(final @NotNull(
            message = "价格不能为空"
    ) Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UpdateGoodsVo)) {
            return false;
        } else {
            UpdateGoodsVo other = (UpdateGoodsVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$goodsPrice = this.getGoodsPrice();
                Object other$goodsPrice = other.getGoodsPrice();
                if (this$goodsPrice == null) {
                    if (other$goodsPrice != null) {
                        return false;
                    }
                } else if (!this$goodsPrice.equals(other$goodsPrice)) {
                    return false;
                }

                Object this$intactGoodsId = this.getIntactGoodsId();
                Object other$intactGoodsId = other.getIntactGoodsId();
                if (this$intactGoodsId == null) {
                    if (other$intactGoodsId != null) {
                        return false;
                    }
                } else if (!this$intactGoodsId.equals(other$intactGoodsId)) {
                    return false;
                }

                Object this$goodsName = this.getGoodsName();
                Object other$goodsName = other.getGoodsName();
                if (this$goodsName == null) {
                    if (other$goodsName != null) {
                        return false;
                    }
                } else if (!this$goodsName.equals(other$goodsName)) {
                    return false;
                }

                Object this$goodsDescribe = this.getGoodsDescribe();
                Object other$goodsDescribe = other.getGoodsDescribe();
                if (this$goodsDescribe == null) {
                    if (other$goodsDescribe != null) {
                        return false;
                    }
                } else if (!this$goodsDescribe.equals(other$goodsDescribe)) {
                    return false;
                }

                Object this$familyId = this.getFamilyId();
                Object other$familyId = other.getFamilyId();
                if (this$familyId == null) {
                    if (other$familyId != null) {
                        return false;
                    }
                } else if (!this$familyId.equals(other$familyId)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getGoodsImage(), other.getGoodsImage())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateGoodsVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $goodsPrice = this.getGoodsPrice();
        result = result * 59 + ($goodsPrice == null ? 43 : $goodsPrice.hashCode());
        Object $intactGoodsId = this.getIntactGoodsId();
        result = result * 59 + ($intactGoodsId == null ? 43 : $intactGoodsId.hashCode());
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        Object $goodsDescribe = this.getGoodsDescribe();
        result = result * 59 + ($goodsDescribe == null ? 43 : $goodsDescribe.hashCode());
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getGoodsImage());
        return result;
    }

    public String toString() {
        return "UpdateGoodsVo(intactGoodsId=" + this.getIntactGoodsId() + ", goodsName=" + this.getGoodsName() + ", goodsDescribe=" + this.getGoodsDescribe() + ", familyId=" + this.getFamilyId() + ", goodsImage=" + Arrays.deepToString(this.getGoodsImage()) + ", goodsPrice=" + this.getGoodsPrice() + ")";
    }
}
