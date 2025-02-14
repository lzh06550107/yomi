package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class YmStudent implements Serializable {
    @TableId(
            value = "stu_id",
            type = IdType.ASSIGN_ID
    )
    private String stuId;
    private String classId;
    private String className;
    private String dept;
    private String major;
    private String stuCategory;
    private String name;
    private String sex;
    private String counsellor;

    public String getStuId() {
        return this.stuId;
    }

    public String getClassId() {
        return this.classId;
    }

    public String getClassName() {
        return this.className;
    }

    public String getDept() {
        return this.dept;
    }

    public String getMajor() {
        return this.major;
    }

    public String getStuCategory() {
        return this.stuCategory;
    }

    public String getName() {
        return this.name;
    }

    public String getSex() {
        return this.sex;
    }

    public String getCounsellor() {
        return this.counsellor;
    }

    public YmStudent setStuId(final String stuId) {
        this.stuId = stuId;
        return this;
    }

    public YmStudent setClassId(final String classId) {
        this.classId = classId;
        return this;
    }

    public YmStudent setClassName(final String className) {
        this.className = className;
        return this;
    }

    public YmStudent setDept(final String dept) {
        this.dept = dept;
        return this;
    }

    public YmStudent setMajor(final String major) {
        this.major = major;
        return this;
    }

    public YmStudent setStuCategory(final String stuCategory) {
        this.stuCategory = stuCategory;
        return this;
    }

    public YmStudent setName(final String name) {
        this.name = name;
        return this;
    }

    public YmStudent setSex(final String sex) {
        this.sex = sex;
        return this;
    }

    public YmStudent setCounsellor(final String counsellor) {
        this.counsellor = counsellor;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmStudent)) {
            return false;
        } else {
            YmStudent other = (YmStudent)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$stuId = this.getStuId();
                Object other$stuId = other.getStuId();
                if (this$stuId == null) {
                    if (other$stuId != null) {
                        return false;
                    }
                } else if (!this$stuId.equals(other$stuId)) {
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

                Object this$className = this.getClassName();
                Object other$className = other.getClassName();
                if (this$className == null) {
                    if (other$className != null) {
                        return false;
                    }
                } else if (!this$className.equals(other$className)) {
                    return false;
                }

                Object this$dept = this.getDept();
                Object other$dept = other.getDept();
                if (this$dept == null) {
                    if (other$dept != null) {
                        return false;
                    }
                } else if (!this$dept.equals(other$dept)) {
                    return false;
                }

                Object this$major = this.getMajor();
                Object other$major = other.getMajor();
                if (this$major == null) {
                    if (other$major != null) {
                        return false;
                    }
                } else if (!this$major.equals(other$major)) {
                    return false;
                }

                Object this$stuCategory = this.getStuCategory();
                Object other$stuCategory = other.getStuCategory();
                if (this$stuCategory == null) {
                    if (other$stuCategory != null) {
                        return false;
                    }
                } else if (!this$stuCategory.equals(other$stuCategory)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$sex = this.getSex();
                Object other$sex = other.getSex();
                if (this$sex == null) {
                    if (other$sex != null) {
                        return false;
                    }
                } else if (!this$sex.equals(other$sex)) {
                    return false;
                }

                Object this$counsellor = this.getCounsellor();
                Object other$counsellor = other.getCounsellor();
                if (this$counsellor == null) {
                    if (other$counsellor != null) {
                        return false;
                    }
                } else if (!this$counsellor.equals(other$counsellor)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmStudent;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $stuId = this.getStuId();
        result = result * 59 + ($stuId == null ? 43 : $stuId.hashCode());
        Object $classId = this.getClassId();
        result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
        Object $className = this.getClassName();
        result = result * 59 + ($className == null ? 43 : $className.hashCode());
        Object $dept = this.getDept();
        result = result * 59 + ($dept == null ? 43 : $dept.hashCode());
        Object $major = this.getMajor();
        result = result * 59 + ($major == null ? 43 : $major.hashCode());
        Object $stuCategory = this.getStuCategory();
        result = result * 59 + ($stuCategory == null ? 43 : $stuCategory.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $sex = this.getSex();
        result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
        Object $counsellor = this.getCounsellor();
        result = result * 59 + ($counsellor == null ? 43 : $counsellor.hashCode());
        return result;
    }

    public String toString() {
        return "YmStudent(stuId=" + this.getStuId() + ", classId=" + this.getClassId() + ", className=" + this.getClassName() + ", dept=" + this.getDept() + ", major=" + this.getMajor() + ", stuCategory=" + this.getStuCategory() + ", name=" + this.getName() + ", sex=" + this.getSex() + ", counsellor=" + this.getCounsellor() + ")";
    }

    public YmStudent() {
    }

    public YmStudent(final String stuId, final String classId, final String className, final String dept, final String major, final String stuCategory, final String name, final String sex, final String counsellor) {
        this.stuId = stuId;
        this.classId = classId;
        this.className = className;
        this.dept = dept;
        this.major = major;
        this.stuCategory = stuCategory;
        this.name = name;
        this.sex = sex;
        this.counsellor = counsellor;
    }
}
