package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoginUserVo {

    @ApiModelProperty("用户id")
    @TableId(
            value = "user_id",
            type = IdType.ASSIGN_ID
    )
    private String userId;
    @JsonIgnore
    @ApiModelProperty("用户查询id")
    private int id;
    private String token;
}

