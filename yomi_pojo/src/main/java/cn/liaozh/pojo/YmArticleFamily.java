package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmArticleFamily对象",
        description = ""
)
public class YmArticleFamily implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(
            value = "family_id",
            type = IdType.ASSIGN_ID
    )
    private String familyId;
    @ApiModelProperty("类别名称")
    private String familyName;
    @ApiModelProperty("是否删除 0 1")
    @TableLogic
    @JsonIgnore
    private String isDeleted;
    private String createTime;
    private String updateTime;
    @TableField(
            exist = false
    )
    private Integer type = 0;

    public YmArticleFamily(String familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.type = 1;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public Integer getType() {
        return this.type;
    }

    public YmArticleFamily setFamilyId(final String familyId) {
        this.familyId = familyId;
        return this;
    }

    public YmArticleFamily setFamilyName(final String familyName) {
        this.familyName = familyName;
        return this;
    }

    @JsonIgnore
    public YmArticleFamily setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmArticleFamily setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmArticleFamily setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public YmArticleFamily setType(final Integer type) {
        this.type = type;
        return this;
    }

    public String toString() {
        return "YmArticleFamily(familyId=" + this.getFamilyId() + ", familyName=" + this.getFamilyName() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", type=" + this.getType() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmArticleFamily)) {
            return false;
        } else {
            YmArticleFamily other = (YmArticleFamily)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
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

                Object this$familyName = this.getFamilyName();
                Object other$familyName = other.getFamilyName();
                if (this$familyName == null) {
                    if (other$familyName != null) {
                        return false;
                    }
                } else if (!this$familyName.equals(other$familyName)) {
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
        return other instanceof YmArticleFamily;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    public YmArticleFamily() {
    }

    public YmArticleFamily(final String familyId, final String familyName, final String isDeleted, final String createTime, final String updateTime, final Integer type) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
    }
}
