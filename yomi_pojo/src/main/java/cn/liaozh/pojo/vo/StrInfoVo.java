package cn.liaozh.pojo.vo;

public class StrInfoVo {
    private String strName;
    private Integer strNumber;
    private String classId;

    public StrInfoVo() {
    }

    public String getStrName() {
        return this.strName;
    }

    public Integer getStrNumber() {
        return this.strNumber;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setStrName(final String strName) {
        this.strName = strName;
    }

    public void setStrNumber(final Integer strNumber) {
        this.strNumber = strNumber;
    }

    public void setClassId(final String classId) {
        this.classId = classId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StrInfoVo)) {
            return false;
        } else {
            StrInfoVo other = (StrInfoVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$strNumber = this.getStrNumber();
                Object other$strNumber = other.getStrNumber();
                if (this$strNumber == null) {
                    if (other$strNumber != null) {
                        return false;
                    }
                } else if (!this$strNumber.equals(other$strNumber)) {
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

                Object this$classId = this.getClassId();
                Object other$classId = other.getClassId();
                if (this$classId == null) {
                    if (other$classId != null) {
                        return false;
                    }
                } else if (!this$classId.equals(other$classId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StrInfoVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $strNumber = this.getStrNumber();
        result = result * 59 + ($strNumber == null ? 43 : $strNumber.hashCode());
        Object $strName = this.getStrName();
        result = result * 59 + ($strName == null ? 43 : $strName.hashCode());
        Object $classId = this.getClassId();
        result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
        return result;
    }

    public String toString() {
        return "StrInfoVo(strName=" + this.getStrName() + ", strNumber=" + this.getStrNumber() + ", classId=" + this.getClassId() + ")";
    }
}
