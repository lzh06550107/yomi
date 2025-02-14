package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmClass对象",
        description = ""
)
public class YmClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("班级id")
    @TableId(
            value = "class_id",
            type = IdType.ASSIGN_ID
    )
    private String classId;
    @ApiModelProperty("子级id")
    private String parentId;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("详细介绍")
    private String info;
    @ApiModelProperty("删除状态 0可用 1删除")
    @TableLogic
    @JsonIgnore
    private String isDeleted;
    @ApiModelProperty("创建时间")
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @ApiModelProperty("更新时间")
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
    @ApiModelProperty("删除时间")
    private String deleteTime;

    public YmClass() {
    }

    public String getClassId() {
        return this.classId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getInfo() {
        return this.info;
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

    public String getDeleteTime() {
        return this.deleteTime;
    }

    public YmClass setClassId(final String classId) {
        this.classId = classId;
        return this;
    }

    public YmClass setParentId(final String parentId) {
        this.parentId = parentId;
        return this;
    }

    public YmClass setTitle(final String title) {
        this.title = title;
        return this;
    }

    public YmClass setInfo(final String info) {
        this.info = info;
        return this;
    }

    @JsonIgnore
    public YmClass setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public YmClass setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmClass setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public YmClass setDeleteTime(final String deleteTime) {
        this.deleteTime = deleteTime;
        return this;
    }

    public String toString() {
        return "YmClass(classId=" + this.getClassId() + ", parentId=" + this.getParentId() + ", title=" + this.getTitle() + ", info=" + this.getInfo() + ", isDeleted=" + this.getIsDeleted() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", deleteTime=" + this.getDeleteTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmClass)) {
            return false;
        } else {
            YmClass other = (YmClass)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$classId = this.getClassId();
                Object other$classId = other.getClassId();
                if (this$classId == null) {
                    if (other$classId != null) {
                        return false;
                    }
                } else if (!this$classId.equals(other$classId)) {
                    return false;
                }

                Object this$parentId = this.getParentId();
                Object other$parentId = other.getParentId();
                if (this$parentId == null) {
                    if (other$parentId != null) {
                        return false;
                    }
                } else if (!this$parentId.equals(other$parentId)) {
                    return false;
                }

                Object this$title = this.getTitle();
                Object other$title = other.getTitle();
                if (this$title == null) {
                    if (other$title != null) {
                        return false;
                    }
                } else if (!this$title.equals(other$title)) {
                    return false;
                }

                Object this$info = this.getInfo();
                Object other$info = other.getInfo();
                if (this$info == null) {
                    if (other$info != null) {
                        return false;
                    }
                } else if (!this$info.equals(other$info)) {
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

                Object this$deleteTime = this.getDeleteTime();
                Object other$deleteTime = other.getDeleteTime();
                if (this$deleteTime == null) {
                    if (other$deleteTime != null) {
                        return false;
                    }
                } else if (!this$deleteTime.equals(other$deleteTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmClass;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $classId = this.getClassId();
        result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
        Object $parentId = this.getParentId();
        result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $info = this.getInfo();
        result = result * 59 + ($info == null ? 43 : $info.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $deleteTime = this.getDeleteTime();
        result = result * 59 + ($deleteTime == null ? 43 : $deleteTime.hashCode());
        return result;
    }
}

