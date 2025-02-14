package cn.liaozh.pojo.vo;

public class FullUserVo {
    private String userId;
    private String userName;
    private String avatar;
    private String sex;
    private String signature;
    private Integer readNum;
    private Integer fansNum;
    private boolean fansState;
    private boolean followState;

    public FullUserVo() {
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getSex() {
        return this.sex;
    }

    public String getSignature() {
        return this.signature;
    }

    public Integer getReadNum() {
        return this.readNum;
    }

    public Integer getFansNum() {
        return this.fansNum;
    }

    public boolean isFansState() {
        return this.fansState;
    }

    public boolean isFollowState() {
        return this.followState;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }

    public void setReadNum(final Integer readNum) {
        this.readNum = readNum;
    }

    public void setFansNum(final Integer fansNum) {
        this.fansNum = fansNum;
    }

    public void setFansState(final boolean fansState) {
        this.fansState = fansState;
    }

    public void setFollowState(final boolean followState) {
        this.followState = followState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FullUserVo)) {
            return false;
        } else {
            FullUserVo other = (FullUserVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isFansState() != other.isFansState()) {
                return false;
            } else if (this.isFollowState() != other.isFollowState()) {
                return false;
            } else {
                Object this$readNum = this.getReadNum();
                Object other$readNum = other.getReadNum();
                if (this$readNum == null) {
                    if (other$readNum != null) {
                        return false;
                    }
                } else if (!this$readNum.equals(other$readNum)) {
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

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
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

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
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

                Object this$signature = this.getSignature();
                Object other$signature = other.getSignature();
                if (this$signature == null) {
                    if (other$signature != null) {
                        return false;
                    }
                } else if (!this$signature.equals(other$signature)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FullUserVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isFansState() ? 79 : 97);
        result = result * 59 + (this.isFollowState() ? 79 : 97);
        Object $readNum = this.getReadNum();
        result = result * 59 + ($readNum == null ? 43 : $readNum.hashCode());
        Object $fansNum = this.getFansNum();
        result = result * 59 + ($fansNum == null ? 43 : $fansNum.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $sex = this.getSex();
        result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
        Object $signature = this.getSignature();
        result = result * 59 + ($signature == null ? 43 : $signature.hashCode());
        return result;
    }

    public String toString() {
        return "FullUserVo(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", avatar=" + this.getAvatar() + ", sex=" + this.getSex() + ", signature=" + this.getSignature() + ", readNum=" + this.getReadNum() + ", fansNum=" + this.getFansNum() + ", fansState=" + this.isFansState() + ", followState=" + this.isFollowState() + ")";
    }
}

