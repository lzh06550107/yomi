package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("YmCommodityFamily对象")
public class YmCommodityFamily implements Serializable {
    @TableId(
            value = "family_id",
            type = IdType.ASSIGN_ID
    )
    private String familyId;
    @ApiModelProperty("分类名称")
    private String familyName;
    @ApiModelProperty("分类图片")
    private String familyImage;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    public YmCommodityFamily() {
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getFamilyImage() {
        return this.familyImage;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public YmCommodityFamily setFamilyId(final String familyId) {
        this.familyId = familyId;
        return this;
    }

    public YmCommodityFamily setFamilyName(final String familyName) {
        this.familyName = familyName;
        return this;
    }

    public YmCommodityFamily setFamilyImage(final String familyImage) {
        this.familyImage = familyImage;
        return this;
    }

    public YmCommodityFamily setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmCommodityFamily setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String toString() {
        return "YmCommodityFamily(familyId=" + this.getFamilyId() + ", familyName=" + this.getFamilyName() + ", familyImage=" + this.getFamilyImage() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmCommodityFamily)) {
            return false;
        } else {
            YmCommodityFamily other = (YmCommodityFamily)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$familyId = this.getFamilyId();
                Object other$familyId = other.getFamilyId();
                if (this$familyId == null) {
                    if (other$familyId != null) {
                        return false;
                    }
                } else if (!this$familyId.equals(other$familyId)) {
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

                Object this$familyImage = this.getFamilyImage();
                Object other$familyImage = other.getFamilyImage();
                if (this$familyImage == null) {
                    if (other$familyImage != null) {
                        return false;
                    }
                } else if (!this$familyImage.equals(other$familyImage)) {
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
        return other instanceof YmCommodityFamily;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        Object $familyImage = this.getFamilyImage();
        result = result * 59 + ($familyImage == null ? 43 : $familyImage.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }
}

