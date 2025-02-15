package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmIdeafeedback extends Model<YmIdeafeedback> {

    @TableId(
            value = "feedback_id",
            type = IdType.AUTO
    )
    private Integer feedbackId;

    private String idea;

    private String userId;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
}

