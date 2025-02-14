package cn.liaozh.service.controller;

import cn.liaozh.common.result.R;
import cn.liaozh.service.service.YmArticleFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ym_server/article-classify"})
public class YmArticleFamilyController {
    @Autowired
    YmArticleFamilyService familyService;

    public YmArticleFamilyController() {
    }

    @GetMapping({"topic-list"})
    public R getArticleFamily() {
        return R.ok().data("topicList", this.familyService.getArticleFamily());
    }

    @GetMapping({"label-list"})
    public R logicalLabel() {
        return R.ok().data("labelList", this.familyService.logicalLabel());
    }
}
