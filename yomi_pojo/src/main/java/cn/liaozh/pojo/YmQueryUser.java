package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class YmQueryUser implements Serializable {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("可被搜索的id")
    @TableId(
            type = IdType.AUTO
    )
    private Integer queryId;

    public YmQueryUser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public Integer getQueryId() {
        return this.queryId;
    }

    public YmQueryUser setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public YmQueryUser setQueryId(final Integer queryId) {
        this.queryId = queryId;
        return this;
    }

    public String toString() {
        return "YmQueryUser(userId=" + this.getUserId() + ", queryId=" + this.getQueryId() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmQueryUser)) {
            return false;
        } else {
            YmQueryUser other = (YmQueryUser)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$queryId = this.getQueryId();
                Object other$queryId = other.getQueryId();
                if (this$queryId == null) {
                    if (other$queryId != null) {
                        return false;
                    }
                } else if (!this$queryId.equals(other$queryId)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmQueryUser;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $queryId = this.getQueryId();
        result = result * 59 + ($queryId == null ? 43 : $queryId.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        return result;
    }
}
