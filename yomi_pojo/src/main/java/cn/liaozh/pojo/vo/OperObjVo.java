package cn.liaozh.pojo.vo;

public class OperObjVo {
    private String commonId;
    private String type;

    public OperObjVo() {
    }

    public String getCommonId() {
        return this.commonId;
    }

    public String getType() {
        return this.type;
    }

    public void setCommonId(final String commonId) {
        this.commonId = commonId;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OperObjVo)) {
            return false;
        } else {
            OperObjVo other = (OperObjVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$commonId = this.getCommonId();
                Object other$commonId = other.getCommonId();
                if (this$commonId == null) {
                    if (other$commonId != null) {
                        return false;
                    }
                } else if (!this$commonId.equals(other$commonId)) {
                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OperObjVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $commonId = this.getCommonId();
        result = result * 59 + ($commonId == null ? 43 : $commonId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "OperObjVo(commonId=" + this.getCommonId() + ", type=" + this.getType() + ")";
    }
}
