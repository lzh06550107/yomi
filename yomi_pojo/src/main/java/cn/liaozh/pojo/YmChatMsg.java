package cn.liaozh.pojo;

import cn.liaozh.pojo.vo.OperObjVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
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
public class YmChatMsg implements Serializable {

    @TableId(
        value = "id",
        type = IdType.ASSIGN_ID
    )
    private String id;

    private String sendUserId;

    private String acceptUserId;

    private String msg;

    private String image;

    private String signFlag;

    @ApiModelProperty("创建时间")
    @TableField(
        fill = FieldFill.INSERT
    )
    private String createTime;

    @ApiModelProperty("修改时间")
    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;

    private String type;

    @TableField(
        exist = false
    )
    private UserInfoVo sendUser;

    @TableField(
        exist = false
    )
    private OperObjVo operObj;

    @TableField(
        exist = false
    )
    private String tips;

    @TableField(
        exist = false
    )
    private String content;
}
