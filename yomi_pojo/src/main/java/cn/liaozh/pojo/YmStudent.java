package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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
}
