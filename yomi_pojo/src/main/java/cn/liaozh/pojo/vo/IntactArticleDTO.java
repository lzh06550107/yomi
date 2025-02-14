package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public class IntactArticleDTO {
    private String intactArticleId;
    @TableId(
            value = "article_id",
            type = IdType.ASSIGN_ID
    )
    private String articleId;
    private @NotBlank(
            message = "标题不能为空"
    ) String title;
    private @NotBlank String content;
    private String createTime;
    private Integer commentNum;
    private Integer viewsNum;
    private Integer shareNum;
    private Integer likeNum;
    private String userId;
    private String openId;
    private String userName;
    private String classId;
    private String phoneNumber;
    private String signature;
    private Integer fansNum;
    private String sex;
    @JsonIgnore
    private String online;
    private String avatar;
    private String imageLink;
    private String familyName;
    private String privateState;
    private boolean likeStatus;
    private boolean fansState;

    public IntactArticleDTO() {
    }

    public String getIntactArticleId() {
        return this.intactArticleId;
    }

    public String getArticleId() {
        return this.articleId;
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

    public Integer getCommentNum() {
        return this.commentNum;
    }

    public Integer getViewsNum() {
        return this.viewsNum;
    }

    public Integer getShareNum() {
        return this.shareNum;
    }

    public Integer getLikeNum() {
        return this.likeNum;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getClassId() {
        return this.classId;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getSignature() {
        return this.signature;
    }

    public Integer getFansNum() {
        return this.fansNum;
    }

    public String getSex() {
        return this.sex;
    }

    public String getOnline() {
        return this.online;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getPrivateState() {
        return this.privateState;
    }

    public boolean isLikeStatus() {
        return this.likeStatus;
    }

    public boolean isFansState() {
        return this.fansState;
    }

    public void setIntactArticleId(final String intactArticleId) {
        this.intactArticleId = intactArticleId;
    }

    public void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setCommentNum(final Integer commentNum) {
        this.commentNum = commentNum;
    }

    public void setViewsNum(final Integer viewsNum) {
        this.viewsNum = viewsNum;
    }

    public void setShareNum(final Integer shareNum) {
        this.shareNum = shareNum;
    }

    public void setLikeNum(final Integer likeNum) {
        this.likeNum = likeNum;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setOpenId(final String openId) {
        this.openId = openId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setClassId(final String classId) {
        this.classId = classId;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }

    public void setFansNum(final Integer fansNum) {
        this.fansNum = fansNum;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    @JsonIgnore
    public void setOnline(final String online) {
        this.online = online;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setImageLink(final String imageLink) {
        this.imageLink = imageLink;
    }

    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public void setPrivateState(final String privateState) {
        this.privateState = privateState;
    }

    public void setLikeStatus(final boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public void setFansState(final boolean fansState) {
        this.fansState = fansState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof IntactArticleDTO)) {
            return false;
        } else {
            IntactArticleDTO other = (IntactArticleDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isLikeStatus() != other.isLikeStatus()) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
                return false;
            } else {
                Object this$commentNum = this.getCommentNum();
                Object other$commentNum = other.getCommentNum();
                if (this$commentNum == null) {
                    if (other$commentNum != null) {
                        return false;
                    }
                } else if (!this$commentNum.equals(other$commentNum)) {
                    return false;
                }

                Object this$viewsNum = this.getViewsNum();
                Object other$viewsNum = other.getViewsNum();
                if (this$viewsNum == null) {
                    if (other$viewsNum != null) {
                        return false;
                    }
                } else if (!this$viewsNum.equals(other$viewsNum)) {
                    return false;
                }

                Object this$shareNum = this.getShareNum();
                Object other$shareNum = other.getShareNum();
                if (this$shareNum == null) {
                    if (other$shareNum != null) {
                        return false;
                    }
                } else if (!this$shareNum.equals(other$shareNum)) {
                    return false;
                }

                Object this$likeNum = this.getLikeNum();
                Object other$likeNum = other.getLikeNum();
                if (this$likeNum == null) {
                    if (other$likeNum != null) {
                        return false;
                    }
                } else if (!this$likeNum.equals(other$likeNum)) {
                    return false;
                }

                Object this$fansNum = this.getFansNum();
                Object other$fansNum = other.getFansNum();
                if (this$fansNum == null) {
                    if (other$fansNum != null) {
                        return false;
                    }
                } else if (!this$fansNum.equals(other$fansNum)) {
                    return false;
                }

                Object this$intactArticleId = this.getIntactArticleId();
                Object other$intactArticleId = other.getIntactArticleId();
                if (this$intactArticleId == null) {
                    if (other$intactArticleId != null) {
                        return false;
                    }
                } else if (!this$intactArticleId.equals(other$intactArticleId)) {
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

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$openId = this.getOpenId();
                Object other$openId = other.getOpenId();
                if (this$openId == null) {
                    if (other$openId != null) {
                        return false;
                    }
                } else if (!this$openId.equals(other$openId)) {
                    return false;
                }

                Object this$userName = this.getUserName();
                Object other$userName = other.getUserName();
                if (this$userName == null) {
                    if (other$userName != null) {
                        return false;
                    }
                } else if (!this$userName.equals(other$userName)) {
                    return false;
                }

                Object this$classId = this.getClassId();
                Object other$classId = other.getClassId();
                if (this$classId == null) {
                    if (other$classId != null) {
                        return false;
                    }
                } else if (!this$classId.equals(other$classId)) {
                    return false;
                }

                Object this$phoneNumber = this.getPhoneNumber();
                Object other$phoneNumber = other.getPhoneNumber();
                if (this$phoneNumber == null) {
                    if (other$phoneNumber != null) {
                        return false;
                    }
                } else if (!this$phoneNumber.equals(other$phoneNumber)) {
                    return false;
                }

                Object this$signature = this.getSignature();
                Object other$signature = other.getSignature();
                if (this$signature == null) {
                    if (other$signature != null) {
                        return false;
                    }
                } else if (!this$signature.equals(other$signature)) {
                    return false;
                }

                Object this$sex = this.getSex();
                Object other$sex = other.getSex();
                if (this$sex == null) {
                    if (other$sex != null) {
                        return false;
                    }
                } else if (!this$sex.equals(other$sex)) {
                    return false;
                }

                Object this$online = this.getOnline();
                Object other$online = other.getOnline();
                if (this$online == null) {
                    if (other$online != null) {
                        return false;
                    }
                } else if (!this$online.equals(other$online)) {
                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
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

                Object this$familyName = this.getFamilyName();
                Object other$familyName = other.getFamilyName();
                if (this$familyName == null) {
                    if (other$familyName != null) {
                        return false;
                    }
                } else if (!this$familyName.equals(other$familyName)) {
                    return false;
                }

                Object this$privateState = this.getPrivateState();
                Object other$privateState = other.getPrivateState();
                if (this$privateState == null) {
                    if (other$privateState != null) {
                        return false;
                    }
                } else if (!this$privateState.equals(other$privateState)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IntactArticleDTO;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isLikeStatus() ? 79 : 97);
        result = result * 59 + (this.isFansState() ? 79 : 97);
        Object $commentNum = this.getCommentNum();
        result = result * 59 + ($commentNum == null ? 43 : $commentNum.hashCode());
        Object $viewsNum = this.getViewsNum();
        result = result * 59 + ($viewsNum == null ? 43 : $viewsNum.hashCode());
        Object $shareNum = this.getShareNum();
        result = result * 59 + ($shareNum == null ? 43 : $shareNum.hashCode());
        Object $likeNum = this.getLikeNum();
        result = result * 59 + ($likeNum == null ? 43 : $likeNum.hashCode());
        Object $fansNum = this.getFansNum();
        result = result * 59 + ($fansNum == null ? 43 : $fansNum.hashCode());
        Object $intactArticleId = this.getIntactArticleId();
        result = result * 59 + ($intactArticleId == null ? 43 : $intactArticleId.hashCode());
        Object $articleId = this.getArticleId();
        result = result * 59 + ($articleId == null ? 43 : $articleId.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $openId = this.getOpenId();
        result = result * 59 + ($openId == null ? 43 : $openId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $classId = this.getClassId();
        result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
        Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        Object $signature = this.getSignature();
        result = result * 59 + ($signature == null ? 43 : $signature.hashCode());
        Object $sex = this.getSex();
        result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
        Object $online = this.getOnline();
        result = result * 59 + ($online == null ? 43 : $online.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $imageLink = this.getImageLink();
        result = result * 59 + ($imageLink == null ? 43 : $imageLink.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        Object $privateState = this.getPrivateState();
        result = result * 59 + ($privateState == null ? 43 : $privateState.hashCode());
        return result;
    }

    public String toString() {
        return "IntactArticleDTO(intactArticleId=" + this.getIntactArticleId() + ", articleId=" + this.getArticleId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", createTime=" + this.getCreateTime() + ", commentNum=" + this.getCommentNum() + ", viewsNum=" + this.getViewsNum() + ", shareNum=" + this.getShareNum() + ", likeNum=" + this.getLikeNum() + ", userId=" + this.getUserId() + ", openId=" + this.getOpenId() + ", userName=" + this.getUserName() + ", classId=" + this.getClassId() + ", phoneNumber=" + this.getPhoneNumber() + ", signature=" + this.getSignature() + ", fansNum=" + this.getFansNum() + ", sex=" + this.getSex() + ", online=" + this.getOnline() + ", avatar=" + this.getAvatar() + ", imageLink=" + this.getImageLink() + ", familyName=" + this.getFamilyName() + ", privateState=" + this.getPrivateState() + ", likeStatus=" + this.isLikeStatus() + ", fansState=" + this.isFansState() + ")";
    }
}
