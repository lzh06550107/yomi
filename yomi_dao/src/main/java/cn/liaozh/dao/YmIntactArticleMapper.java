package cn.liaozh.dao;

import cn.liaozh.pojo.YmIntactArticle;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YmIntactArticleMapper extends MPJBaseMapper<YmIntactArticle> {
    List<Integer> getArticle();

    YmIntactArticle getIntactArticle(String articleId);

    List<String> selectMapByArticleNum();
}
