package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TwoComment {

    private String commentId;
    private String content;
    private Integer commentNum;
    private Long createTime;
    private String userId;
    private String userName;
    private String avatar;
    private String parentId;
    private boolean likeStatus;
    private String type;

}

