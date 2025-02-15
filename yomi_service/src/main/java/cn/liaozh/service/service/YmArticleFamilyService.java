package cn.liaozh.service.service;

import cn.liaozh.pojo.YmArticleFamily;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

public interface YmArticleFamilyService extends MPJBaseService<YmArticleFamily> {

    List<YmArticleFamily> getArticleFamily();

    void update(YmArticleFamily family);

    List<YmArticleFamily> logicalLabel();
}
