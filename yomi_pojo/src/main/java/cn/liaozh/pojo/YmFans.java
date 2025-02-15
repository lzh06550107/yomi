package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel(
        value = "YmFans对象",
        description = "粉丝表"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmFans implements Serializable {

    @TableId(
            value = "fans_id",
            type = IdType.ASSIGN_ID
    )
    private String fansId;

    @ApiModelProperty("被关注者id")
    private String answerUserId;

    @ApiModelProperty("关注者id")
    private String userId;

    @ApiModelProperty("关注来源")
    private String source;

    @ApiModelProperty("关注状态 0关注 1取消")
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
}

