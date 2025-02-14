package cn.liaozh.pojo.vo.SearchVo;

import cn.liaozh.pojo.YmUser;

public class SearchUserVo {
    private String userName;
    private String userId;
    private String avatar;

    public SearchUserVo(YmUser user) {
        this.userName = user.getUserName();
        this.userId = user.getUserId();
        this.avatar = user.getAvatar();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public SearchUserVo setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    public SearchUserVo setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public SearchUserVo setAvatar(final String avatar) {
        this.avatar = avatar;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SearchUserVo)) {
            return false;
        } else {
            SearchUserVo other = (SearchUserVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$userName = this.getUserName();
                Object other$userName = other.getUserName();
                if (this$userName == null) {
                    if (other$userName != null) {
                        return false;
                    }
                } else if (!this$userName.equals(other$userName)) {
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

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SearchUserVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        return result;
    }

    public String toString() {
        return "SearchUserVo(userName=" + this.getUserName() + ", userId=" + this.getUserId() + ", avatar=" + this.getAvatar() + ")";
    }

    public SearchUserVo(final String userName, final String userId, final String avatar) {
        this.userName = userName;
        this.userId = userId;
        this.avatar = avatar;
    }

    public SearchUserVo() {
    }
}
