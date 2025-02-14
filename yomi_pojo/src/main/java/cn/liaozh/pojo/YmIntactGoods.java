package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("YmIntactGoods对象")
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

    public YmIntactGoods() {
    }

    public String getIntactGoodsId() {
        return this.intactGoodsId;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getType() {
        return this.type;
    }

    @JsonProperty("goodsId")
    public YmIntactGoods setIntactGoodsId(final String intactGoodsId) {
        this.intactGoodsId = intactGoodsId;
        return this;
    }

    public YmIntactGoods setFamilyId(final String familyId) {
        this.familyId = familyId;
        return this;
    }

    @JsonIgnore
    public YmIntactGoods setGoodsId(final String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public YmIntactGoods setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    @JsonIgnore
    public YmIntactGoods setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmIntactGoods setType(final String type) {
        this.type = type;
        return this;
    }

    public String toString() {
        return "YmIntactGoods(intactGoodsId=" + this.getIntactGoodsId() + ", familyId=" + this.getFamilyId() + ", goodsId=" + this.getGoodsId() + ", userId=" + this.getUserId() + ", isDeleted=" + this.getIsDeleted() + ", type=" + this.getType() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmIntactGoods)) {
            return false;
        } else {
            YmIntactGoods other = (YmIntactGoods)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$intactGoodsId = this.getIntactGoodsId();
                Object other$intactGoodsId = other.getIntactGoodsId();
                if (this$intactGoodsId == null) {
                    if (other$intactGoodsId != null) {
                        return false;
                    }
                } else if (!this$intactGoodsId.equals(other$intactGoodsId)) {
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

                Object this$goodsId = this.getGoodsId();
                Object other$goodsId = other.getGoodsId();
                if (this$goodsId == null) {
                    if (other$goodsId != null) {
                        return false;
                    }
                } else if (!this$goodsId.equals(other$goodsId)) {
                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$isDeleted = this.getIsDeleted();
                Object other$isDeleted = other.getIsDeleted();
                if (this$isDeleted == null) {
                    if (other$isDeleted != null) {
                        return false;
                    }
                } else if (!this$isDeleted.equals(other$isDeleted)) {
                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmIntactGoods;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $intactGoodsId = this.getIntactGoodsId();
        result = result * 59 + ($intactGoodsId == null ? 43 : $intactGoodsId.hashCode());
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        Object $goodsId = this.getGoodsId();
        result = result * 59 + ($goodsId == null ? 43 : $goodsId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        return result;
    }
}

