package cn.liaozh.service.service;

import cn.liaozh.pojo.YmFans;
import cn.liaozh.pojo.vo.PageVo;
import cn.liaozh.pojo.vo.UserFansVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseService;

public interface YmFansService extends MPJBaseService<YmFans> {

    boolean insertFans(YmFans fans);

    PageVo selectFansList(String userId, int pageNum, String column);

    Page<UserInfoVo> selectFansList(String userId, String judge, Integer page);

    boolean deleteAnswerFans(YmFans fans);

    boolean selectAnswerFans(UserFansVo userFansVo);

    int removeSoftDeleted();

    Page<UserInfoVo> fuzzyQueryFans(String judge, String userId, String content, Integer page);

    boolean getOneFans(String userId, String id);

    boolean addFollow(String userId, String id);

    String attentionUser(String userId, String id);
}
