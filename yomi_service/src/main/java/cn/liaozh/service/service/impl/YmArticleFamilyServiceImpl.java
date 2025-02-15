package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmArticleFamilyMapper;
import cn.liaozh.pojo.YmArticleFamily;
import cn.liaozh.service.service.YmArticleFamilyService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YmArticleFamilyServiceImpl extends MPJBaseServiceImpl<YmArticleFamilyMapper, YmArticleFamily> implements YmArticleFamilyService {

    public List<YmArticleFamily> getArticleFamily() {
        return this.baseMapper.selectList(null);
    }

    public void update(YmArticleFamily family) {
    }

    public List<YmArticleFamily> logicalLabel() {
        List<YmArticleFamily> ymArticleFamilies = new ArrayList<>();
        ymArticleFamilies.add(new YmArticleFamily("0", "综合推荐"));
        ymArticleFamilies.add(new YmArticleFamily("1", "我的关注"));
        ymArticleFamilies.addAll(this.baseMapper.selectList(null));
        return ymArticleFamilies;
    }
}
