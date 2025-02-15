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
public class CommentsVo {

    private String commentId;
    private String userId;
    private String parentId;
    private String userName;
    private String avatar;
    private String createTime;
    private String content;
    private Integer commentsNum;
    private String wasRepliedName;
    private String link;
    private Integer likeNum;
    private boolean status;
}
