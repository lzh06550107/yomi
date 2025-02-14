package cn.liaozh.dao;

import cn.liaozh.pojo.YmArticle;
import cn.liaozh.pojo.vo.IntactArticleDTO;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YmArticleMapper extends MPJBaseMapper<YmArticle> {
    List<YmArticle> getAllSearch(String str, Integer page);

    Integer getArticleCount(String str);

    List<IntactArticleDTO> getContentTips(String content);
}
