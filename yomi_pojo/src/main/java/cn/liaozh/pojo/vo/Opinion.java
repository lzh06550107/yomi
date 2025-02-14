package cn.liaozh.pojo.vo;

public class Opinion {
    private String str;

    public Opinion() {
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(final String str) {
        this.str = str;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Opinion)) {
            return false;
        } else {
            Opinion other = (Opinion)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$str = this.getStr();
                Object other$str = other.getStr();
                if (this$str == null) {
                    if (other$str != null) {
                        return false;
                    }
                } else if (!this$str.equals(other$str)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Opinion;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $str = this.getStr();
        result = result * 59 + ($str == null ? 43 : $str.hashCode());
        return result;
    }

    public String toString() {
        return "Opinion(str=" + this.getStr() + ")";
    }
}

