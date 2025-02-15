package cn.liaozh.pojo;

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
import java.util.Date;
import java.util.Map;

@ApiModel("YmSign对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmSign implements Serializable {
    @TableId(
            value = "sign_id",
            type = IdType.ASSIGN_ID
    )
    @JsonIgnore
    private String signId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("签到日期")
    private Date signInDate;

    @TableField(
            exist = false
    )
    private Integer userSignCount;

    @TableField(
            exist = false
    )
    private Integer needDay;

    @TableField(
            exist = false
    )
    private int isSign;

    @TableField(
            exist = false
    )
    private YmCarouselFigure ymCarouselFigure;

    @TableField(
            exist = false
    )
    private String shopName;

    @TableField(
            exist = false
    )
    private String img;

    @TableField(
            exist = false
    )
    private Map items;

    @TableField(
            exist = false
    )
    private String IndexImg;
}
