package cn.liaozh.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class UserSort {
    @ApiModelProperty("用户id")
    @TableId(
            value = "user_id",
            type = IdType.ASSIGN_ID
    )
    private String userId;

    @ApiModelProperty("用户查询id")
    private int id;

    @ApiModelProperty("用户昵称")
    private String userName;

    @ApiModelProperty("班级id")
    private String classId;

    @ApiModelProperty("电话号码")
    private String phoneNumber;

    @ApiModelProperty("个性签名")
    private String signature;

    @ApiModelProperty("粉丝数")
    private int fansNum;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("是否禁用 0启用 1禁用")
    @JsonIgnore
    private String isDisabled;

    @ApiModelProperty("在线状态")
    @JsonIgnore
    private String online;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("是否消息推送")
    @JsonIgnore
    private String notice;

    @ApiModelProperty("关注状态")
    private boolean fansState;

    @ApiModelProperty("互关状态")
    private boolean followState;

    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;

    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    @ApiModelProperty("排序")
    private int sort;

}
