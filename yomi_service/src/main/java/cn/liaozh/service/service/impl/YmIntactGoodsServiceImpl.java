package cn.liaozh.service.service.impl;

import cn.liaozh.common.nonEmptyJudgment.ObjectUtils;
import cn.liaozh.dao.YmIntactGoodsMapper;
import cn.liaozh.pojo.*;
import cn.liaozh.pojo.vo.AddOneGoodsVo;
import cn.liaozh.pojo.vo.CommodityVos;
import cn.liaozh.pojo.vo.Opinion;
import cn.liaozh.service.service.*;
import cn.liaozh.service.service.service_utils.UserTagUtils;
import cn.liaozh.service.websocket.enumType.MsgEnumType;
import cn.liaozh.service.websocket.util.WebSocketUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
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
import java.util.Objects;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class YmIntactGoodsServiceImpl extends MPJBaseServiceImpl<YmIntactGoodsMapper, YmIntactGoods> implements YmIntactGoodsService {
    @Autowired
    private YmGoodsService goodsService;
    @Autowired
    private EsServiceImpl esService;
    @Autowired
    private YmUserService userService;
    @Autowired
    private YmIntactGoodsMapper intactGoodsMapper;
    @Resource
    private YmFansService fansService;
    @Autowired
    private YmIntactGoodsService ymIntactGoodsService;
    @Autowired
    private YmCommodityFamilyService commodityFamilyService;
    @Autowired
    private YmCommentsService commentsService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private WebSocketUtils webSocketUtils;
    @Autowired
    private UserTagUtils userTagUtils;

    public IPage<CommodityVos> getGoods(String familyId, String sort, String userId, Integer page) {

        MPJLambdaWrapper<YmIntactGoods> mpjLambdaWrapper = new MPJLambdaWrapper<YmIntactGoods>()
                .select(YmUser::getUserId, YmUser::getUserName, YmUser::getAvatar)
                .selectAll(YmGoods.class)
                .selectAll(YmIntactGoods.class)
                .selectAll(YmCommodityFamily.class)
                .leftJoin(YmGoods.class, YmGoods::getGoodsId, YmIntactGoods::getGoodsId)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactGoods::getUserId)
                .leftJoin(YmCommodityFamily.class, YmCommodityFamily::getFamilyId, YmIntactGoods::getFamilyId)
                .eq(YmIntactGoods::getIsDeleted, "0")
                .eq(YmIntactGoods::getType, "1")
                .eq(StringUtils.isNotEmpty(familyId) &&!familyId.equals("0"), YmIntactGoods::getFamilyId, familyId);

        MPJLambdaWrapper<YmIntactGoods> wrapper = null;
        switch (sort) {
            case "0":
                wrapper = mpjLambdaWrapper.orderByDesc(YmGoods::getUpdateTime, YmGoods::getCreateTime);
                break;
            case "1":
                wrapper = mpjLambdaWrapper.orderByDesc(YmGoods::getViewsNum);
                break;
            case "2":
                wrapper = mpjLambdaWrapper.orderByDesc(YmGoods::getGoodsPrice);
                break;
            case "3":
                wrapper = mpjLambdaWrapper.orderByAsc(YmGoods::getGoodsPrice);
                break;
            default:
                wrapper = mpjLambdaWrapper.orderByDesc(YmGoods::getUpdateTime, YmGoods::getCreateTime);
        }

        Page<CommodityVos> pages = new Page<>((long)page, 15L);
        return this.intactGoodsMapper.selectJoinPage(pages, CommodityVos.class, wrapper);
    }

    public List<CommodityVos> getOneGoods(String userId, String id) {
        List<CommodityVos> list = this.baseMapper.getOneGoods(id);
        YmIntactGoods ymIntactGoods = this.ymIntactGoodsService.lambdaQuery().eq(id != null && !id.isEmpty(), YmIntactGoods::getIntactGoodsId, id).eq(YmIntactGoods::getIsDeleted, "0").one();
        if (ymIntactGoods != null) {
            String goodsId = ymIntactGoods.getGoodsId();
            boolean flag = this.goodsService.lambdaUpdate().eq(goodsId != null && !goodsId.isEmpty(), YmGoods::getGoodsId, goodsId).setSql("views_num = views_num+1").update();
            if (!flag) {
                throw new YmException(ExecutionResult.DATA_CODE_400);
            }
        }

        HashMap<String, Object> fansMap = new HashMap<>();
        QueryWrapper<YmFans> fansWrappers = new QueryWrapper<>();
        fansWrappers.eq("user_id", userId).eq("is_deleted", "0");
        List<YmFans> lists = this.fansService.list(fansWrappers);
        lists.forEach((temp) -> fansMap.put(temp.getAnswerUserId() + "::" + temp.getUserId(), 1));
        list.forEach((temp) -> {
            temp.setFansState(fansMap.containsKey(temp.getUserId() + "::" + userId));
            YmFans two = this.fansService.lambdaQuery().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getUserId, temp.getUserId()).eq(YmFans::getIsDeleted, "0").one();
            temp.setFollowState(!Objects.isNull(two));
            temp.setNumberOfComments(this.commentsService.lambdaQuery().eq(YmComments::getTargetId, id).count());
            temp.setTag(this.userTagUtils.getSchoolTag(temp.getUserId()));
        });
        return list;
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public String addOneGoods(String userId, AddOneGoodsVo goodsVo) {
        List<YmGoods> list = this.goodsService.lambdaQuery().eq(YmGoods::getGoodsName, goodsVo.getTitle()).eq(YmGoods::getGoodsDescribe, goodsVo.getContent()).list();
        if (!list.isEmpty()) {
            throw new YmException(ExecutionResult.COMMIT_CODE_701);
        } else {
            YmGoods ymGoods = new YmGoods();
            String[] imageLink = goodsVo.getImageLink();
            StringBuilder link = new StringBuilder();

            for(int i = 0; i < imageLink.length; ++i) {
                if (imageLink.length - 1 == i) {
                    link.append(imageLink[i]);
                } else {
                    link.append(imageLink[i]).append(";");
                }
            }

            ymGoods.setGoodsImage(link.toString());
            ymGoods.setGoodsName(goodsVo.getTitle());
            ymGoods.setGoodsPrice(goodsVo.getPrice());
            ymGoods.setGoodsDescribe(goodsVo.getContent());
            ymGoods.setContact(goodsVo.getContact());
            this.goodsService.save(ymGoods);
            YmIntactGoods ymIntactGoods = new YmIntactGoods();
            ymIntactGoods.setGoodsId(ymGoods.getGoodsId());
            ymIntactGoods.setFamilyId(goodsVo.getFamilyId());
            ymIntactGoods.setUserId(userId);
            this.save(ymIntactGoods);
            return ymIntactGoods.getIntactGoodsId();
        }
    }

    public boolean deleteOneGoods(String userId, String id) {
        YmIntactGoods byId = this.getById(id);
        return byId.getUserId().equals(userId) && this.removeById(id);
    }

    public IPage<CommodityVos> searchAll(String userId, String content, String sort, String familyId, Integer page) {

        MPJLambdaWrapper<YmIntactGoods> ymIntactGoodsMPJLambdaWrapper = new MPJLambdaWrapper<YmIntactGoods>()
                .select(YmIntactGoods::getIntactGoodsId)
                .selectAll(YmUser.class)
                .selectAll(YmCommodityFamily.class)
                .selectAll(YmGoods.class)
                .leftJoin(YmUser.class, YmUser::getUserId, YmIntactGoods::getUserId)
                .leftJoin(YmGoods.class, YmGoods::getGoodsId, YmIntactGoods::getGoodsId)
                .leftJoin(YmCommodityFamily.class, YmCommodityFamily::getFamilyId, YmIntactGoods::getFamilyId)
                .eq(StringUtils.isNotEmpty(familyId) && !familyId.equals("0"), YmCommodityFamily::getFamilyId, familyId)
                .eq(YmIntactGoods::getIsDeleted, "0")
                .eq(YmIntactGoods::getType, "1")
                .like(StringUtils.isNotEmpty(content), YmGoods::getGoodsName, content);

        MPJLambdaWrapper<YmIntactGoods> wrapper = null;
        switch (sort) {
            case "0":
                wrapper = ymIntactGoodsMPJLambdaWrapper.orderByDesc(YmGoods::getUpdateTime, YmGoods::getCreateTime);
                break;
            case "1":
                wrapper = ymIntactGoodsMPJLambdaWrapper.orderByDesc(YmGoods::getViewsNum);
                break;
            case "2":
                wrapper = ymIntactGoodsMPJLambdaWrapper.orderByDesc(YmGoods::getGoodsPrice);
                break;
            case "3":
                wrapper = ymIntactGoodsMPJLambdaWrapper.orderByAsc(YmGoods::getGoodsPrice);
                break;
            default:
                wrapper = ymIntactGoodsMPJLambdaWrapper.orderByDesc(YmGoods::getUpdateTime, YmGoods::getCreateTime);
        }

        Page<CommodityVos> pages = new Page((long)page, 15L);
        return this.intactGoodsMapper.selectJoinPage(pages, CommodityVos.class, wrapper);
    }

    public List<CommodityVos> myselfGoods(String userId, String goodsName) {
        List<CommodityVos> oneselfGoods = this.baseMapper.getOneselfGoods(userId);
        List<CommodityVos> list = new ArrayList();
        return list;
    }

    public boolean feedback(String userId, Opinion str) {
        QueryWrapper<YmUser> wrapper = new QueryWrapper<>();
        wrapper.select("user_id", "user_name");
        wrapper.eq("user_id", userId);
        YmUser user = this.userService.getOne(wrapper);
        if (ObjectUtils.notEmpty(user)) {
            boolean isSave = this.baseMapper.insertIdeaFeedback(user.getUserId(), str.getStr(), System.currentTimeMillis());
            YmChatMsg ymChatMsg = new YmChatMsg();
            ymChatMsg.setType(MsgEnumType.SYSTEM.getType());
            ymChatMsg.setSendUserId("system");
            ymChatMsg.setAcceptUserId(userId);
            ymChatMsg.setImage("");
            ymChatMsg.setSignFlag("0");
            ymChatMsg.setMsg("我们已经接到您的反馈");
            if (isSave) {
                this.webSocketUtils.sendUnreadMessagesNum(ymChatMsg);
            }

            return isSave;
        } else {
            return false;
        }
    }

    public List<YmCommodityFamily> getFamily() {
        return this.commodityFamilyService.lambdaQuery().list();
    }

    public Object getBulletinImg() {
        ArrayList<String> list = new ArrayList<>();
        list.add(this.redisTemplate.opsForValue().get("image:1"));
        list.add(this.redisTemplate.opsForValue().get("image:2"));
        return list;
    }
}
