package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class YmCaptcha implements Serializable {
    @TableId(
            value = "captcha_id",
            type = IdType.ASSIGN_ID
    )
    private String captchaId;

    private String email;

    private String code;

    private String isValidation;

    @TableLogic
    @JsonIgnore
    private String isDeleted;

    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;

    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    public YmCaptcha(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
