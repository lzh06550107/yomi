package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public CommodityVo() {
    }

    public String getIntactGoodsId() {
        return this.intactGoodsId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public String getGoodsDescribe() {
        return this.goodsDescribe;
    }

    public Double getGoodsPrice() {
        return this.goodsPrice;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getGoodsImage() {
        return this.goodsImage;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isFansState() {
        return this.fansState;
    }

    @JsonProperty("goodsId")
    public void setIntactGoodsId(final String intactGoodsId) {
        this.intactGoodsId = intactGoodsId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public void setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsDescribe(final String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public void setGoodsPrice(final Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setCreateTime(final Long createTime) {
        this.createTime = createTime;
    }

    public void setGoodsImage(final String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setFansState(final boolean fansState) {
        this.fansState = fansState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommodityVo)) {
            return false;
        } else {
            CommodityVo other = (CommodityVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
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

                Object this$userName = this.getUserName();
                Object other$userName = other.getUserName();
                if (this$userName == null) {
                    if (other$userName != null) {
                        return false;
                    }
                } else if (!this$userName.equals(other$userName)) {
                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                Object this$familyName = this.getFamilyName();
                Object other$familyName = other.getFamilyName();
                if (this$familyName == null) {
                    if (other$familyName != null) {
                        return false;
                    }
                } else if (!this$familyName.equals(other$familyName)) {
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

                Object this$goodsImage = this.getGoodsImage();
                Object other$goodsImage = other.getGoodsImage();
                if (this$goodsImage == null) {
                    if (other$goodsImage != null) {
                        return false;
                    }
                } else if (!this$goodsImage.equals(other$goodsImage)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommodityVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isFansState() ? 79 : 97);
        Object $goodsPrice = this.getGoodsPrice();
        result = result * 59 + ($goodsPrice == null ? 43 : $goodsPrice.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $intactGoodsId = this.getIntactGoodsId();
        result = result * 59 + ($intactGoodsId == null ? 43 : $intactGoodsId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        Object $goodsDescribe = this.getGoodsDescribe();
        result = result * 59 + ($goodsDescribe == null ? 43 : $goodsDescribe.hashCode());
        Object $goodsImage = this.getGoodsImage();
        result = result * 59 + ($goodsImage == null ? 43 : $goodsImage.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        return result;
    }

    public String toString() {
        return "CommodityVo(intactGoodsId=" + this.getIntactGoodsId() + ", userName=" + this.getUserName() + ", avatar=" + this.getAvatar() + ", familyName=" + this.getFamilyName() + ", goodsName=" + this.getGoodsName() + ", goodsDescribe=" + this.getGoodsDescribe() + ", goodsPrice=" + this.getGoodsPrice() + ", createTime=" + this.getCreateTime() + ", goodsImage=" + this.getGoodsImage() + ", userId=" + this.getUserId() + ", fansState=" + this.isFansState() + ")";
    }
}
