package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "YmShare对象",
        description = ""
)
public class YmShare implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("转发id")
    @TableId(
            value = "share_id",
            type = IdType.ASSIGN_ID
    )
    private String shareId;
    @ApiModelProperty("转发的文章id")
    private String articleId;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("分享目标")
    private String shareTarget;

    public YmShare() {
    }

    public String getShareId() {
        return this.shareId;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getShareTarget() {
        return this.shareTarget;
    }

    public YmShare setShareId(final String shareId) {
        this.shareId = shareId;
        return this;
    }

    public YmShare setArticleId(final String articleId) {
        this.articleId = articleId;
        return this;
    }

    public YmShare setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmShare setShareTarget(final String shareTarget) {
        this.shareTarget = shareTarget;
        return this;
    }

    public String toString() {
        return "YmShare(shareId=" + this.getShareId() + ", articleId=" + this.getArticleId() + ", userId=" + this.getUserId() + ", shareTarget=" + this.getShareTarget() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmShare)) {
            return false;
        } else {
            YmShare other = (YmShare)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$shareId = this.getShareId();
                Object other$shareId = other.getShareId();
                if (this$shareId == null) {
                    if (other$shareId != null) {
                        return false;
                    }
                } else if (!this$shareId.equals(other$shareId)) {
                    return false;
                }

                Object this$articleId = this.getArticleId();
                Object other$articleId = other.getArticleId();
                if (this$articleId == null) {
                    if (other$articleId != null) {
                        return false;
                    }
                } else if (!this$articleId.equals(other$articleId)) {
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

                Object this$shareTarget = this.getShareTarget();
                Object other$shareTarget = other.getShareTarget();
                if (this$shareTarget == null) {
                    if (other$shareTarget != null) {
                        return false;
                    }
                } else if (!this$shareTarget.equals(other$shareTarget)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmShare;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $shareId = this.getShareId();
        result = result * 59 + ($shareId == null ? 43 : $shareId.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $shareTarget = this.getShareTarget();
        result = result * 59 + ($shareTarget == null ? 43 : $shareTarget.hashCode());
        return result;
    }
}
