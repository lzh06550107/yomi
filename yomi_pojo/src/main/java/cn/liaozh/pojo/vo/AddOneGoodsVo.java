package cn.liaozh.pojo.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class AddOneGoodsVo {
    private @NotEmpty(
            message = "标题不能为空"
    ) String title;
    private @NotEmpty(
            message = "内容描述不能为空"
    ) @Length(
            max = 500,
            message = "内容不能大于500字"
    ) String content;
    private @NotEmpty(
            message = "类型不能为空"
    ) String familyId;
    private String[] imageLink;
    private @NotNull(
            message = "价格不能为空"
    ) Double price;
    private String contact;

    public AddOneGoodsVo() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String[] getImageLink() {
        return this.imageLink;
    }

    public @NotNull(
            message = "价格不能为空"
    ) Double getPrice() {
        return this.price;
    }

    public String getContact() {
        return this.contact;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setFamilyId(final String familyId) {
        this.familyId = familyId;
    }

    public void setImageLink(final String[] imageLink) {
        this.imageLink = imageLink;
    }

    public void setPrice(final @NotNull(
            message = "价格不能为空"
    ) Double price) {
        this.price = price;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AddOneGoodsVo)) {
            return false;
        } else {
            AddOneGoodsVo other = (AddOneGoodsVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$price = this.getPrice();
                Object other$price = other.getPrice();
                if (this$price == null) {
                    if (other$price != null) {
                        return false;
                    }
                } else if (!this$price.equals(other$price)) {
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

                Object this$familyId = this.getFamilyId();
                Object other$familyId = other.getFamilyId();
                if (this$familyId == null) {
                    if (other$familyId != null) {
                        return false;
                    }
                } else if (!this$familyId.equals(other$familyId)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getImageLink(), other.getImageLink())) {
                    return false;
                } else {
                    Object this$contact = this.getContact();
                    Object other$contact = other.getContact();
                    if (this$contact == null) {
                        if (other$contact != null) {
                            return false;
                        }
                    } else if (!this$contact.equals(other$contact)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AddOneGoodsVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $price = this.getPrice();
        result = result * 59 + ($price == null ? 43 : $price.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getImageLink());
        Object $contact = this.getContact();
        result = result * 59 + ($contact == null ? 43 : $contact.hashCode());
        return result;
    }

    public String toString() {
        return "AddOneGoodsVo(title=" + this.getTitle() + ", content=" + this.getContent() + ", familyId=" + this.getFamilyId() + ", imageLink=" + Arrays.deepToString(this.getImageLink()) + ", price=" + this.getPrice() + ", contact=" + this.getContact() + ")";
    }
}

