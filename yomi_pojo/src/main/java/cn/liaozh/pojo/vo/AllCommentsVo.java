package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AllCommentsVo {

    private String commentId;

    private String parentId;

    private String name;

    private String avatar;

    private String createTime;

    private String content;

    private Integer commentsNum;

    private String wasRepliedName;

    private String link;

    private Integer likeNum;

    private boolean status;

    private List<CommentsVo> list;
}
