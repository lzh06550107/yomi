package cn.liaozh.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("登录vo对象")
public class WxLoginVo implements Serializable {
    @ApiModelProperty("微信登录code")
    private String code;

    public WxLoginVo() {
    }

    public String getCode() {
        return this.code;
    }

    public WxLoginVo setCode(final String code) {
        this.code = code;
        return this;
    }

    public String toString() {
        return "WxLoginVo(code=" + this.getCode() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof WxLoginVo)) {
            return false;
        } else {
            WxLoginVo other = (WxLoginVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WxLoginVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        return result;
    }
}

