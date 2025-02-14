package cn.liaozh.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    public CommodityVos() {
    }

    public String getIntactGoodsId() {
        return this.intactGoodsId;
    }

    public String getUserId() {
        return this.userId;
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

    public String getViewsNum() {
        return this.viewsNum;
    }

    public String getGoodsDescribe() {
        return this.goodsDescribe;
    }

    public Double getGoodsPrice() {
        return this.goodsPrice;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getGoodsImage() {
        return this.goodsImage;
    }

    public int getNumberOfComments() {
        return this.numberOfComments;
    }

    public boolean isFansState() {
        return this.fansState;
    }

    public String getType() {
        return this.type;
    }

    public List<String> getTag() {
        return this.tag;
    }

    public boolean isFollowState() {
        return this.followState;
    }

    @JsonProperty("goodsId")
    public void setIntactGoodsId(final String intactGoodsId) {
        this.intactGoodsId = intactGoodsId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
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

    public void setViewsNum(final String viewsNum) {
        this.viewsNum = viewsNum;
    }

    public void setGoodsDescribe(final String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public void setGoodsPrice(final Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setGoodsImage(final String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public void setNumberOfComments(final int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public void setFansState(final boolean fansState) {
        this.fansState = fansState;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setTag(final List<String> tag) {
        this.tag = tag;
    }

    public void setFollowState(final boolean followState) {
        this.followState = followState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommodityVos)) {
            return false;
        } else {
            CommodityVos other = (CommodityVos)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getNumberOfComments() != other.getNumberOfComments()) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
                return false;
            } else if (this.isFollowState() != other.isFollowState()) {
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

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
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

                Object this$viewsNum = this.getViewsNum();
                Object other$viewsNum = other.getViewsNum();
                if (this$viewsNum == null) {
                    if (other$viewsNum != null) {
                        return false;
                    }
                } else if (!this$viewsNum.equals(other$viewsNum)) {
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
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

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                Object this$tag = this.getTag();
                Object other$tag = other.getTag();
                if (this$tag == null) {
                    if (other$tag != null) {
                        return false;
                    }
                } else if (!this$tag.equals(other$tag)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommodityVos;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getNumberOfComments();
        result = result * 59 + (this.isFansState() ? 79 : 97);
        result = result * 59 + (this.isFollowState() ? 79 : 97);
        Object $goodsPrice = this.getGoodsPrice();
        result = result * 59 + ($goodsPrice == null ? 43 : $goodsPrice.hashCode());
        Object $intactGoodsId = this.getIntactGoodsId();
        result = result * 59 + ($intactGoodsId == null ? 43 : $intactGoodsId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        Object $goodsName = this.getGoodsName();
        result = result * 59 + ($goodsName == null ? 43 : $goodsName.hashCode());
        Object $viewsNum = this.getViewsNum();
        result = result * 59 + ($viewsNum == null ? 43 : $viewsNum.hashCode());
        Object $goodsDescribe = this.getGoodsDescribe();
        result = result * 59 + ($goodsDescribe == null ? 43 : $goodsDescribe.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $goodsImage = this.getGoodsImage();
        result = result * 59 + ($goodsImage == null ? 43 : $goodsImage.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $tag = this.getTag();
        result = result * 59 + ($tag == null ? 43 : $tag.hashCode());
        return result;
    }

    public String toString() {
        return "CommodityVos(intactGoodsId=" + this.getIntactGoodsId() + ", userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", avatar=" + this.getAvatar() + ", familyName=" + this.getFamilyName() + ", goodsName=" + this.getGoodsName() + ", viewsNum=" + this.getViewsNum() + ", goodsDescribe=" + this.getGoodsDescribe() + ", goodsPrice=" + this.getGoodsPrice() + ", createTime=" + this.getCreateTime() + ", goodsImage=" + this.getGoodsImage() + ", numberOfComments=" + this.getNumberOfComments() + ", fansState=" + this.isFansState() + ", type=" + this.getType() + ", tag=" + this.getTag() + ", followState=" + this.isFollowState() + ")";
    }
}
