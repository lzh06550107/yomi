package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class YmComments implements Serializable {
    @TableId(
        value = "comment_id",
        type = IdType.ASSIGN_ID
    )
    private String commentId;

    private String targetId;

    private String userId;

    private String content;

    private String parentId;

    private Integer likeNum;

    private String link;

    @TableLogic
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
