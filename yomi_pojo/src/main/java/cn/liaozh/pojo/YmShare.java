package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel(
    value = "YmShare对象",
    description = ""
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmShare implements Serializable {

    @ApiModelProperty("转发id")
    @TableId(
        value = "share_id",
        type = IdType.ASSIGN_ID
    )
    private String shareId;

    @ApiModelProperty("转发的文章id")
    private String articleId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("分享目标")
    private String shareTarget;
}
