package cn.liaozh.service.service;

import cn.liaozh.pojo.YmIntactGoods;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.liaozh.pojo.YmCommodityFamily;
import cn.liaozh.pojo.YmIntactGoods;
import cn.liaozh.pojo.vo.AddOneGoodsVo;
import cn.liaozh.pojo.vo.CommodityVos;
import cn.liaozh.pojo.vo.Opinion;

public interface YmIntactGoodsService extends MPJBaseService<YmIntactGoods> {

    IPage<CommodityVos> getGoods(String familyId, String sort, String userId, Integer page);

    List<CommodityVos> getOneGoods(String userId, String id);

    String addOneGoods(String userId, AddOneGoodsVo goodsVo);

    boolean deleteOneGoods(String userId, String id);

    IPage<CommodityVos> searchAll(String userId, String content, String sort, String familyId, Integer page);

    List<CommodityVos> myselfGoods(String userId, String goodsName);

    boolean feedback(String userId, Opinion str);

    List<YmCommodityFamily> getFamily();

    Object getBulletinImg();
}
