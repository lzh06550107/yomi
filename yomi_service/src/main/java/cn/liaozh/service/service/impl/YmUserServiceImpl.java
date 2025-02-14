package cn.liaozh.service.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;
import cn.liaozh.common.oss.UploadUtils;
import cn.liaozh.dao.YmClassMapper;
import cn.liaozh.dao.YmQueryUserMapper;
import cn.liaozh.dao.YmStrAttestMapper;
import cn.liaozh.dao.YmUserMapper;
import cn.liaozh.pojo.*;
import cn.liaozh.pojo.vo.*;
import cn.liaozh.service.service.*;
import cn.liaozh.service.service.service_utils.UserTagUtils;
import cn.liaozh.service_base.enums.AppIsDel;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class YmUserServiceImpl extends MPJBaseServiceImpl<YmUserMapper, YmUser> implements YmUserService {
    @Autowired
    EsServiceImpl esService;
    @Autowired
    YmArticleLikeService articleLikeService;
    @Autowired
    YmCommentService commentService;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    YmFansService fansService;
    @Autowired
    YmFansService ymFansService;
    @Autowired
    private YmIntactArticleService intactArticleService;
    @Autowired
    YmArticleService articleService;
    @Autowired
    YmChatMsgService chatMsgService;
    @Autowired
    YmQueryUserService queryUserService;
    @Autowired
    YmQueryUserMapper queryUserMapper;
    @Autowired
    YmClassMapper classMapper;
    @Autowired
    YmStrAttestMapper strAttestMapper;
    @Autowired
    YmIntactGoodsService intactGoodsService;
    @Autowired
    YmUserService userService;
    @Autowired
    YmStrAttestService strAttestService;
    @Autowired
    YmUserMapper userMapper;
    @Autowired
    YmGoodsService goodsService;
    @Autowired
    YmCommodityFamilyService commodityFamilyService;
    @Autowired
    private YmCommentsService ymCommentsService;
    @Autowired
    private UserTagUtils userTagUtils;
    @Autowired
    private YmStudentService studentService;

    public YmUserServiceImpl() {
    }

    public YmUser selectByOpenId(String openId) {
        QueryWrapper<YmUser> wrapper = new QueryWrapper();
        wrapper.eq("open_id", openId);
        return (YmUser)((YmUserMapper)this.baseMapper).selectOne(wrapper);
    }

    public YmUser selectUserById(String id) {
        return (YmUser)((YmUserMapper)this.baseMapper).selectById(id);
    }

    public boolean updateFansNum(String userId, int flagNum) {
        return ((YmUserMapper)this.baseMapper).updateFansNum(userId, flagNum) == 1;
    }

    public boolean updateUserInfo(YmUser user) {
        int updateRow = ((YmUserMapper)this.baseMapper).updateById(user);
        return updateRow == 1;
    }

    public Page<UserSort> getUserBatch(String userId, String content, Integer page) {
        QueryWrapper<YmQueryUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(YmQueryUser::getQueryId, content);
        int pageSize = 10;
        Page<YmQueryUser> ymQueryUserIPage = new Page((long)page, (long)pageSize);
        Page<YmQueryUser> ymQueryUserPage = this.queryUserMapper.selectPage(ymQueryUserIPage, queryWrapper);
        if (ymQueryUserPage.getTotal() != 0L) {
            YmUser ymUser = this.lambdaQuery().eq(YmUser::getUserId, ymQueryUserPage.getRecords().get(0).getUserId()).one();
            YmFans fansStatus = this.fansService.lambdaQuery().eq(YmFans::getUserId, userId).eq(YmFans::getAnswerUserId, (ymQueryUserPage.getRecords().get(0).getUserId())).one();
            YmFans mutualConcern = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getUserId, (ymQueryUserPage.getRecords().get(0).getUserId())).one();
            UserSort userSort = new UserSort();
            BeanUtils.copyProperties(ymUser, userSort);
            userSort.setId(ymQueryUserPage.getRecords().get(0).getQueryId());
            userSort.setFansState(fansStatus != null);
            userSort.setFollowState(mutualConcern != null);
            ArrayList<UserSort> list = new ArrayList();
            list.add(userSort);
            Page<UserSort> userSortPage = new Page(1L, (long)pageSize);
            BeanUtils.copyProperties(ymQueryUserPage, userSortPage);
            userSortPage.setRecords(list);
            return userSortPage;
        } else {
            Page<YmUser> userPage = new Page((long)page, (long)pageSize);
            Page<YmUser> ymUserPage = this.userMapper.selectPage(
                    userPage,
                    new LambdaQueryWrapper<YmUser>().like(YmUser::getUserName, content)
            );
            if (ymUserPage.getRecords().size() == 0) {
                Page<UserSort> userSortPage = new Page(1L, (long)pageSize);
                BeanUtils.copyProperties(ymUserPage, userSortPage);
                return userSortPage;
            } else {
                List<String> userIdList = ymUserPage.getRecords().stream().map(YmUser::getUserId).collect(Collectors.toList());
                List<YmQueryUser> list = this.queryUserService.lambdaQuery().in(YmQueryUser::getUserId, userIdList).list();
                Map<String, YmQueryUser> weakHashMap = new WeakHashMap();
                list.forEach((temp) -> weakHashMap.put(temp.getUserId(), temp));

                Set<String> keys = this.fansService.lambdaQuery()
                        .eq(YmFans::getUserId, userId)
                        .in(YmFans::getAnswerUserId, userIdList)
                        .list()
                        .stream()
                        .map(temp -> temp.getUserId() + "::" + temp.getAnswerUserId())
                        .collect(Collectors.toSet());

                // 优化 keyss 的逻辑
                Map<String, YmFans> fansMap = this.fansService.lambdaQuery()
                        .in(YmFans::getAnswerUserId, userIdList) // 只查询 answerUserId 在 userIdList 中的记录
                        .list()
                        .stream()
                        .collect(Collectors.toMap(YmFans::getAnswerUserId, Function.identity())); // 构建以 answerUserId 为 key 的 Map

                Set<String> keyss = this.fansService.lambdaQuery()
                        .eq(YmFans::getUserId, userId)
                        .in(YmFans::getAnswerUserId, userIdList)
                        .list()
                        .stream()
                        .map(temp -> {
                            YmFans one = fansMap.get(temp.getAnswerUserId()); // 从 Map 中获取，避免再次查询
                            return one == null ? null : one.getUserId() + "::" + one.getAnswerUserId();
                        })
                        .collect(Collectors.toSet());

                List<UserSort> userSortList = ymUserPage.getRecords().stream().map((temp) -> {
                    UserSort userSort = new UserSort();
                    BeanUtils.copyProperties(temp, userSort);
                    userSort.setId(weakHashMap.get(temp.getUserId()).getQueryId());
                    userSort.setFansState(keys.contains(userId + "::" + temp.getUserId()));
                    userSort.setFollowState(keyss.contains(temp.getUserId() + "::" + userId));
                    return userSort;
                }).collect(Collectors.toList());
                Page<UserSort> userSortPage = new Page(1L, (long)pageSize);
                BeanUtils.copyProperties(ymUserPage, userSortPage);
                userSortPage.setRecords(userSortList);
                return userSortPage;
            }
        }
    }

    public FullUserVo selectUserById(String userId, String id) {
        FullUserVo fullUserVo = new FullUserVo();
        YmUser ymUser = this.getById(id);
        BeanUtils.copyProperties(ymUser, fullUserVo);
        List<YmIntactArticle> list = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getUserId, id).list();
        List<String> collect = list.stream().map(YmIntactArticle::getArticleId).collect(Collectors.toList());
        if (collect.size() == 0) {
            fullUserVo.setReadNum(0);
        } else {
            List<YmArticle> articleList = this.articleService.listByIds(collect);
            articleList.forEach((temp) -> fullUserVo.setReadNum((fullUserVo.getReadNum() == null ? 0 : fullUserVo.getReadNum()) + temp.getViewsNum()));
        }

        YmFans fans = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, id).eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0").one();
        YmFans follow = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getUserId, id).eq(YmFans::getIsDeleted, "0").one();
        fullUserVo.setFansState(fans != null);
        fullUserVo.setFollowState(follow != null);
        return fullUserVo;
    }

    public List<String> promptUserName(String content) {

        LambdaQueryWrapper<YmUser> wrapper = new LambdaQueryWrapper<YmUser>()
                .select(YmUser::getUserName)
                .like(YmUser::getUserName, content);

        List<YmUser> list = this.list(wrapper);
        return list.stream().map(YmUser::getUserName).collect(Collectors.toList());
    }

    public Map<String, Integer> num(String userId) {
        Integer articleNum = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getUserId, userId).count();
        Integer answerUserNum = this.fansService.lambdaQuery().eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0").count();
        Integer fansNum = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getIsDeleted, "0").count();
        Map<String, Integer> map = new HashMap();
        map.put("articleNum", articleNum);
        map.put("answerUserNum", answerUserNum);
        map.put("fansNum", fansNum);
        return map;
    }

    public Map<String, Object> personalInformation(String userId) {
        YmUser ymUsers = this.lambdaQuery().select(YmUser::getAvatar, YmUser::getUserName, YmUser::getSignature, YmUser::getUserId, YmUser::getSex, YmUser::getPhoneNumber, YmUser::getWxNum, YmUser::getQqNum, YmUser::getClassId).eq(YmUser::getUserId, userId).one();
        Map<String, Object> objectMap = BeanUtil.beanToMap(ymUsers, new HashMap(), true, new Editor<String>() {
            public String edit(String s) {
                return s;
            }
        });
        Integer queryId = this.queryUserService.selectIdByUserId(userId);
        objectMap.put("id", queryId);
        return objectMap;
    }

    public boolean modifyUserInformation(String userId, ModifyUserInfoVo userInfoVo) {
        String phoneNumber = userInfoVo.getPhoneNumber();
        if (!phoneNumber.equals("") && !phoneNumber.matches("^1(3\\d|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")) {
            return false;
        } else {
            YmUser ymUser = new YmUser();
            BeanUtils.copyProperties(userInfoVo, ymUser);
            ymUser.setUserId(userId);
            String avatar = userInfoVo.getAvatar();
            if (!Objects.isNull(avatar) && !avatar.isEmpty()) {
                String oldAvatar = this.lambdaQuery().select(YmUser::getAvatar).eq(YmUser::getUserId, userId).one().getAvatar();
                if (!oldAvatar.equals(avatar)) {
                    boolean deleteImageFlag = UploadUtils.deleteImage(oldAvatar);
                    this.log.debug("deleteImageFlag >>>>> " + deleteImageFlag);
                }
            }

            return this.updateById(ymUser);
        }
    }

    public Map<String, Object> strInfo(String userId) {

        MPJLambdaWrapper<YmUser> wrapper = new MPJLambdaWrapper<YmUser>()
                .leftJoin(YmStrAttest.class, YmStrAttest::getUserId, YmUser::getUserId)
                .leftJoin(YmClass.class, YmClass::getClassId, YmUser::getClassId)
                .select(YmUser::getAvatar, YmUser::getClassId)
                .select(YmStrAttest::getStrName, YmStrAttest::getStrAttestId, YmStrAttest::getStrNumber)
                .eq(YmUser::getUserId, userId);

        Map<String, Object> map = this.userMapper.selectJoinMap(wrapper);
        if (map == null) {
            return new HashMap();
        } else {
            if (map.get("class_id") != null) {
                LambdaQueryWrapper<YmClass> queryWrapper = new LambdaQueryWrapper();
                String parentId = map.get("class_id").toString();
                queryWrapper.eq(YmClass::getClassId, parentId);
                YmClass Ymclass = (YmClass)this.classMapper.selectOne(queryWrapper);
                map.put("department", Ymclass.getTitle());
                LambdaQueryWrapper<YmClass> queryWrappers = new LambdaQueryWrapper();
                queryWrappers.eq(YmClass::getClassId, Ymclass.getParentId());
                YmClass Ymclasss = (YmClass)this.classMapper.selectOne(queryWrappers);
                map.put("school", Ymclasss.getTitle());
                map.put("parentId", Ymclass.getParentId());
            }

            return map;
        }
    }

    public List<Map<String, Object>> schoolInfo(String userId) {
        QueryWrapper<YmClass> wrapper = new QueryWrapper();
        wrapper.lambda().eq(YmClass::getParentId, "0");
        List<YmClass> ymClasses = this.classMapper.selectList(wrapper);
        List<Map<String, Object>> collect = ymClasses.stream().map((temp) -> {
            Map<String, Object> objectHashMap = new HashMap();
            objectHashMap.put("classId", temp.getClassId());
            objectHashMap.put("title", temp.getTitle());
            return objectHashMap;
        }).collect(Collectors.toList());
        return collect;
    }

    public List<Map<String, Object>> department(String classId) {
        QueryWrapper<YmClass> wrapper = new QueryWrapper();
        wrapper.lambda().eq(YmClass::getParentId, classId);
        List<YmClass> ymClasses = this.classMapper.selectList(wrapper);
        List<Map<String, Object>> collect = ymClasses.stream().map((temp) -> {
            Map<String, Object> objectHashMap = new HashMap();
            objectHashMap.put("classId", temp.getClassId());
            objectHashMap.put("title", temp.getTitle());
            return objectHashMap;
        }).collect(Collectors.toList());
        return collect;
    }

    public boolean modifyStrInfo(String userId, StrInfoVo infoVo) {
        String classId = infoVo.getClassId();
        Integer strNumber = infoVo.getStrNumber();
        if (Objects.isNull(strNumber)) {
            throw new YmException(ExecutionResult.NUMBER_CODE_406);
        } else {
            YmClass ymClass = this.classMapper.selectById(classId);
            YmStudent student = this.studentService.getById(strNumber);
            if (!Objects.isNull(student) && student.getName().equals(infoVo.getStrName()) && student.getDept().equals(ymClass.getTitle())) {
                Integer userAttestCount = this.strAttestService.lambdaQuery().eq(YmStrAttest::getUserId, userId).count();
                if (userAttestCount >= 1) {
                    throw new YmException(ExecutionResult.AUTH_CODE_603);
                } else {
                    Integer attestCount = this.strAttestService.lambdaQuery().eq(YmStrAttest::getStrNumber, strNumber).count();
                    if (attestCount >= 1) {
                        throw new YmException(ExecutionResult.AUTH_CODE_602);
                    } else {
                        this.lambdaUpdate().eq(YmUser::getUserId, userId).set(YmUser::getClassId, classId).update();
                        YmStrAttest ymStrAttest = new YmStrAttest();
                        BeanUtils.copyProperties(infoVo, ymStrAttest);
                        ymStrAttest.setUserId(userId);
                        return this.strAttestService.save(ymStrAttest);
                    }
                }
            } else {
                throw new YmException(ExecutionResult.NUMBER_CODE_406);
            }
        }
    }

    public List<UserInfoVo> activeUser(String userId) {

        List<String> userIdList = this.ymFansService.lambdaQuery()
                .select(YmFans::getAnswerUserId)
                .eq(YmFans::getIsDeleted, AppIsDel.NOT_DELETE.getCode())
                .ge(YmFans::getCreateTime, System.currentTimeMillis() - 604800000L)
                .last("GROUP BY answer_user_id ORDER BY COUNT(1) DESC LIMIT 5")
                .list()
                .stream()
                .map(YmFans::getAnswerUserId) // 从 map 中获取 answer_user_id
                .collect(Collectors.toList());

        if (userIdList.size() < 5) {

            IPage<YmUser> userPage = this.userService.lambdaQuery()
                    .orderByDesc(YmUser::getFansNum)
                    .page(new Page<>(0, 5 - userIdList.size())); // 使用 Page 类的构造函数，并使用 IPage 接收

            List<String> fansUserIdList = userPage.getRecords().stream()
                    .map(YmUser::getUserId)
                    .collect(Collectors.toList());

            userIdList.addAll(fansUserIdList);
        }

        List<YmUser> ymUsers = this.userService.listByIds(userIdList);
        List<String> fansList = this.fansService.lambdaQuery().eq(YmFans::getUserId, userId).in(YmFans::getAnswerUserId, userIdList).eq(YmFans::getIsDeleted, "0").list().stream().map((temp) -> temp.getUserId() + "::" + temp.getAnswerUserId()).collect(Collectors.toList());
        List<String> followed = this.fansService.lambdaQuery().in(YmFans::getUserId, userIdList).eq(YmFans::getAnswerUserId, userId).eq(YmFans::getIsDeleted, "0").list().stream().map((temp) -> temp.getUserId() + "::" + temp.getAnswerUserId()).collect(Collectors.toList());

        List<YmQueryUser> queryUsers = this.queryUserService.lambdaQuery().in(YmQueryUser::getUserId, userIdList).list();
        HashMap<String, YmQueryUser> stringYmQueryUserHashMap = new HashMap();
        queryUsers.forEach((temp) -> {
            YmQueryUser var10000 = (YmQueryUser)stringYmQueryUserHashMap.put(temp.getUserId(), temp);
        });
        List<UserInfoVo> userInfoVos = new ArrayList();
        ymUsers.forEach((temp) -> {
            UserInfoVo userInfoVo = new UserInfoVo();
            BeanUtils.copyProperties(temp, userInfoVo);
            userInfoVo.setFansState(fansList.contains(userId + "::" + temp.getUserId()));
            userInfoVo.setFollowState(followed.contains(temp.getUserId() + "::" + userId));
            userInfoVo.setId(((YmQueryUser)stringYmQueryUserHashMap.get(temp.getUserId())).getQueryId());
            boolean goodUser = this.userTagUtils.isGoodUser(temp.getUserId());
            if (goodUser) {
                userInfoVo.setGoodUser(1);
            }

            userInfoVos.add(userInfoVo);
        });

        for(UserInfoVo userInfoVo : userInfoVos) {
            userInfoVo.setUserIdentity(0);
        }

        return userInfoVos;
    }

    public IPage<CommodityVos> inStock(String userId, Integer type, Integer page) {
        Page<CommodityVos> pageNum = new Page((long)page, 15L);

        MPJLambdaWrapper<YmIntactGoods> wrapper = new MPJLambdaWrapper<YmIntactGoods>()
                .select(YmIntactGoods::getIntactGoodsId, YmIntactGoods::getType)
                .selectAll(YmUser.class)
                .selectAll(YmCommodityFamily.class)
                .selectAll(YmGoods.class)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactGoods::getUserId)
                .leftJoin(YmGoods.class, YmGoods::getGoodsId, YmIntactGoods::getGoodsId)
                .leftJoin(YmCommodityFamily.class, YmCommodityFamily::getFamilyId, YmIntactGoods::getFamilyId)
                .eq(YmIntactGoods::getIsDeleted, "0")
                .eq(YmIntactGoods::getUserId, userId);

        switch (type) {
            case 0:
                wrapper.eq(YmIntactGoods::getType, type.toString());
                break;
            case 1:
                wrapper.eq(YmIntactGoods::getType, type.toString());
            case 2:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        return this.intactGoodsService.selectJoinListPage(pageNum, CommodityVos.class, wrapper);
    }

    public boolean modifyMyGoods(String userId, String id, Integer type) {
        return this.intactGoodsService.lambdaUpdate().set(YmIntactGoods::getType, type.toString()).eq(YmIntactGoods::getIntactGoodsId, id).eq(YmIntactGoods::getUserId, userId).update();
    }

    public IPage<CommodityVos> userInfo(String id, String judge, Integer page) {
        return this.inStock(id, 1, page);
    }

    public boolean modifyGoods(String userId, UpdateGoodsVo goodsVo) {
        YmIntactGoods byId = (YmIntactGoods)this.intactGoodsService.getById(goodsVo.getIntactGoodsId());
        if (byId.getUserId().equals(userId)) {
            YmGoods ymGoods = new YmGoods();
            BeanUtils.copyProperties(goodsVo, ymGoods);
            if (goodsVo.getFamilyId() != null && null != this.commodityFamilyService.getById(goodsVo.getFamilyId())) {
                this.intactGoodsService.lambdaUpdate().set(YmIntactGoods::getFamilyId, goodsVo.getFamilyId()).update();
            }

            ymGoods.setGoodsId(byId.getGoodsId());
            return this.goodsService.updateById(ymGoods);
        } else {
            return false;
        }
    }

    public Object getUserTag(String userId) {
        Map<String, String> objectMap = new HashMap();
        Integer intactArticleCount = this.intactArticleService.lambdaQuery().eq(YmIntactArticle::getUserId, userId).count();
        Integer commentsCount = this.ymCommentsService.lambdaQuery().eq(YmComments::getUserId, userId).count();
        if (intactArticleCount > 3) {
            objectMap.put("userIntactArticleTag", "1");
        } else {
            objectMap.put("userIntactArticleTag", "0");
        }

        if (commentsCount > 10) {
            objectMap.put("userCommentsTag", "1");
        } else {
            objectMap.put("userCommentsTag", "0");
        }

        return objectMap;
    }

    public List<YmIdeafeedback> getNews(String userId) {
        return this.baseMapper.getNewsByUserId(userId);
    }
}

