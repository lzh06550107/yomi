package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OneComment {

    private String commentId;
    private String content;
    private Integer commentNum;
    private String userId;
    private String userName;
    private String type;
    private Long createTime;
    private boolean likeStatus;
    private String avatar;
    private List<TwoComment> children = new ArrayList();

}
