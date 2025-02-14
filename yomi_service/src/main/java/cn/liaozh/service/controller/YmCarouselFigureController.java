package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmCarouselFigure;
import cn.liaozh.service.service.YmCarouselFigureService;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/ym_server/carousel-figure"})
public class YmCarouselFigureController {
    @Autowired
    private YmCarouselFigureService ymCarouselFigureService;

    public YmCarouselFigureController() {
    }

    @GetMapping
    public R getCarouselFigure(String userId) {
        List<YmCarouselFigure> list = this.ymCarouselFigureService.lambdaQuery().eq(YmCarouselFigure::getIsDelete, "0").select(YmCarouselFigure::getId, YmCarouselFigure::getImg, YmCarouselFigure::getType, YmCarouselFigure::getUrl).list();
        return R.ok().data("list", list);
    }

    @GetMapping({"/{id}"})
    public R getCarouselFigureInfo(String userId, @PathVariable String id) {
        List<YmCarouselFigure> list = this.ymCarouselFigureService.lambdaQuery().eq(YmCarouselFigure::getIsDelete, "0").eq(YmCarouselFigure::getId, id).select(YmCarouselFigure::getId, YmCarouselFigure::getTitle, YmCarouselFigure::getContent, YmCarouselFigure::getAuthName, YmCarouselFigure::getCreateTime, YmCarouselFigure::getImg).list();
        return R.ok().data("figure", list);
    }

    @PostMapping({"/{type}"})
    public R uploadCarouselFigure(String userId, @PathVariable String type, @RequestBody YmCarouselFigure ymCarouselFigure) {
        if (type.equals("1")) {
            ymCarouselFigure.setIsDelete("1");
        } else if (type.equals("0")) {
            ymCarouselFigure.setIsDelete("0");
        }

        boolean flag = this.ymCarouselFigureService.saveOrUpdate(ymCarouselFigure);
        return flag ? R.ok() : R.error();
    }
}

