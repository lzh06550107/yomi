package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class YmStrAttest {
    @TableId(
            value = "str_attest_id",
            type = IdType.ASSIGN_ID
    )
    private String strAttestId;
    private String strName;
    private int strNumber;
    private String userId;
    private Integer authState;

    public YmStrAttest() {
    }

    public String getStrAttestId() {
        return this.strAttestId;
    }

    public String getStrName() {
        return this.strName;
    }

    public int getStrNumber() {
        return this.strNumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public Integer getAuthState() {
        return this.authState;
    }

    public void setStrAttestId(final String strAttestId) {
        this.strAttestId = strAttestId;
    }

    public void setStrName(final String strName) {
        this.strName = strName;
    }

    public void setStrNumber(final int strNumber) {
        this.strNumber = strNumber;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setAuthState(final Integer authState) {
        this.authState = authState;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmStrAttest)) {
            return false;
        } else {
            YmStrAttest other = (YmStrAttest)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStrNumber() != other.getStrNumber()) {
                return false;
            } else {
                Object this$authState = this.getAuthState();
                Object other$authState = other.getAuthState();
                if (this$authState == null) {
                    if (other$authState != null) {
                        return false;
                    }
                } else if (!this$authState.equals(other$authState)) {
                    return false;
                }

                Object this$strAttestId = this.getStrAttestId();
                Object other$strAttestId = other.getStrAttestId();
                if (this$strAttestId == null) {
                    if (other$strAttestId != null) {
                        return false;
                    }
                } else if (!this$strAttestId.equals(other$strAttestId)) {
                    return false;
                }

                Object this$strName = this.getStrName();
                Object other$strName = other.getStrName();
                if (this$strName == null) {
                    if (other$strName != null) {
                        return false;
                    }
                } else if (!this$strName.equals(other$strName)) {
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
        return other instanceof YmStrAttest;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getStrNumber();
        Object $authState = this.getAuthState();
        result = result * 59 + ($authState == null ? 43 : $authState.hashCode());
        Object $strAttestId = this.getStrAttestId();
        result = result * 59 + ($strAttestId == null ? 43 : $strAttestId.hashCode());
        Object $strName = this.getStrName();
        result = result * 59 + ($strName == null ? 43 : $strName.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        return result;
    }

    public String toString() {
        return "YmStrAttest(strAttestId=" + this.getStrAttestId() + ", strName=" + this.getStrName() + ", strNumber=" + this.getStrNumber() + ", userId=" + this.getUserId() + ", authState=" + this.getAuthState() + ")";
    }
}
