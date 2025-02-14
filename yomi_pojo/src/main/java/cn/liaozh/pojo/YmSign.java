package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@ApiModel("YmSign对象")
public class YmSign implements Serializable {
    @TableId(
            value = "sign_id",
            type = IdType.ASSIGN_ID
    )
    @JsonIgnore
    private String signId;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("签到日期")
    private Date signInDate;
    @TableField(
            exist = false
    )
    private Integer userSignCount;
    @TableField(
            exist = false
    )
    private Integer needDay;
    @TableField(
            exist = false
    )
    private int isSign;
    @TableField(
            exist = false
    )
    private YmCarouselFigure ymCarouselFigure;
    @TableField(
            exist = false
    )
    private String shopName;
    @TableField(
            exist = false
    )
    private String img;
    @TableField(
            exist = false
    )
    private Map items;
    @TableField(
            exist = false
    )
    private String IndexImg;

    public YmSign() {
    }

    public String getSignId() {
        return this.signId;
    }

    public String getUserId() {
        return this.userId;
    }

    public Date getSignInDate() {
        return this.signInDate;
    }

    public Integer getUserSignCount() {
        return this.userSignCount;
    }

    public Integer getNeedDay() {
        return this.needDay;
    }

    public int getIsSign() {
        return this.isSign;
    }

    public YmCarouselFigure getYmCarouselFigure() {
        return this.ymCarouselFigure;
    }

    public String getShopName() {
        return this.shopName;
    }

    public String getImg() {
        return this.img;
    }

    public Map getItems() {
        return this.items;
    }

    public String getIndexImg() {
        return this.IndexImg;
    }

    @JsonIgnore
    public YmSign setSignId(final String signId) {
        this.signId = signId;
        return this;
    }

    public YmSign setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmSign setSignInDate(final Date signInDate) {
        this.signInDate = signInDate;
        return this;
    }

    public YmSign setUserSignCount(final Integer userSignCount) {
        this.userSignCount = userSignCount;
        return this;
    }

    public YmSign setNeedDay(final Integer needDay) {
        this.needDay = needDay;
        return this;
    }

    public YmSign setIsSign(final int isSign) {
        this.isSign = isSign;
        return this;
    }

    public YmSign setYmCarouselFigure(final YmCarouselFigure ymCarouselFigure) {
        this.ymCarouselFigure = ymCarouselFigure;
        return this;
    }

    public YmSign setShopName(final String shopName) {
        this.shopName = shopName;
        return this;
    }

    public YmSign setImg(final String img) {
        this.img = img;
        return this;
    }

    public YmSign setItems(final Map items) {
        this.items = items;
        return this;
    }

    public YmSign setIndexImg(final String IndexImg) {
        this.IndexImg = IndexImg;
        return this;
    }

    public String toString() {
        return "YmSign(signId=" + this.getSignId() + ", userId=" + this.getUserId() + ", signInDate=" + this.getSignInDate() + ", userSignCount=" + this.getUserSignCount() + ", needDay=" + this.getNeedDay() + ", isSign=" + this.getIsSign() + ", ymCarouselFigure=" + this.getYmCarouselFigure() + ", shopName=" + this.getShopName() + ", img=" + this.getImg() + ", items=" + this.getItems() + ", IndexImg=" + this.getIndexImg() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmSign)) {
            return false;
        } else {
            YmSign other = (YmSign)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getIsSign() != other.getIsSign()) {
                return false;
            } else {
                Object this$userSignCount = this.getUserSignCount();
                Object other$userSignCount = other.getUserSignCount();
                if (this$userSignCount == null) {
                    if (other$userSignCount != null) {
                        return false;
                    }
                } else if (!this$userSignCount.equals(other$userSignCount)) {
                    return false;
                }

                Object this$needDay = this.getNeedDay();
                Object other$needDay = other.getNeedDay();
                if (this$needDay == null) {
                    if (other$needDay != null) {
                        return false;
                    }
                } else if (!this$needDay.equals(other$needDay)) {
                    return false;
                }

                Object this$signId = this.getSignId();
                Object other$signId = other.getSignId();
                if (this$signId == null) {
                    if (other$signId != null) {
                        return false;
                    }
                } else if (!this$signId.equals(other$signId)) {
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

                Object this$signInDate = this.getSignInDate();
                Object other$signInDate = other.getSignInDate();
                if (this$signInDate == null) {
                    if (other$signInDate != null) {
                        return false;
                    }
                } else if (!this$signInDate.equals(other$signInDate)) {
                    return false;
                }

                Object this$ymCarouselFigure = this.getYmCarouselFigure();
                Object other$ymCarouselFigure = other.getYmCarouselFigure();
                if (this$ymCarouselFigure == null) {
                    if (other$ymCarouselFigure != null) {
                        return false;
                    }
                } else if (!this$ymCarouselFigure.equals(other$ymCarouselFigure)) {
                    return false;
                }

                Object this$shopName = this.getShopName();
                Object other$shopName = other.getShopName();
                if (this$shopName == null) {
                    if (other$shopName != null) {
                        return false;
                    }
                } else if (!this$shopName.equals(other$shopName)) {
                    return false;
                }

                Object this$img = this.getImg();
                Object other$img = other.getImg();
                if (this$img == null) {
                    if (other$img != null) {
                        return false;
                    }
                } else if (!this$img.equals(other$img)) {
                    return false;
                }

                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                Object this$IndexImg = this.getIndexImg();
                Object other$IndexImg = other.getIndexImg();
                if (this$IndexImg == null) {
                    if (other$IndexImg != null) {
                        return false;
                    }
                } else if (!this$IndexImg.equals(other$IndexImg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmSign;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getIsSign();
        Object $userSignCount = this.getUserSignCount();
        result = result * 59 + ($userSignCount == null ? 43 : $userSignCount.hashCode());
        Object $needDay = this.getNeedDay();
        result = result * 59 + ($needDay == null ? 43 : $needDay.hashCode());
        Object $signId = this.getSignId();
        result = result * 59 + ($signId == null ? 43 : $signId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $signInDate = this.getSignInDate();
        result = result * 59 + ($signInDate == null ? 43 : $signInDate.hashCode());
        Object $ymCarouselFigure = this.getYmCarouselFigure();
        result = result * 59 + ($ymCarouselFigure == null ? 43 : $ymCarouselFigure.hashCode());
        Object $shopName = this.getShopName();
        result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
        Object $img = this.getImg();
        result = result * 59 + ($img == null ? 43 : $img.hashCode());
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        Object $IndexImg = this.getIndexImg();
        result = result * 59 + ($IndexImg == null ? 43 : $IndexImg.hashCode());
        return result;
    }
}
