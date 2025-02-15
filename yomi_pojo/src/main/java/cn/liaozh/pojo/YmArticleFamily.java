package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
        value = "YmArticleFamily对象",
        description = ""
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmArticleFamily implements Serializable {

    @TableId(
        value = "family_id",
        type = IdType.ASSIGN_ID
    )
    private String familyId;

    @ApiModelProperty("类别名称")
    private String familyName;

    @ApiModelProperty("是否删除 0 1")
    @TableLogic
    @JsonIgnore
    private String isDeleted;

    private String createTime;

    private String updateTime;

    @TableField(
        exist = false
    )
    private Integer type = 0;

    public YmArticleFamily(String familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.type = 1;
    }
}
