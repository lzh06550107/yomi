package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

public class YmIdeafeedback extends Model<YmIdeafeedback> {
    private static final long serialVersionUID = 1L;
    @TableId(
            value = "feedback_id",
            type = IdType.AUTO
    )
    private Integer feedbackId;
    private String idea;
    private String userId;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;

    public YmIdeafeedback() {
    }

    public Integer getFeedbackId() {
        return this.feedbackId;
    }

    public String getIdea() {
        return this.idea;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setFeedbackId(final Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setIdea(final String idea) {
        this.idea = idea;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        return "YmIdeafeedback(feedbackId=" + this.getFeedbackId() + ", idea=" + this.getIdea() + ", userId=" + this.getUserId() + ", createTime=" + this.getCreateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmIdeafeedback)) {
            return false;
        } else {
            YmIdeafeedback other = (YmIdeafeedback)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$feedbackId = this.getFeedbackId();
                Object other$feedbackId = other.getFeedbackId();
                if (this$feedbackId == null) {
                    if (other$feedbackId != null) {
                        return false;
                    }
                } else if (!this$feedbackId.equals(other$feedbackId)) {
                    return false;
                }

                Object this$idea = this.getIdea();
                Object other$idea = other.getIdea();
                if (this$idea == null) {
                    if (other$idea != null) {
                        return false;
                    }
                } else if (!this$idea.equals(other$idea)) {
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

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmIdeafeedback;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $feedbackId = this.getFeedbackId();
        result = result * 59 + ($feedbackId == null ? 43 : $feedbackId.hashCode());
        Object $idea = this.getIdea();
        result = result * 59 + ($idea == null ? 43 : $idea.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }
}

