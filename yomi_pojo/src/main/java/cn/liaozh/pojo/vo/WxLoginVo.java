package cn.liaozh.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel("登录vo对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxLoginVo implements Serializable {

    @ApiModelProperty("微信登录code")
    private String code;
}

