package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmStrAttestMapper;
import cn.liaozh.pojo.YmStrAttest;
import cn.liaozh.service.service.YmStrAttestService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class YmStrAttestServiceImpl extends MPJBaseServiceImpl<YmStrAttestMapper, YmStrAttest> implements YmStrAttestService {
    public YmStrAttestServiceImpl() {
    }
}
