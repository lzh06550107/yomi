package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel("YmUser对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmUser implements Serializable {

    @ApiModelProperty("用户id")
    @TableId(
        value = "user_id",
        type = IdType.ASSIGN_ID
    )
    private String userId;

    @JsonIgnore
    @ApiModelProperty("微信openid")
    private String openId;

    @ApiModelProperty("用户昵称")
    private String userName;

    @ApiModelProperty("班级id")
    private String classId;

    @ApiModelProperty("电话号码")
    private String phoneNumber;

    @ApiModelProperty("个性签名")
    private String signature;

    @ApiModelProperty("粉丝数")
    private Integer fansNum;

    @ApiModelProperty("性别")
    private String sex;

    private String wxNum;

    private String qqNum;

    @JsonIgnore
    @ApiModelProperty("是否禁用 0启用 1禁用")
    private String isDisabled;

    @ApiModelProperty("删除状态 0可用 1删除  删除后相关信息不可见")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

    @JsonIgnore
    @ApiModelProperty("在线状态")
    private String online;

    @ApiModelProperty("头像")
    private String avatar;

    @JsonIgnore
    @ApiModelProperty("消息推送")
    private String notice;

    @TableField(
        fill = FieldFill.INSERT
    )
    private String createTime;

    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    @JsonIgnore
    private String deleteTime;

    private String email;

    @JsonIgnore
    private String password;
}
