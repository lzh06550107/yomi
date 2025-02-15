package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class YmQueryUser implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("可被搜索的id")
    @TableId(
        type = IdType.AUTO
    )
    private Integer queryId;

    public YmQueryUser(String userId) {
        this.userId = userId;
    }
}
