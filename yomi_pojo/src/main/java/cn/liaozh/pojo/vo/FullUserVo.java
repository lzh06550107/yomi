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
public class FullUserVo {

    private String userId;
    private String userName;
    private String avatar;
    private String sex;
    private String signature;
    private Integer readNum;
    private Integer fansNum;
    private boolean fansState;
    private boolean followState;
}

