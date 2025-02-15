package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmConfig {
    @TableId(
        value = "config_id",
        type = IdType.ASSIGN_ID
    )
    private String configId;

    @JsonIgnore
    @TableField("config_key")
    private String configKey;

    @TableField("config_value")
    private String configValue;

    @TableField("image_link")
    private String imageLink;

    @TableField("type")
    private String type;

    @TableField("sort")
    private Integer sort;

    @TableLogic
    @TableField("is_deleted")
    @JsonIgnore
    private String isDeleted;

    @TableField(
        fill = FieldFill.INSERT,
        value = "create_time"
    )
    @JsonIgnore
    private String createTime;

    @JsonIgnore
    @TableField(
        fill = FieldFill.INSERT_UPDATE,
        value = "update_time"
    )
    private String updateTime;
}
