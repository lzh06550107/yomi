package cn.liaozh.service.service;

import cn.liaozh.pojo.YmUser;
import cn.liaozh.pojo.vo.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;
import java.util.Map;

public interface YmUserService extends MPJBaseService<YmUser> {

    YmUser selectByOpenId(String openId);

    YmUser selectUserById(String id);

    boolean updateFansNum(String userId, int flagNum);

    boolean updateUserInfo(YmUser user);

    Page<UserSort> getUserBatch(String userId, String content, Integer page);

    FullUserVo selectUserById(String userId, String id);

    List<String> promptUserName(String content);

    Map<String, Integer> num(String userId);

    Map<String, Object> personalInformation(String userId);

    boolean modifyUserInformation(String userId, ModifyUserInfoVo userInfoVo);

    Map<String, Object> strInfo(String userId);

    List<Map<String, Object>> schoolInfo(String userId);

    List<Map<String, Object>> department(String classId);

    boolean modifyStrInfo(String userId, StrInfoVo infoVo);

    List<UserInfoVo> activeUser(String userId);

    IPage<CommodityVos> inStock(String userId, Integer type, Integer page);

    boolean modifyMyGoods(String userId, String id, Integer type);

    IPage<CommodityVos> userInfo(String id, String judge, Integer page);

    boolean modifyGoods(String userId, UpdateGoodsVo goodsVo);

    Object getUserTag(String userId);

    Object getNews(String userId);
}
