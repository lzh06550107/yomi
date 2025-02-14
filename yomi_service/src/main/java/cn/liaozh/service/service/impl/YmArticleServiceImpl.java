package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmArticleMapper;
import cn.liaozh.pojo.YmArticle;
import cn.liaozh.service.service.YmArticleService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class YmArticleServiceImpl extends MPJBaseServiceImpl<YmArticleMapper, YmArticle> implements YmArticleService {
    public YmArticleServiceImpl() {
    }
}
