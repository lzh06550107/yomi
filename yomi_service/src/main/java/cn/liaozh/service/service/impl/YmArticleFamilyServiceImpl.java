package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmArticleFamilyMapper;
import cn.liaozh.pojo.YmArticleFamily;
import cn.liaozh.service.service.YmArticleFamilyService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class YmArticleFamilyServiceImpl extends MPJBaseServiceImpl<YmArticleFamilyMapper, YmArticleFamily> implements YmArticleFamilyService {
    public YmArticleFamilyServiceImpl() {
    }

    public List<YmArticleFamily> getArticleFamily() {
        return ((YmArticleFamilyMapper)this.baseMapper).selectList((Wrapper)null);
    }

    public void update(YmArticleFamily family) {
    }

    public List<YmArticleFamily> logicalLabel() {
        List<YmArticleFamily> ymArticleFamilies = new ArrayList();
        ymArticleFamilies.add(new YmArticleFamily("0", "综合推荐"));
        ymArticleFamilies.add(new YmArticleFamily("1", "我的关注"));
        ymArticleFamilies.addAll(((YmArticleFamilyMapper)this.baseMapper).selectList((Wrapper)null));
        return ymArticleFamilies;
    }
}
