package cn.liaozh.service.service.impl;

import cn.liaozh.common.oss.UploadUtils;
import cn.liaozh.dao.*;
import cn.liaozh.pojo.*;
import cn.liaozh.pojo.vo.*;
import cn.liaozh.pojo.vo.SearchVo.SearchArticleVo;
import cn.liaozh.pojo.vo.SearchVo.SearchUserVo;
import cn.liaozh.service.service.*;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.interfaces.MPJBaseJoin;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.github.yulichang.wrapper.MPJLambdaWrapper;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class YmIntactArticleServiceImpl extends MPJBaseServiceImpl<YmIntactArticleMapper, YmIntactArticle> implements YmIntactArticleService {
    @Autowired
    private YmIntactArticleService intactArticleService;
    @Autowired
    private YmArticleService articleService;
    @Autowired
    private YmUserService userService;
    @Autowired
    private YmArticleImageService articleImageService;
    @Autowired
    private YmArticleLikeService articleLikeService;
    @Autowired
    private YmArticleFamilyService articleFamilyService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Resource
    private YmFansService fansService;
    @Autowired
    private EsServiceImpl esService;
    @Autowired
    private YmIntactArticleMapper intactArticleMapper;
    @Autowired
    private YmIntactGoodsMapper intactGoodsMapper;
    @Autowired
    private YmCommentService commentService;
    @Autowired
    private YmArticleMapper ymArticleMapper;
    @Autowired
    private YmUserMapper ymUserMapper;
    @Autowired
    private YmArticleImageMapper ymArticleImageMapper;
    @Autowired
    private YmArticleFamilyMapper ymArticleFamilyMapper;
    @Autowired
    private YmFansMapper ymFansMapper;

    public YmIntactArticleServiceImpl() {
    }

    private List<IntactArticleVo> getIntactArticleVos(List<YmIntactArticle> list) {
        List<YmUser> userList = this.userService.list((Wrapper) null);
        List<YmArticle> articleList = this.articleService.list((Wrapper) null);
        List<YmArticleFamily> familyList = this.articleFamilyService.list((Wrapper) null);
        List<YmArticleImage> imageList = this.articleImageService.list((Wrapper) null);
        List<IntactArticleVo> articleVos = new ArrayList();
        list.forEach((temp) -> {
            EsArticlePo esArticlePo = new EsArticlePo();
            IntactArticleVo intactArticleVo = new IntactArticleVo();
            userList.forEach((userTemp) -> {
                UserVo userVo = new UserVo();
                if (temp.getUserId().equals(userTemp.getUserId())) {
                    BeanUtils.copyProperties(userTemp, userVo);
                    intactArticleVo.setUser(userVo);
                }

            });
            articleList.forEach((articleTemp) -> {
                ArticleVo articleVo = new ArticleVo();
                if (temp.getArticleId().equals(articleTemp.getArticleId())) {
                    BeanUtils.copyProperties(articleTemp, articleVo);
                    intactArticleVo.setArticle(articleVo);
                    esArticlePo.setTitle(articleTemp.getTitle());
                    esArticlePo.setContent(articleTemp.getContent());
                }

            });
            familyList.forEach((familyTemp) -> {
                FamilyVo familyVo = new FamilyVo();
                if (temp.getFamilyId().equals(familyTemp.getFamilyId())) {
                    BeanUtils.copyProperties(familyTemp, familyVo);
                    intactArticleVo.setFamily(familyVo);
                }

            });
            imageList.forEach((imageTemp) -> {
                ImageVo imageVo = new ImageVo();
                if (temp.getArticleImageId().equals(imageTemp.getArticleImageId())) {
                    BeanUtils.copyProperties(imageTemp, imageVo);
                    intactArticleVo.setImage(imageVo);
                }

            });
            intactArticleVo.setIntactArticleId(temp.getIntactArticleId());
            articleVos.add(intactArticleVo);
        });
        return articleVos;
    }

    public void addRedisArticle(String intactArticleId) {
        String allArticlesJSON = (String) this.redisTemplate.opsForValue().get("allArticlesJSON");
        List<IntactArticleVo> articleVos = JSON.parseArray(allArticlesJSON, IntactArticleVo.class);
        YmIntactArticle byId = (YmIntactArticle) this.getById(intactArticleId);
        IntactArticleVo oneData = this.mysqlSelectOneArticle(byId);
        articleVos.add(oneData);
        String s = JSON.toJSONString(articleVos);
        this.redisTemplate.opsForValue().set("allArticlesJSON", s, 7L, TimeUnit.DAYS);
    }

    public Page<IntactArticleVos> allSearch(String userId, String str, Integer page) {
        List<Object> inquiry = this.esService.inquiry("articles", str);
        if (inquiry == null || inquiry.isEmpty()) {
            return null;
        }

        String s = JSON.toJSONString(inquiry);
        List<EsArticlePo> esArticlePos = JSON.parseArray(s, EsArticlePo.class);
        List<String> IntactArticleIds = esArticlePos.stream().map(EsArticlePo::getId).collect(Collectors.toList());
        if (IntactArticleIds.isEmpty()) {
            return null;
        }

        MPJLambdaWrapper<YmIntactArticle> wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                .select(YmIntactArticle::getIntactArticleId)
                .selectAll(YmUser.class)
                .selectAll(YmArticleFamily.class)
                .selectAll(YmArticleImage.class)
                .selectAll(YmArticle.class)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                .eq(YmIntactArticle::getIsDeleted, "0")
                .eq(YmIntactArticle::getPrivateState, "0")
                .in(YmIntactArticle::getIntactArticleId, IntactArticleIds)
                .orderByDesc(YmArticle::getCreateTime);


        Page<IntactArticleDTO> entities = (Page) this.intactArticleMapper.selectJoinPage(new Page<>((long) page, 10L), IntactArticleDTO.class, wrapper);
        List<String> intactArticleIdList = entities.getRecords().stream().map(IntactArticleDTO::getIntactArticleId).collect(Collectors.toList());
        List<YmArticleLike> list = this.articleLikeService.lambdaQuery().in(intactArticleIdList.size() > 0, YmArticleLike::getArticleId, intactArticleIdList).eq(YmArticleLike::getUserId, userId).list();
        Page<IntactArticleVos> intactArticleVosPage = new Page();
        HashMap<String, Object> ifLike = new HashMap();
        list.forEach((temp) -> ifLike.put(temp.getArticleId(), "0"));
        List<IntactArticleVos> collect = entities.getRecords().stream().map((temp) -> {
            IntactArticleVos articleVos = new IntactArticleVos("", new ArticleVo(), new UserVo(), new ImageVo(), new FamilyVo(), false, false, "0", false);
            BeanUtils.copyProperties(temp, articleVos.getArticle());
            BeanUtils.copyProperties(temp, articleVos.getFamily());
            BeanUtils.copyProperties(temp, articleVos.getUser());
            BeanUtils.copyProperties(temp, articleVos.getImage());
            BeanUtils.copyProperties(temp, articleVos);
            articleVos.setLikeStatus(ifLike.containsKey(temp.getIntactArticleId()));
            return articleVos;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(entities, intactArticleVosPage);
        intactArticleVosPage.setRecords(collect);
        return intactArticleVosPage;

    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public String saveRedisArticle(String userId, SaveArticleVo vo) {
        YmArticle article = new YmArticle();
        article.setContent(vo.getContent());
        article.setTitle(vo.getTitle());
        this.articleService.save(article);
        YmArticleImage image = new YmArticleImage();
        String[] imageLink = vo.getImageLink();
        StringBuilder link = new StringBuilder();

        for (int i = 0; i < imageLink.length; ++i) {
            if (imageLink.length - 1 == i) {
                link.append(imageLink[i]);
            } else {
                link.append(imageLink[i]).append(";");
            }
        }

        image.setImageLink(link.toString());
        this.articleImageService.save(image);
        YmIntactArticle intactArticle = new YmIntactArticle();
        intactArticle.setUserId(userId);
        intactArticle.setArticleId(article.getArticleId());
        intactArticle.setFamilyId(vo.getFamilyId());
        intactArticle.setArticleImageId(image.getArticleImageId());
        this.intactArticleService.save(intactArticle);
        return intactArticle.getIntactArticleId();
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Boolean removeArticle(String userId, String intactArticleId) {
        LambdaQueryWrapper<YmIntactArticle> wrapper = new LambdaQueryWrapper();
        wrapper.eq(YmIntactArticle::getIntactArticleId, intactArticleId);
        wrapper.eq(YmIntactArticle::getUserId, userId);
        String articleImageId = this.intactArticleService.getById(intactArticleId).getArticleImageId();
        String imageLink = this.articleImageService.getById(articleImageId).getImageLink();
        if (!Objects.isNull(imageLink) || !imageLink.isEmpty()) {
            boolean deleteImage = UploadUtils.deleteImage(imageLink);
            this.log.debug("deleteImage >>> " + deleteImage);
        }

        boolean isRemoveImage = this.articleImageService.removeById(articleImageId);
        boolean remove = this.intactArticleService.remove(wrapper);
        if (isRemoveImage && remove) {
            return true;
        } else {
            throw new YmException(ExecutionResult.DATA_CODE_303);
        }
    }

    public IntactArticleVos getOneRedisArticle(String userId, String id) {

        MPJLambdaWrapper<YmIntactArticle> wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                .select(YmIntactArticle::getIntactArticleId) // 保留一个getIntactArticleId，如果需要
                .select(YmUser::getUserName, YmUser::getUserId, YmUser::getSex, YmUser::getClassId, YmUser::getAvatar, YmUser::getPhoneNumber, YmUser::getSignature, YmUser::getFansNum)
                .select(YmArticleFamily::getFamilyId, YmArticleFamily::getFamilyName)
                .select(YmArticleImage::getImageLink)
                .select(YmArticle::getTitle, YmArticle::getContent, YmArticle::getCreateTime, YmArticle::getLikeNum, YmArticle::getCommentNum, YmArticle::getViewsNum, YmArticle::getShareNum, YmArticle::getArticleId)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                .eq(YmIntactArticle::getIsDeleted, "0")
                .eq(YmIntactArticle::getIntactArticleId, id);

        IntactArticleDTO intactArticleDTO = this.selectJoinOne(IntactArticleDTO.class, wrapper);
        YmFans fansStatus = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, intactArticleDTO.getUserId()).eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0").one();
        intactArticleDTO.setFansState(fansStatus != null);
        YmIntactArticle ymIntactArticle = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, id).eq(YmIntactArticle::getIsDeleted, "0").one();
        String articleId = ymIntactArticle.getArticleId();
        YmArticleLike ymArticleLike = this.articleLikeService.lambdaQuery().eq(YmArticleLike::getArticleId, articleId).eq(YmArticleLike::getUserId, userId).one();
        if (ymArticleLike == null) {
            intactArticleDTO.setLikeStatus(false);
        } else {
            intactArticleDTO.setLikeStatus(ymArticleLike.getLikeState().equals("0"));
        }

        IntactArticleVos articleVos = new IntactArticleVos();
        ArticleVo articleVo = new ArticleVo();
        UserVo userVo = new UserVo();
        ImageVo imageVo = new ImageVo();
        FamilyVo familyVo = new FamilyVo();
        BeanUtils.copyProperties(intactArticleDTO, articleVos);
        BeanUtils.copyProperties(intactArticleDTO, articleVo);
        BeanUtils.copyProperties(intactArticleDTO, userVo);
        BeanUtils.copyProperties(intactArticleDTO, imageVo);
        BeanUtils.copyProperties(intactArticleDTO, familyVo);
        Integer likeNumber = this.articleLikeService.lambdaQuery().eq(YmArticleLike::getLikeState, "0").eq(YmArticleLike::getArticleId, id).count();
        articleVo.setLikeNum(likeNumber);
        articleVos.setArticle(articleVo);
        articleVos.setImage(imageVo);
        articleVos.setFamily(familyVo);
        articleVos.setIntactArticleId(intactArticleDTO.getIntactArticleId());
        articleVos.setUser(userVo);
        articleVos.getArticle().setViewsNum(intactArticleDTO.getViewsNum() + 1);
        this.articleService.lambdaUpdate().setSql("views_num=views_num+1").eq(YmArticle::getArticleId, intactArticleDTO.getArticleId()).update();
        YmArticle one1 = this.articleService.lambdaQuery().eq(YmArticle::getArticleId, intactArticleDTO.getArticleId()).one();
        articleVos.getArticle().setViewsNum(one1.getViewsNum());
        articleVos.getArticle().setLikeNum(one1.getLikeNum());
        YmFans one = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, articleVos.getUser().getUserId()).eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0").one();
        articleVos.setFansState(one != null);
        YmFans two = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getUserId, articleVos.getUser().getUserId()).eq(YmFans::getIsDeleted, "0").one();
        articleVos.setFollowState(!Objects.isNull(two));
        return articleVos;
    }

    public Page<IntactArticleVos> myArticle(String userId, Integer page) {

        MPJLambdaWrapper<YmIntactArticle> wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                .select(YmIntactArticle::getIntactArticleId, YmIntactArticle::getPrivateState)
                .select(YmUser::getUserName, YmUser::getUserId, YmUser::getSex, YmUser::getClassId, YmUser::getAvatar, YmUser::getPhoneNumber, YmUser::getSignature, YmUser::getFansNum)
                .select(YmArticleFamily::getFamilyId, YmArticleFamily::getFamilyName)
                .select(YmArticleImage::getImageLink)
                .select(YmArticle::getArticleId, YmArticle::getTitle, YmArticle::getContent, YmArticle::getCreateTime, YmArticle::getLikeNum, YmArticle::getCommentNum, YmArticle::getViewsNum, YmArticle::getShareNum)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                .eq(YmIntactArticle::getIsDeleted, "0")
                .eq(YmIntactArticle::getUserId, userId)
                .orderBy(true, false, YmArticle::getCreateTime); // true 表示升序，false 表示降序。这里是先升后降，需要确认业务逻辑

        Page<Object> objectPage = new Page((long) page, 10L);
        Page<IntactArticleDTO> entities = (Page) this.intactArticleMapper.selectJoinPage(objectPage, IntactArticleDTO.class, wrapper);
        Page<IntactArticleVos> intactArticleVosPage = new Page();
        List<String> ids = this.articleLikeService.lambdaQuery().eq(YmArticleLike::getUserId, userId).eq(YmArticleLike::getLikeState, "0").list().stream().map(YmArticleLike::getArticleId).collect(Collectors.toList());
        List<IntactArticleVos> collect = entities.getRecords().stream().map((temp) -> {
            IntactArticleVos articleVos = new IntactArticleVos("", new ArticleVo(), new UserVo(), new ImageVo(), new FamilyVo(), false, false, "0", false);
            BeanUtils.copyProperties(temp, articleVos.getArticle());
            BeanUtils.copyProperties(temp, articleVos.getFamily());
            BeanUtils.copyProperties(temp, articleVos.getUser());
            BeanUtils.copyProperties(temp, articleVos.getImage());
            BeanUtils.copyProperties(temp, articleVos);
            articleVos.setLikeStatus(ids.contains(temp.getArticleId()));
            return articleVos;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(entities, intactArticleVosPage);
        intactArticleVosPage.setRecords(collect);
        return intactArticleVosPage;
    }

    public IntactArticleVo mysqlSelectOneArticle(YmIntactArticle intactArticle) {
        YmArticle article = this.articleService.getById(intactArticle.getArticleId());
        YmArticleImage image = this.articleImageService.getById(intactArticle.getArticleImageId());
        YmUser user = this.userService.getById(intactArticle.getUserId());
        YmArticleFamily family = this.articleFamilyService.getById(intactArticle.getFamilyId());
        IntactArticleVo intactArticleVo = new IntactArticleVo();
        ArticleVo articleVo = new ArticleVo();
        ImageVo imageVo = new ImageVo();
        UserVo userVo = new UserVo();
        FamilyVo familyVo = new FamilyVo();
        BeanUtils.copyProperties(article, articleVo);
        BeanUtils.copyProperties(image, imageVo);
        BeanUtils.copyProperties(user, userVo);
        BeanUtils.copyProperties(family, familyVo);
        intactArticleVo.setArticle(articleVo);
        intactArticleVo.setImage(imageVo);
        intactArticleVo.setUser(userVo);
        intactArticleVo.setFamily(familyVo);
        return intactArticleVo;
    }

    public Page<IntactArticleVos> getCategoryArticles(String userId, String category, Integer page) {
        MPJLambdaWrapper<YmIntactArticle> wrapper;
        switch (category) {
            case "0":

                wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                        .select(YmIntactArticle::getIntactArticleId)
                        .select(YmUser::getUserName, YmUser::getUserId, YmUser::getSex, YmUser::getClassId, YmUser::getAvatar, YmUser::getPhoneNumber, YmUser::getSignature, YmUser::getFansNum)
                        .select(YmArticleFamily::getFamilyId, YmArticleFamily::getFamilyName)
                        .select(YmArticleImage::getImageLink)
                        .select(YmArticle::getArticleId, YmArticle::getTitle, YmArticle::getContent, YmArticle::getCreateTime, YmArticle::getLikeNum, YmArticle::getCommentNum, YmArticle::getViewsNum, YmArticle::getShareNum)
                        .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                        .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                        .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                        .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                        .eq(YmIntactArticle::getPrivateState, "0")
                        .eq(YmIntactArticle::getIsDeleted, "0")
                        .orderByAsc(YmArticle::getSpecial) // 先按 special 升序
                        .orderByDesc(YmArticle::getCreateTime); // 再按 createTime 降序
                break;
            case "1":
                List<YmFans> list = this.fansService.lambdaQuery().eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0").list();
                List<String> collect = list.stream().map(YmFans::getAnswerUserId).collect(Collectors.toList());
                if (collect.size() == 0) {
                    return new Page();
                }

                wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                        .select(YmIntactArticle::getIntactArticleId)
                        .select(YmUser::getUserName, YmUser::getUserId, YmUser::getSex, YmUser::getClassId, YmUser::getAvatar, YmUser::getPhoneNumber, YmUser::getSignature, YmUser::getFansNum)
                        .select(YmArticleFamily::getFamilyId, YmArticleFamily::getFamilyName)
                        .select(YmArticleImage::getImageLink)
                        .select(YmArticle::getArticleId, YmArticle::getTitle, YmArticle::getContent, YmArticle::getCreateTime, YmArticle::getLikeNum, YmArticle::getCommentNum, YmArticle::getViewsNum, YmArticle::getShareNum)
                        .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                        .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                        .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                        .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                        .eq(YmIntactArticle::getPrivateState, "0")
                        .eq(YmIntactArticle::getIsDeleted, "0")
                        .in(YmIntactArticle::getUserId, collect) // 处理 in 子句
                        .orderByAsc(YmArticle::getSpecial)
                        .orderByDesc(YmArticle::getCreateTime);

                break;
            default:

                wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                        .select(YmIntactArticle::getIntactArticleId)
                        .select(YmUser::getUserName, YmUser::getUserId, YmUser::getSex, YmUser::getClassId, YmUser::getAvatar, YmUser::getPhoneNumber, YmUser::getSignature, YmUser::getFansNum)
                        .select(YmArticleFamily::getFamilyId, YmArticleFamily::getFamilyName)
                        .select(YmArticleImage::getImageLink)
                        .select(YmArticle::getArticleId, YmArticle::getTitle, YmArticle::getContent, YmArticle::getCreateTime, YmArticle::getLikeNum, YmArticle::getCommentNum, YmArticle::getViewsNum, YmArticle::getShareNum)
                        .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                        .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                        .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                        .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                        .eq(YmIntactArticle::getPrivateState, "0")
                        .eq(YmIntactArticle::getIsDeleted, "0")
                        .eq(YmArticleFamily::getFamilyId, category) // 增加 category 条件
                        .orderByAsc(YmArticle::getSpecial)
                        .orderByDesc(YmArticle::getCreateTime);
        }

        Page<Object> objectPage = new Page((long) page, 10L);
        Page<IntactArticleDTO> entities = (Page) this.intactArticleMapper.selectJoinPage(objectPage, IntactArticleDTO.class, wrapper);
        Page<IntactArticleVos> intactArticleVosPage = new Page();
        List<String> intactArticleIdList = entities.getRecords().stream().map(IntactArticleDTO::getIntactArticleId).collect(Collectors.toList());
        if (intactArticleIdList.size() == 0) {
            return new Page();
        } else {
            List<IntactArticleVos> collect = entities.getRecords().stream().map((temp) -> {
                IntactArticleVos articleVos = new IntactArticleVos("", new ArticleVo(), new UserVo(), new ImageVo(), new FamilyVo(), false, false, "0", false);
                BeanUtils.copyProperties(temp, articleVos.getArticle());
                BeanUtils.copyProperties(temp, articleVos.getFamily());
                BeanUtils.copyProperties(temp, articleVos.getUser());
                BeanUtils.copyProperties(temp, articleVos.getImage());
                BeanUtils.copyProperties(temp, articleVos);
                YmIntactArticle ymIntactArticle = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, temp.getIntactArticleId()).eq(YmIntactArticle::getIsDeleted, "0").one();
                String articleId = ymIntactArticle.getArticleId();
                YmArticleLike one = this.articleLikeService.lambdaQuery().eq(YmArticleLike::getArticleId, articleId).eq(YmArticleLike::getUserId, userId).one();
                if (one == null) {
                    articleVos.setLikeStatus(false);
                } else {
                    articleVos.setLikeStatus(one.getLikeState().equals("0"));
                }

                return articleVos;
            }).collect(Collectors.toList());
            BeanUtils.copyProperties(entities, intactArticleVosPage);
            intactArticleVosPage.setRecords(collect);
            return intactArticleVosPage;
        }
    }

    public List<String> searchContentTips(String content) {
        List<Object> inquiry = this.esService.inquiry("articles", content);
        String s = JSON.toJSONString(inquiry);
        List<EsArticlePo> esArticlePos = JSON.parseArray(s, EsArticlePo.class);
        List<String> list = new ArrayList();
        esArticlePos.forEach((temp) -> {
            Pattern c = Pattern.compile("[" + content + "]");
            Matcher mc = c.matcher(temp.getTitle());
            Matcher mcc = c.matcher(temp.getContent());
            Integer count = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIntactArticleId, temp.getId()).eq(YmIntactArticle::getIsDeleted, "0").eq(YmIntactArticle::getPrivateState, "0").count();
            if (count > 0) {
                if (mc.find()) {
                    list.add(temp.getTitle());
                }

                if (mcc.find()) {
                    list.add(temp.getContent());
                }
            }

        });
        if (list.size() == 0) {
            List<YmIntactArticle> ymIntactArticles = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getIsDeleted, "0").eq(YmIntactArticle::getPrivateState, "0").list();
            if (ymIntactArticles.size() == 0) {
                return null;
            }

            List<YmArticle> ymArticles = this.articleService.lambdaQuery().in(YmArticle::getArticleId, ymIntactArticles.stream().map(YmIntactArticle::getArticleId).collect(Collectors.toList())).like(YmArticle::getTitle, content).or().like(YmArticle::getContent, content).list();
            ymArticles.forEach((r) -> {
                if (r.getTitle().contains(content)) {
                    list.add(r.getTitle());
                } else {
                    list.add(r.getContent());
                }

            });
        }

        return list;
    }

    public List<HospotArticleTitle> hottestRecommendation() {

        MPJLambdaWrapper<YmIntactArticle> wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                .select(YmIntactArticle::getIntactArticleId)
                .selectAll(YmUser.class)
                .selectAll(YmArticleFamily.class)
                .selectAll(YmArticle.class)
                .selectAll(YmArticleImage.class)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                .eq(YmIntactArticle::getIsDeleted, "0")
                .eq(YmIntactArticle::getPrivateState, "0");

        List<IntactArticleDTO> intactArticleDTOList = this.selectJoinList(IntactArticleDTO.class, wrapper);
        List<IntactArticleDTO> intactArticleDTOList1 = this.articlePopularityRanking(intactArticleDTOList);
        List<HospotArticleTitle> collect = intactArticleDTOList1.stream().map((temp) -> {
            HospotArticleTitle hospotArticleTitle = new HospotArticleTitle();
            hospotArticleTitle.setTitle(temp.getTitle());
            hospotArticleTitle.setArticleId(temp.getIntactArticleId());
            return hospotArticleTitle;
        }).collect(Collectors.toList());
        return collect.size() > 10 ? collect.subList(0, 10) : collect;
    }

    public Page<IntactArticleVos> oneselfAllSearch(String userId, String str, Integer page) {

        MPJLambdaWrapper<YmIntactArticle> wrapper = new MPJLambdaWrapper<YmIntactArticle>()
                .select(YmIntactArticle::getIntactArticleId)
                .selectAll(YmUser.class)
                .selectAll(YmArticleFamily.class)
                .selectAll(YmArticleImage.class)
                .selectAll(YmArticle.class)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactArticle::getUserId)
                .leftJoin(YmArticleFamily.class, YmArticleFamily::getFamilyId, YmIntactArticle::getFamilyId)
                .leftJoin(YmArticleImage.class, YmArticleImage::getArticleImageId, YmIntactArticle::getArticleImageId)
                .leftJoin(YmArticle.class, YmArticle::getArticleId, YmIntactArticle::getArticleId)
                .eq(YmIntactArticle::getUserId, userId)
                .eq(YmIntactArticle::getIsDeleted, "0")
                .and(qw -> qw.like(YmArticle::getContent, str).or().like(YmArticle::getTitle, str));

        Page<Object> objectPage = new Page((long) page, 10L);
        Page<IntactArticleDTO> entities = (Page) this.intactArticleMapper.selectJoinPage(objectPage, IntactArticleDTO.class, wrapper);
        List<String> intactArticleIdList = entities.getRecords().stream().map(IntactArticleDTO::getIntactArticleId).collect(Collectors.toList());
        List<YmArticleLike> list = this.articleLikeService.lambdaQuery().in(intactArticleIdList.size() > 0, YmArticleLike::getArticleId, intactArticleIdList).eq(YmArticleLike::getUserId, userId).list();
        Page<IntactArticleVos> intactArticleVosPage = new Page();
        HashMap<String, Object> ifLike = new HashMap();
        list.forEach((temp) -> ifLike.put(temp.getArticleId(), "0"));
        List<IntactArticleVos> collect = entities.getRecords().stream().map((temp) -> {
            IntactArticleVos articleVos = new IntactArticleVos("", new ArticleVo(), new UserVo(), new ImageVo(), new FamilyVo(), false, false, "0", false);
            BeanUtils.copyProperties(temp, articleVos.getArticle());
            BeanUtils.copyProperties(temp, articleVos.getFamily());
            BeanUtils.copyProperties(temp, articleVos.getUser());
            BeanUtils.copyProperties(temp, articleVos.getImage());
            BeanUtils.copyProperties(temp, articleVos);
            articleVos.setLikeStatus(ifLike.containsKey(temp.getIntactArticleId()));
            return articleVos;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(entities, intactArticleVosPage);
        intactArticleVosPage.setRecords(collect);
        return intactArticleVosPage;
    }

    public List<IntactArticleDTO> articlePopularityRanking(List<IntactArticleDTO> dtos) {
        List<IntactArticleDTO> dto = dtos.stream().filter((r) -> r.getArticleId() != null).collect(Collectors.toList());

        for (int i = 0; i < dto.size() - 1; ++i) {
            for (int j = 0; j < dto.size() - 1 - i; ++j) {
                double heatCommentNum = (double) ((IntactArticleDTO) dto.get(j)).getCommentNum() * (double) 0.5F;
                double heatLikeNum = (double) ((IntactArticleDTO) dto.get(j)).getLikeNum() * 0.3;
                double heatViewsNum = (double) ((IntactArticleDTO) dto.get(j)).getViewsNum() * 0.2;
                double heatTime = Long.parseLong(((IntactArticleDTO) dto.get(j)).getCreateTime()) > System.currentTimeMillis() - 604800000L ? (double) 10000.0F : (double) 0.0F;
                double heat = heatTime + heatCommentNum + heatLikeNum + heatViewsNum;
                double previousHeatCommentNum = (double) ((IntactArticleDTO) dto.get(j + 1)).getCommentNum() * (double) 0.5F;
                double previousHeatLikeNum = (double) ((IntactArticleDTO) dto.get(j + 1)).getLikeNum() * 0.3;
                double previousHeatTime = Long.parseLong(((IntactArticleDTO) dto.get(j + 1)).getCreateTime()) > System.currentTimeMillis() - 604800000L ? (double) 10000.0F : (double) 0.0F;
                double previousHeatViewsNum = (double) ((IntactArticleDTO) dto.get(j + 1)).getViewsNum() * 0.2;
                double previousHeat = previousHeatTime + previousHeatCommentNum + previousHeatLikeNum + previousHeatViewsNum;
                if (heat < previousHeat) {
                    Collections.swap(dto, j, j + 1);
                }
            }
        }

        List<List<IntactArticleDTO>> partition = Lists.partition(dto, 10);
        return (List) partition.get(0);
    }

    public Object searchMyGoods(String userId, String content, String type) {
        Page<CommodityVos> page = new Page(1L, 15L);

        MPJLambdaWrapper<YmIntactGoods> wrapper = new MPJLambdaWrapper<YmIntactGoods>()
                .select(YmIntactGoods::getIntactGoodsId, YmIntactGoods::getType)
                .selectAll(YmUser.class)
                .selectAll(YmCommodityFamily.class)
                .selectAll(YmGoods.class)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactGoods::getUserId)
                .leftJoin(YmGoods.class, YmGoods::getGoodsId, YmIntactGoods::getGoodsId)
                .leftJoin(YmCommodityFamily.class, YmCommodityFamily::getFamilyId, YmIntactGoods::getFamilyId)
                .eq(YmIntactGoods::getIsDeleted, "0")
                .like(StringUtils.isNotEmpty(content), YmGoods::getGoodsName, content) // 使用 StringUtils.isNotEmpty
                .eq(YmIntactGoods::getUserId, userId);

        IPage<CommodityVos> commodityVosIPage;
        if (type.equals("1")) {
            commodityVosIPage = this.intactGoodsMapper.selectJoinPage(page, CommodityVos.class, (MPJBaseJoin) wrapper.eq(YmIntactGoods::getType, "1"));
        } else if (type.equals("0")) {
            commodityVosIPage = this.intactGoodsMapper.selectJoinPage(page, CommodityVos.class, (MPJBaseJoin) wrapper.eq(YmIntactGoods::getType, "0"));
        } else {
            commodityVosIPage = this.intactGoodsMapper.selectJoinPage(page, CommodityVos.class, wrapper);
        }

        return commodityVosIPage;
    }

    public Page<SearchArticleVo> allSearchMysql(String userId, String str, Integer page) {
        ArrayList<SearchArticleVo> searchArticleVos = new ArrayList();
        Page<SearchArticleVo> intactArticleVosPage = new Page((long) page, 10L);
        List<YmArticle> allArticle = this.ymArticleMapper.getAllSearch(str, (page - 1) * 10);
        Integer articleCount = this.ymArticleMapper.getArticleCount(str);
        intactArticleVosPage.setCurrent((long) page);
        intactArticleVosPage.setPages((long) (articleCount / 10 + 1));
        intactArticleVosPage.setRecords(searchArticleVos);
        intactArticleVosPage.setSize(10L);
        intactArticleVosPage.setTotal((long) articleCount);

        for (YmArticle ymArticle : allArticle) {
            YmIntactArticle intactArticle = this.intactArticleMapper.getIntactArticle(ymArticle.getArticleId());
            if (!Objects.isNull(intactArticle)) {
                YmUser ymUser = this.ymUserMapper.getUserById(intactArticle.getUserId());
                YmArticleImage ymArticleImage = null;
                if (!Objects.isNull(intactArticle.getArticleImageId())) {
                    ymArticleImage = this.ymArticleImageMapper.getArticleImageById(intactArticle.getArticleImageId());
                }

                YmArticleFamily ymArticleFamily = this.ymArticleFamilyMapper.getYmArticleFamilyById(intactArticle.getFamilyId());
                searchArticleVos.add(new SearchArticleVo(intactArticle.getIntactArticleId(), new ArticleVo(ymArticle), new SearchUserVo(ymUser), new ImageVo(ymArticleImage), !Objects.isNull(this.ymFansMapper.getOneFans(userId, ymUser.getUserId())), !Objects.isNull(this.ymFansMapper.getOneFans(ymUser.getUserId(), userId)), intactArticle.getPrivateState(), false));
            }
        }

        return intactArticleVosPage;
    }

    public List<String> getMapByArticleNum() {
        return this.baseMapper.selectMapByArticleNum();
    }
}
