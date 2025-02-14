package cn.liaozh.pojo.vo;

import io.swagger.annotations.ApiModelProperty;

public class UserFansVo {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("被关注者id")
    private String answerUserId;

    public UserFansVo(final String userId, final String answerUserId) {
        this.userId = userId;
        this.answerUserId = answerUserId;
    }

    public UserFansVo() {
    }

    public String getUserId() {
        return this.userId;
    }

    public String getAnswerUserId() {
        return this.answerUserId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setAnswerUserId(final String answerUserId) {
        this.answerUserId = answerUserId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserFansVo)) {
            return false;
        } else {
            UserFansVo other = (UserFansVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$answerUserId = this.getAnswerUserId();
                Object other$answerUserId = other.getAnswerUserId();
                if (this$answerUserId == null) {
                    if (other$answerUserId != null) {
                        return false;
                    }
                } else if (!this$answerUserId.equals(other$answerUserId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserFansVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $answerUserId = this.getAnswerUserId();
        result = result * 59 + ($answerUserId == null ? 43 : $answerUserId.hashCode());
        return result;
    }

    public String toString() {
        return "UserFansVo(userId=" + this.getUserId() + ", answerUserId=" + this.getAnswerUserId() + ")";
    }
}
