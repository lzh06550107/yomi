package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmArticleFamily;

public class FamilyVo {
    private String familyId;
    private String familyName;

    public FamilyVo(YmArticleFamily ymArticleFamily) {
        this.familyId = ymArticleFamily.getFamilyId();
        this.familyName = ymArticleFamily.getFamilyName();
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyId(final String familyId) {
        this.familyId = familyId;
    }

    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FamilyVo)) {
            return false;
        } else {
            FamilyVo other = (FamilyVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$familyId = this.getFamilyId();
                Object other$familyId = other.getFamilyId();
                if (this$familyId == null) {
                    if (other$familyId != null) {
                        return false;
                    }
                } else if (!this$familyId.equals(other$familyId)) {
                    return false;
                }

                Object this$familyName = this.getFamilyName();
                Object other$familyName = other.getFamilyName();
                if (this$familyName == null) {
                    if (other$familyName != null) {
                        return false;
                    }
                } else if (!this$familyName.equals(other$familyName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FamilyVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $familyId = this.getFamilyId();
        result = result * 59 + ($familyId == null ? 43 : $familyId.hashCode());
        Object $familyName = this.getFamilyName();
        result = result * 59 + ($familyName == null ? 43 : $familyName.hashCode());
        return result;
    }

    public String toString() {
        return "FamilyVo(familyId=" + this.getFamilyId() + ", familyName=" + this.getFamilyName() + ")";
    }

    public FamilyVo(final String familyId, final String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
    }

    public FamilyVo() {
    }
}
