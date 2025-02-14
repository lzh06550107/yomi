package cn.liaozh.service.controller;

import cn.liaozh.common.nonEmptyJudgment.ObjectUtils;
import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmCommodityFamily;
import cn.liaozh.pojo.vo.AddOneGoodsVo;
import cn.liaozh.pojo.vo.CommodityVos;
import cn.liaozh.service.service.YmIntactGoodsService;
import cn.liaozh.service.service.service_utils.AuthUserUtils;
import cn.liaozh.service.service.service_utils.StringUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping({"/ym_server/IntactGoods"})
@Validated
public class YmIntactGoodsController {
    @Autowired
    private YmIntactGoodsService ymIntactGoodsService;
    @Autowired
    private AuthUserUtils authUserUtils;
    @Autowired
    private StringUtils stringUtils;

    public YmIntactGoodsController() {
    }

    @GetMapping({"list"})
    public R getGoods(String userId, @RequestParam(required = false,value = "content") String content, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "sort",defaultValue = "0") String sort, @RequestParam(required = false,value = "familyId",defaultValue = "0") String familyId) {
        IPage<CommodityVos> list;
        if (ObjectUtils.isEmpty(content)) {
            list = this.ymIntactGoodsService.getGoods(familyId, sort, userId, page);
        } else {
            list = this.ymIntactGoodsService.searchAll(userId, content, sort, familyId, page);
        }

        List<CommodityVos> records = list.getRecords();

        for(CommodityVos record : records) {
            String goodsImage = record.getGoodsImage();
            if (Objects.isNull(goodsImage)) {
                record.setGoodsImage("");
            }
        }

        Map<String, Object> map = new HashMap();
        map.put("records", records);
        map.put("total", list.getTotal());
        map.put("size", list.getSize());
        map.put("pages", list.getPages());
        map.put("current", list.getCurrent());
        return R.ok().data(map);
    }

    @GetMapping
    public R getOneGoods(String userId, @PathParam("goodsId") String goodsId) {
        List<CommodityVos> list = this.ymIntactGoodsService.getOneGoods(userId, goodsId);
        return R.ok().data("list", list);
    }

    @PostMapping
    public R addOneGoods(String userId, @RequestBody @Valid AddOneGoodsVo goodsVo) {
        if (!this.authUserUtils.isAuthUser(userId)) {
            return R.error().message("未认证，请先认证再发布商品");
        } else if (!this.stringUtils.strFilter(goodsVo.getContent()) && !this.stringUtils.strFilter(goodsVo.getTitle())) {
            String s = this.ymIntactGoodsService.addOneGoods(userId, goodsVo);
            return R.ok().data("id", s);
        } else {
            return R.error().message("商品信息存在敏感词");
        }
    }

    @DeleteMapping
    public R deleteOneGoods(String userId, @RequestParam("goodsId") String id) {
        boolean isDeleted = this.ymIntactGoodsService.deleteOneGoods(userId, id);
        return isDeleted ? R.ok() : R.error();
    }

    @GetMapping({"myselfGoodsRetrieve"})
    public R myselfGoodsRetrieve(String userId, @PathParam("goodsName") String goodsName, @PathParam("page") Integer page) {
        PageHelper.startPage(page, 15);
        List<CommodityVos> list = this.ymIntactGoodsService.myselfGoods(userId, goodsName);
        PageHelper.clearPage();
        PageInfo<CommodityVos> commodityVoPageInfo = new PageInfo(list);
        return R.ok().data("list", commodityVoPageInfo);
    }

    @GetMapping({"family"})
    public R getFamily() {
        List<YmCommodityFamily> list = this.ymIntactGoodsService.getFamily();
        return R.ok().data("list", list);
    }

    @GetMapping({"getBulletinImg"})
    public R getBulletinImg() {
        return R.ok().data("img", this.ymIntactGoodsService.getBulletinImg());
    }
}
