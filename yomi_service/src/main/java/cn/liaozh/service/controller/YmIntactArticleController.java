package cn.liaozh.service.controller;

import cn.liaozh.common.nonEmptyJudgment.ObjectUtils;
import cn.liaozh.common.result.R;
import cn.liaozh.dao.YmArticleMapper;
import cn.liaozh.pojo.YmArticle;
import cn.liaozh.pojo.vo.IntactArticleDTO;
import cn.liaozh.pojo.vo.IntactArticleVos;
import cn.liaozh.pojo.vo.SaveArticleVo;
import cn.liaozh.pojo.vo.SearchVo.SearchArticleVo;
import cn.liaozh.service.service.YmArticleService;
import cn.liaozh.service.service.YmIntactArticleService;
import cn.liaozh.service.service.service_utils.AuthUserUtils;
import cn.liaozh.service.service.service_utils.StringUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/ym_server/IntactArticle"})
public class YmIntactArticleController {
    @Autowired
    private YmIntactArticleService intactArticleService;
    @Autowired
    private YmArticleMapper ymArticleMapper;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private AuthUserUtils authUserUtils;
    @Autowired
    private YmArticleService articleService;

    public YmIntactArticleController() {
    }

    @GetMapping({"allSearch"})
    public R allSearch(String userId, @RequestParam String content, @RequestParam Integer page) {
        Page<SearchArticleVo> list = this.intactArticleService.allSearchMysql(userId, content, page);
        return R.ok().data("list", list);
    }

    @GetMapping({"user-article"})
    public R oneselfAllSearch(String userId, @RequestParam("content") String content, @RequestParam("page") Integer page) {
        return ObjectUtils.isEmpty(content) ? R.ok().data("list", this.intactArticleService.myArticle(userId, page)) : R.ok().data("list", this.intactArticleService.oneselfAllSearch(userId, content, page));
    }

    @GetMapping({"{familyId}"})
    public R gatRedisArticleFamily(String userId, @PathVariable String familyId, @PathParam("page") Integer page) {
        return R.ok().data("list", this.intactArticleService.getCategoryArticles(userId, familyId, page));
    }

    @PostMapping
    public R addRedisArticle(String userId, @RequestBody @Validated SaveArticleVo vo) {
        List<YmArticle> list = this.articleService.lambdaQuery().eq(YmArticle::getTitle, vo.getTitle()).eq(YmArticle::getContent, vo.getContent()).list();
        if (!list.isEmpty()) {
            throw new YmException(ExecutionResult.COMMIT_CODE_701);
        } else if (!this.authUserUtils.isAuthUser(userId)) {
            return R.error().message("未认证，请先认证再发布文章");
        } else if (!this.stringUtils.strFilter(vo.getContent()) && !this.stringUtils.strFilter(vo.getTitle())) {
            String intactArticleId = this.intactArticleService.saveRedisArticle(userId, vo);
            IntactArticleVos article = this.intactArticleService.getOneRedisArticle(userId, intactArticleId);
            return R.ok().data("detail", article);
        } else {
            throw new YmException(ExecutionResult.ARTICLE_CODE_405);
        }
    }

    @DeleteMapping({"{intactArticle}"})
    public R deleteArticle(String userId, @PathVariable String intactArticle) {
        Boolean isRemove = this.intactArticleService.removeArticle(userId, intactArticle);
        return isRemove ? R.ok() : R.error();
    }

    @GetMapping({"details/{articleId}"})
    public R getOneRedisArticle(String userId, @PathVariable String articleId) {
        IntactArticleVos oneRedisArticle = this.intactArticleService.getOneRedisArticle(userId, articleId);
        return R.ok().data("detail", oneRedisArticle);
    }

    @GetMapping({"/contentPrompt"})
    public R searchContentTips(@RequestParam("content") String content) {
        List<IntactArticleDTO> articleDTOList = this.ymArticleMapper.getContentTips(content);
        articleDTOList = this.intactArticleService.articlePopularityRanking(articleDTOList);
        HashSet<String> strings = (HashSet)articleDTOList.stream().map(IntactArticleDTO::getTitle).collect(Collectors.toCollection(HashSet::new));
        return R.ok().data("list", strings);
    }

    @GetMapping({"/hottestRecommendation"})
    public R hottestRecommendation() {
        return R.ok().data("list", this.intactArticleService.hottestRecommendation());
    }
}

