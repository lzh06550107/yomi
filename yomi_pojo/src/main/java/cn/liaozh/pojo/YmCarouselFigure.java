package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(
        value = "YmCarouselFigure对象",
        description = ""
)
public class YmCarouselFigure extends Model<YmCarouselFigure> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("文章id")
    @TableId(
            value = "id",
            type = IdType.ASSIGN_ID
    )
    private String id;
    @ApiModelProperty("删除状态 0 1")
    private String isDelete;
    @ApiModelProperty("标题")
    private @NotBlank(
            message = "标题不能为空"
    ) String title;
    @ApiModelProperty("正文")
    private @NotBlank String content;
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
    @ApiModelProperty("二手轮播图url")
    private String img;
    @ApiModelProperty("作者")
    private String authName;
    private String type;
    private String url;

    public YmCarouselFigure() {
    }

    public String getId() {
        return this.id;
    }

    public String getIsDelete() {
        return this.isDelete;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getImg() {
        return this.img;
    }

    public String getAuthName() {
        return this.authName;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public YmCarouselFigure setId(final String id) {
        this.id = id;
        return this;
    }

    public YmCarouselFigure setIsDelete(final String isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public YmCarouselFigure setTitle(final String title) {
        this.title = title;
        return this;
    }

    public YmCarouselFigure setContent(final String content) {
        this.content = content;
        return this;
    }

    public YmCarouselFigure setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmCarouselFigure setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public YmCarouselFigure setImg(final String img) {
        this.img = img;
        return this;
    }

    public YmCarouselFigure setAuthName(final String authName) {
        this.authName = authName;
        return this;
    }

    public YmCarouselFigure setType(final String type) {
        this.type = type;
        return this;
    }

    public YmCarouselFigure setUrl(final String url) {
        this.url = url;
        return this;
    }

    public String toString() {
        return "YmCarouselFigure(id=" + this.getId() + ", isDelete=" + this.getIsDelete() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", img=" + this.getImg() + ", authName=" + this.getAuthName() + ", type=" + this.getType() + ", url=" + this.getUrl() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmCarouselFigure)) {
            return false;
        } else {
            YmCarouselFigure other = (YmCarouselFigure)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$isDelete = this.getIsDelete();
                Object other$isDelete = other.getIsDelete();
                if (this$isDelete == null) {
                    if (other$isDelete != null) {
                        return false;
                    }
                } else if (!this$isDelete.equals(other$isDelete)) {
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

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
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

                Object this$img = this.getImg();
                Object other$img = other.getImg();
                if (this$img == null) {
                    if (other$img != null) {
                        return false;
                    }
                } else if (!this$img.equals(other$img)) {
                    return false;
                }

                Object this$authName = this.getAuthName();
                Object other$authName = other.getAuthName();
                if (this$authName == null) {
                    if (other$authName != null) {
                        return false;
                    }
                } else if (!this$authName.equals(other$authName)) {
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

                Object this$url = this.getUrl();
                Object other$url = other.getUrl();
                if (this$url == null) {
                    if (other$url != null) {
                        return false;
                    }
                } else if (!this$url.equals(other$url)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmCarouselFigure;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $isDelete = this.getIsDelete();
        result = result * 59 + ($isDelete == null ? 43 : $isDelete.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $img = this.getImg();
        result = result * 59 + ($img == null ? 43 : $img.hashCode());
        Object $authName = this.getAuthName();
        result = result * 59 + ($authName == null ? 43 : $authName.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $url = this.getUrl();
        result = result * 59 + ($url == null ? 43 : $url.hashCode());
        return result;
    }
}

