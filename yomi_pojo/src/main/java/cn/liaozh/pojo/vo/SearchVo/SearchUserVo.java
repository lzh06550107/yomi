package cn.liaozh.pojo.vo.SearchVo;

import cn.liaozh.pojo.YmUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SearchUserVo {

    private String userName;
    private String userId;
    private String avatar;

    public SearchUserVo(YmUser user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.avatar = user.getAvatar();
    }
}
