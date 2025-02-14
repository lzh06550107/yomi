package cn.liaozh.service.service;

import cn.liaozh.pojo.YmIntactArticle;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.liaozh.pojo.YmIntactArticle;
import cn.liaozh.pojo.vo.HospotArticleTitle;
import cn.liaozh.pojo.vo.IntactArticleDTO;
import cn.liaozh.pojo.vo.IntactArticleVos;
import cn.liaozh.pojo.vo.SaveArticleVo;
import cn.liaozh.pojo.vo.SearchVo.SearchArticleVo;

public interface YmIntactArticleService extends MPJBaseService<YmIntactArticle> {

    Page<IntactArticleVos> allSearch(String userId, String str, Integer page);

    String saveRedisArticle(String userId, SaveArticleVo vo);

    Boolean removeArticle(String userId, String id);

    IntactArticleVos getOneRedisArticle(String userId, String id);

    Page<IntactArticleVos> myArticle(String userId, Integer page);

    Page<IntactArticleVos> getCategoryArticles(String userId, String category, Integer page);

    List<String> searchContentTips(String content);

    List<HospotArticleTitle> hottestRecommendation();

    Page<IntactArticleVos> oneselfAllSearch(String userId, String str, Integer page);

    Object searchMyGoods(String userId, String content, String type);

    Page<SearchArticleVo> allSearchMysql(String userId, String str, Integer page);

    List<String> getMapByArticleNum();

    List<IntactArticleDTO> articlePopularityRanking(List<IntactArticleDTO> dtos);
}
