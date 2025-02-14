package cn.liaozh.service.service;

import cn.liaozh.pojo.YmShare;
import com.github.yulichang.base.MPJBaseService;

public interface YmShareService extends MPJBaseService<YmShare> {
    boolean insertShare(YmShare share);
}
