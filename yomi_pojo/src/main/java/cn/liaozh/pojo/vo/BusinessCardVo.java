package cn.liaozh.pojo.vo;

public class BusinessCardVo {
    public BusinessCardVo() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusinessCardVo)) {
            return false;
        } else {
            BusinessCardVo other = (BusinessCardVo)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BusinessCardVo;
    }

    public int hashCode() {
        int result = 1;
        return 1;
    }

    public String toString() {
        return "BusinessCardVo()";
    }
}
