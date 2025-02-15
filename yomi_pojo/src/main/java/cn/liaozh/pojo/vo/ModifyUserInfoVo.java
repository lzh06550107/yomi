package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ModifyUserInfoVo {

    private @URL String avatar;
    private String userName;
    private String signature;
    private @Pattern(
            regexp = "^[0|12]",
            message = "性别格式不正确"
    ) String sex;
    private String phoneNumber;
    private String wxNum;
}
