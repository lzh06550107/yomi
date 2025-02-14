package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmCommodityFamilyMapper;
import cn.liaozh.pojo.YmCommodityFamily;
import cn.liaozh.service.service.YmCommodityFamilyService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class YmCommodityFamilyServiceImpl extends MPJBaseServiceImpl<YmCommodityFamilyMapper, YmCommodityFamily> implements YmCommodityFamilyService {
    public YmCommodityFamilyServiceImpl() {
    }
}
