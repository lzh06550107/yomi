package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("YmGoods对象")
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

    public YmGoods() {
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public String getGoodsDescribe() {
        return this.goodsDescribe;
    }

    public Integer getViewsNum() {
        return this.viewsNum;
    }

    public String getContact() {
        return this.contact;
    }

    public String getGoodsImage() {
        return this.goodsImage;
    }

    public Double getGoodsPrice() {
        return this.goodsPrice;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    @JsonIgnore
    public YmGoods setGoodsId(final String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public YmGoods setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public YmGoods setGoodsDescribe(final String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
        return this;
    }

    public YmGoods setViewsNum(final Integer viewsNum) {
        this.viewsNum = viewsNum;
        return this;
    }

    public YmGoods setContact(final String contact) {
        this.contact = contact;
        return this;
    }

    public YmGoods setGoodsImage(final String goodsImage) {
        this.goodsImage = goodsImage;
        return this;
    }

    public YmGoods setGoodsPrice(final Double goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public YmGoods setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmGoods setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmGoods(goodsId=" + this.getGoodsId() + ", goodsName=" + this.getGoodsName() + ", goodsDescribe=" + this.getGoodsDescribe() + ", viewsNum=" + this.getViewsNum() + ", contact=" + this.getContact() + ", goodsImage=" + this.getGoodsImage() + ", goodsPrice=" + this.getGoodsPrice() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmGoods)) {
            return false;
        } else {
            YmGoods other = (YmGoods)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$viewsNum = this.getViewsNum();
                Object other$viewsNum = other.getViewsNum();
                if (this$viewsNum == null) {
                    if (other$viewsNum != null) {
                        return false;
                    }
                } else if (!this$viewsNum.equals(other$viewsNum)) {
                    return false;
                }

                Object this$goodsPrice = this.getGoodsPrice();
                Object other$goodsPrice = other.getGoodsPrice();
                if (this$goodsPrice == null) {
                    if (other$goodsPrice != null) {
                        return false;
                    }
                } else if (!this$goodsPrice.equals(other$goodsPrice)) {
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

                Object this$contact = this.getContact();
                Object other$contact = other.getContact();
                if (this$contact == null) {
                    if (other$contact != null) {
                        return false;
                    }
                } else if (!this$contact.equals(other$contact)) {
                    return false;
                }

                Object this$goodsImage = this.getGoodsImage();
                Object other$goodsImage = other.getGoodsImage();
                if (this$goodsImage == null) {
                    if (other$goodsImage != null) {
                        return false;
                    }
                } else if (!this$goodsImage.equals(other$goodsImage)) {
                    return false;
                }

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                Object this$updateTime = this.getUpdateTime();
                Object other$updateTime = other.getUpdateTime();
                if (this$updateTime == null) {
                    if (other$updateTime != null) {
                        return false;
                    }
                } else if (!this$updateTime.equals(other$updateTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmGoods;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $viewsNum = this.getViewsNum();
        result = result * 59 + ($viewsNum == null ? 43 : $viewsNum.hashCode());
        Object $goodsPrice = this.getGoodsPrice();
        result = result * 59 + ($goodsPrice == null ? 43 : $goodsPrice.hashCode());
        Object $goodsId = this.getGoodsId();
        result = result * 59 + ($goodsId == null ? 43 : $goodsId.hashCode());
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        Object $goodsDescribe = this.getGoodsDescribe();
        result = result * 59 + ($goodsDescribe == null ? 43 : $goodsDescribe.hashCode());
        Object $contact = this.getContact();
        result = result * 59 + ($contact == null ? 43 : $contact.hashCode());
        Object $goodsImage = this.getGoodsImage();
        result = result * 59 + ($goodsImage == null ? 43 : $goodsImage.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}
