package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class YmConfig {
    @TableId(
            value = "config_id",
            type = IdType.ASSIGN_ID
    )
    private String configId;
    @JsonIgnore
    @TableField("config_key")
    private String configKey;
    @TableField("config_value")
    private String configValue;
    @TableField("image_link")
    private String imageLink;
    @TableField("type")
    private String type;
    @TableField("sort")
    private Integer sort;
    @TableLogic
    @TableField("is_deleted")
    @JsonIgnore
    private String isDeleted;
    @TableField(
            fill = FieldFill.INSERT,
            value = "create_time"
    )
    @JsonIgnore
    private String createTime;
    @JsonIgnore
    @TableField(
            fill = FieldFill.INSERT_UPDATE,
            value = "update_time"
    )
    private String updateTime;

    public String getConfigId() {
        return this.configId;
    }

    public String getConfigKey() {
        return this.configKey;
    }

    public String getConfigValue() {
        return this.configValue;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public String getType() {
        return this.type;
    }

    public Integer getSort() {
        return this.sort;
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

    public YmConfig setConfigId(final String configId) {
        this.configId = configId;
        return this;
    }

    @JsonIgnore
    public YmConfig setConfigKey(final String configKey) {
        this.configKey = configKey;
        return this;
    }

    public YmConfig setConfigValue(final String configValue) {
        this.configValue = configValue;
        return this;
    }

    public YmConfig setImageLink(final String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public YmConfig setType(final String type) {
        this.type = type;
        return this;
    }

    public YmConfig setSort(final Integer sort) {
        this.sort = sort;
        return this;
    }

    @JsonIgnore
    public YmConfig setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @JsonIgnore
    public YmConfig setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    @JsonIgnore
    public YmConfig setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmConfig)) {
            return false;
        } else {
            YmConfig other = (YmConfig)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$sort = this.getSort();
                Object other$sort = other.getSort();
                if (this$sort == null) {
                    if (other$sort != null) {
                        return false;
                    }
                } else if (!this$sort.equals(other$sort)) {
                    return false;
                }

                Object this$configId = this.getConfigId();
                Object other$configId = other.getConfigId();
                if (this$configId == null) {
                    if (other$configId != null) {
                        return false;
                    }
                } else if (!this$configId.equals(other$configId)) {
                    return false;
                }

                Object this$configKey = this.getConfigKey();
                Object other$configKey = other.getConfigKey();
                if (this$configKey == null) {
                    if (other$configKey != null) {
                        return false;
                    }
                } else if (!this$configKey.equals(other$configKey)) {
                    return false;
                }

                Object this$configValue = this.getConfigValue();
                Object other$configValue = other.getConfigValue();
                if (this$configValue == null) {
                    if (other$configValue != null) {
                        return false;
                    }
                } else if (!this$configValue.equals(other$configValue)) {
                    return false;
                }

                Object this$imageLink = this.getImageLink();
                Object other$imageLink = other.getImageLink();
                if (this$imageLink == null) {
                    if (other$imageLink != null) {
                        return false;
                    }
                } else if (!this$imageLink.equals(other$imageLink)) {
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
        return other instanceof YmConfig;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $sort = this.getSort();
        result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
        Object $configId = this.getConfigId();
        result = result * 59 + ($configId == null ? 43 : $configId.hashCode());
        Object $configKey = this.getConfigKey();
        result = result * 59 + ($configKey == null ? 43 : $configKey.hashCode());
        Object $configValue = this.getConfigValue();
        result = result * 59 + ($configValue == null ? 43 : $configValue.hashCode());
        Object $imageLink = this.getImageLink();
        result = result * 59 + ($imageLink == null ? 43 : $imageLink.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    public String toString() {
        return "YmConfig(configId=" + this.getConfigId() + ", configKey=" + this.getConfigKey() + ", configValue=" + this.getConfigValue() + ", imageLink=" + this.getImageLink() + ", type=" + this.getType() + ", sort=" + this.getSort() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }

    public YmConfig(final String configId, final String configKey, final String configValue, final String imageLink, final String type, final Integer sort, final String isDeleted, final String createTime, final String updateTime) {
        this.configId = configId;
        this.configKey = configKey;
        this.configValue = configValue;
        this.imageLink = imageLink;
        this.type = type;
        this.sort = sort;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public YmConfig() {
    }
}
