package cn.liaozh.pojo.vo;

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
public class UserFansVo {
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("被关注者id")
    private String answerUserId;

}
