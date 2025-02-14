package cn.liaozh.service.service.service_utils;

import cn.liaozh.pojo.*;
import cn.liaozh.service.service.*;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTagUtils {
    @Autowired
    private YmIntactArticleService intactArticleService;
    @Autowired
    private YmCommentService ymCommentService;
    @Autowired
    private YmUserService ymUserService;
    @Autowired
    private YmClassService ymClassService;
    @Autowired
    private YmArticleService articleService;

    public UserTagUtils() {
    }

    public boolean isGoodUser(String userId) {
        List<YmIntactArticle> intactArticles = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIsDeleted, "0").eq(YmIntactArticle::getUserId, userId).list();
        if (intactArticles.isEmpty()) {
            return false;
        } else {
            List<String> articleIds = (List)intactArticles.stream().map(YmIntactArticle::getArticleId).collect(Collectors.toList());
            List<YmArticle> articleList = ((LambdaQueryChainWrapper)this.articleService.lambdaQuery().in(YmArticle::getArticleId, articleIds)).list();
            long likeNum = articleList.stream().mapToLong(YmArticle::getLikeNum).sum();
            long views = articleList.stream().mapToLong(YmArticle::getViewsNum).sum();
            long commentNum = articleList.stream().mapToLong(YmArticle::getCommentNum).sum();
            return likeNum > 15L && views > 100L && commentNum > 8L;
        }
    }

    public boolean isComplaintsUser(String userId) {
        Integer commentsCount = this.ymCommentService.lambdaQuery().eq(YmComment::getIsDeleted, "0").eq(YmComment::getUserId, userId).count();
        return commentsCount > 10;
    }

    public List<String> getSchoolTag(String userId) {
        List<String> list = new ArrayList();
        YmUser one = (YmUser)((LambdaQueryChainWrapper)this.ymUserService.lambdaQuery().eq(YmUser::getUserId, userId)).one();
        if (one.getClassId() != null && !one.getClassId().equals("")) {
            YmClass ymClass = (YmClass)((LambdaQueryChainWrapper)this.ymClassService.lambdaQuery().eq(YmClass::getClassId, one.getClassId())).one();
            YmClass schoolName = (YmClass)((LambdaQueryChainWrapper)this.ymClassService.lambdaQuery().eq(YmClass::getClassId, ymClass.getParentId())).one();
            list.add(ymClass.getTitle());
            list.add(schoolName.getTitle());
            return list;
        } else {
            return list;
        }
    }
}
