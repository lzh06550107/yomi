package cn.liaozh.dao;

import cn.liaozh.pojo.YmIntactGoods;
import cn.liaozh.pojo.vo.CommodityVos;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YmIntactGoodsMapper extends MPJBaseMapper<YmIntactGoods> {
    List<CommodityVos> getGoods();

    List<CommodityVos> hottestCommodity();

    List<CommodityVos> highestCommodity();

    List<CommodityVos> lowestCommodity();

    List<CommodityVos> getOneGoods(@Param("id") String id);

    List<CommodityVos> getOneselfGoods(@Param("userId") String userId);

    List<CommodityVos> searchAll(@Param("strings") List<String> strings);

    boolean insertIdeaFeedback(@Param("userId") String userId, @Param("str") String str, @Param("time") Long time);

    List<CommodityVos> familyQuery(@Param("familyId") String familyId);
}
