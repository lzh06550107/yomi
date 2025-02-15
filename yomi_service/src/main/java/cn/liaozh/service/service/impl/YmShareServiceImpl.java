package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmShareMapper;
import cn.liaozh.pojo.YmArticle;
import cn.liaozh.pojo.YmIntactArticle;
import cn.liaozh.pojo.YmShare;
import cn.liaozh.service.service.YmArticleService;
import cn.liaozh.service.service.YmIntactArticleService;
import cn.liaozh.service.service.YmShareService;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class YmShareServiceImpl extends MPJBaseServiceImpl<YmShareMapper, YmShare> implements YmShareService {
    @Autowired
    private YmIntactArticleService intactArticleService;
    @Autowired
    private YmArticleService ymArticleService;

    @Transactional
    public boolean insertShare(YmShare share) {
        boolean save = this.save(share);
        String articleId = share.getArticleId();
        YmIntactArticle one = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, articleId).one();
        boolean update = this.ymArticleService.lambdaUpdate().eq(YmArticle::getArticleId, one.getArticleId()).setSql("share_num = share_num + 1").update();
        return save && update;
    }
}
