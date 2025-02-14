package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmArticleImage;

import java.util.Objects;

public class ImageVo {
    private String articleImageId;
    private String imageLink;

    public ImageVo(YmArticleImage ymArticleImage) {
        if (!Objects.isNull(ymArticleImage)) {
            this.articleImageId = ymArticleImage.getArticleImageId();
            this.imageLink = ymArticleImage.getImageLink();
        }

    }

    public String getArticleImageId() {
        return this.articleImageId;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public void setArticleImageId(final String articleImageId) {
        this.articleImageId = articleImageId;
    }

    public void setImageLink(final String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ImageVo)) {
            return false;
        } else {
            ImageVo other = (ImageVo)o;
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ImageVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $articleImageId = this.getArticleImageId();
        result = result * 59 + ($articleImageId == null ? 43 : $articleImageId.hashCode());
        Object $imageLink = this.getImageLink();
        result = result * 59 + ($imageLink == null ? 43 : $imageLink.hashCode());
        return result;
    }

    public String toString() {
        return "ImageVo(articleImageId=" + this.getArticleImageId() + ", imageLink=" + this.getImageLink() + ")";
    }

    public ImageVo(final String articleImageId, final String imageLink) {
        this.articleImageId = articleImageId;
        this.imageLink = imageLink;
    }

    public ImageVo() {
    }
}

