package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmArticleImage对象",
        description = ""
)
public class YmArticleImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("图片id")
    @TableId(
            value = "article_image_id",
            type = IdType.ASSIGN_ID
    )
    private String articleImageId;
    @ApiModelProperty("图片连接  用逗号分割")
    private String imageLink;
    @ApiModelProperty("创建时间")
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @ApiModelProperty("修改时间")
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
    @JsonIgnore
    @ApiModelProperty("软删除 0是未删除，1是删除")
    @TableLogic
    private String isDeleted;

    public YmArticleImage() {
    }

    public String getArticleImageId() {
        return this.articleImageId;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public YmArticleImage setArticleImageId(final String articleImageId) {
        this.articleImageId = articleImageId;
        return this;
    }

    public YmArticleImage setImageLink(final String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public YmArticleImage setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmArticleImage setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @JsonIgnore
    public YmArticleImage setIsDeleted(final String isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public String toString() {
        return "YmArticleImage(articleImageId=" + this.getArticleImageId() + ", imageLink=" + this.getImageLink() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", isDeleted=" + this.getIsDeleted() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmArticleImage)) {
            return false;
        } else {
            YmArticleImage other = (YmArticleImage)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$articleImageId = this.getArticleImageId();
                Object other$articleImageId = other.getArticleImageId();
                if (this$articleImageId == null) {
                    if (other$articleImageId != null) {
                        return false;
                    }
                } else if (!this$articleImageId.equals(other$articleImageId)) {
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

                Object this$isDeleted = this.getIsDeleted();
                Object other$isDeleted = other.getIsDeleted();
                if (this$isDeleted == null) {
                    if (other$isDeleted != null) {
                        return false;
                    }
                } else if (!this$isDeleted.equals(other$isDeleted)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmArticleImage;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $articleImageId = this.getArticleImageId();
        result = result * 59 + ($articleImageId == null ? 43 : $articleImageId.hashCode());
        Object $imageLink = this.getImageLink();
        result = result * 59 + ($imageLink == null ? 43 : $imageLink.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $isDeleted = this.getIsDeleted();
        result = result * 59 + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        return result;
    }
}
