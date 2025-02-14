package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class LoginUserVo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    @TableId(
            value = "user_id",
            type = IdType.ASSIGN_ID
    )
    private String userId;
    @JsonIgnore
    @ApiModelProperty("用户查询id")
    private int id;
    private String token;

    public LoginUserVo() {
    }

    public String getUserId() {
        return this.userId;
    }

    public int getId() {
        return this.id;
    }

    public String getToken() {
        return this.token;
    }

    public LoginUserVo setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    @JsonIgnore
    public LoginUserVo setId(final int id) {
        this.id = id;
        return this;
    }

    public LoginUserVo setToken(final String token) {
        this.token = token;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LoginUserVo)) {
            return false;
        } else {
            LoginUserVo other = (LoginUserVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
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

                Object this$token = this.getToken();
                Object other$token = other.getToken();
                if (this$token == null) {
                    if (other$token != null) {
                        return false;
                    }
                } else if (!this$token.equals(other$token)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginUserVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    public String toString() {
        return "LoginUserVo(userId=" + this.getUserId() + ", id=" + this.getId() + ", token=" + this.getToken() + ")";
    }
}

