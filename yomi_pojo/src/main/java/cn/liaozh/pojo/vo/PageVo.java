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
public class PageVo {

    private long total;

    private List<UserInfoVo> userInfoList;

    public long getTotal() {
        return this.total;
    }

    public List<UserInfoVo> getUserInfoList() {
        return this.userInfoList;
    }

}

