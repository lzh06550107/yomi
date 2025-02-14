package cn.liaozh.pojo.vo;

import java.util.List;

public class PageVo {
    private long total;
    private List<UserInfoVo> userInfoList;

    public long getTotal() {
        return this.total;
    }

    public List<UserInfoVo> getUserInfoList() {
        return this.userInfoList;
    }

    public void setTotal(final long total) {
        this.total = total;
    }

    public void setUserInfoList(final List<UserInfoVo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageVo)) {
            return false;
        } else {
            PageVo other = (PageVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotal() != other.getTotal()) {
                return false;
            } else {
                Object this$userInfoList = this.getUserInfoList();
                Object other$userInfoList = other.getUserInfoList();
                if (this$userInfoList == null) {
                    if (other$userInfoList != null) {
                        return false;
                    }
                } else if (!this$userInfoList.equals(other$userInfoList)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $total = this.getTotal();
        result = result * 59 + (int)($total >>> 32 ^ $total);
        Object $userInfoList = this.getUserInfoList();
        result = result * 59 + ($userInfoList == null ? 43 : $userInfoList.hashCode());
        return result;
    }

    public String toString() {
        return "PageVo(total=" + this.getTotal() + ", userInfoList=" + this.getUserInfoList() + ")";
    }

    public PageVo(final long total, final List<UserInfoVo> userInfoList) {
        this.total = total;
        this.userInfoList = userInfoList;
    }

    public PageVo() {
    }
}

