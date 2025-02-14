package cn.liaozh.service.controller;

import cn.liaozh.common.nonEmptyJudgment.ObjectUtils;
import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmIntactArticle;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.pojo.vo.*;
import cn.liaozh.service.service.ImgUploadService;
import cn.liaozh.service.service.YmIntactArticleService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service.service.service_utils.AuthUserUtils;
import cn.liaozh.service.service.service_utils.StringUtils;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@Validated
@RequestMapping({"/ym_server/user"})
public class YmUserController {
    @Resource
    private YmUserService userService;
    @Resource
    private ImgUploadService imgUploadService;
    @Resource
    private YmIntactArticleService intactArticleService;
    @Autowired
    private AuthUserUtils authUserUtils;
    @Autowired
    private StringUtils stringUtils;

    public YmUserController() {
    }

    @GetMapping({"{id}"})
    public R getUserById(@PathVariable String id) {
        YmUser user = this.userService.selectUserById(id);
        return R.ok().data("user", user);
    }

    @GetMapping({"/auth"})
    public R getAuth(String userId) {
        if (this.authUserUtils.isAuthUser(userId)) {
            return R.ok();
        } else {
            throw new YmException(ExecutionResult.AUTH_CODE_601);
        }
    }

    @GetMapping({"full/{id}"})
    public R fullUserById(String userId, @PathVariable String id) {
        FullUserVo fullUserVo = this.userService.selectUserById(userId, id);
        return R.ok().data("user", fullUserVo);
    }

    @PutMapping({"modifyMyGoods"})
    public R modifyMyGoods(String userId, String goodsId, Integer type) {
        System.out.println(">>>>>>>>>>>>>>>>>>" + userId + "\n" + goodsId + "\n" + type);
        if (type > 2) {
            return R.error().message("最大值不能大于2");
        } else {
            boolean isUpdate = this.userService.modifyMyGoods(userId, goodsId, type);
            return isUpdate ? R.ok() : R.error();
        }
    }

    @GetMapping({"search"})
    public R getUserBatch(String userId, @PathParam("content") String content, @PathParam("page") Integer page) {
        if (ObjectUtils.notEmpty(content)) {
            Page<UserSort> userBatch = this.userService.getUserBatch(userId, content, page);
            return R.ok().data("list", userBatch);
        } else {
            throw new YmException(ExecutionResult.REQUEST_CODE_401);
        }
    }

    @PutMapping
    public R updateUser(@RequestBody YmUser user, String userId) {
        user.setUserId(userId);
        boolean flag = this.userService.updateUserInfo(user);
        return flag ? R.ok() : R.error();
    }

    @GetMapping({"promptUserName"})
    public R promptUserName(@PathParam("content") String content) {
        List<String> stringPage = this.userService.promptUserName(content);
        return R.ok().data("data", new HashSet(stringPage));
    }

    @PostMapping({"uploadFile"})
    public R uploadFile(MultipartFile file) {
        String fileUrl = this.imgUploadService.commonUpload(file, 12);
        return R.ok().data("url", fileUrl);
    }

    @GetMapping({"num"})
    public R num(String userId) {
        return R.ok().data("communityData", this.userService.num(userId));
    }

    @GetMapping({"personalInformation"})
    public R personalInformation(String userId) {
        return R.ok().data("userInfo", this.userService.personalInformation(userId));
    }

    @PutMapping({"personalInformation"})
    public R modifyUserInformation(String userId, @RequestBody @Valid ModifyUserInfoVo userInfoVo) {
        if (!this.stringUtils.strFilter(userInfoVo.getUserName()) && !this.stringUtils.strFilter(userInfoVo.getSignature())) {
            boolean isUpdate = this.userService.modifyUserInformation(userId, userInfoVo);
            return isUpdate ? R.ok() : R.error();
        } else {
            throw new YmException(ExecutionResult.ARTICLE_CODE_405);
        }
    }

    @GetMapping({"strInfo"})
    public R strInfo(String userId) {
        Map<String, Object> map = this.userService.strInfo(userId);
        map.put("department", "开发认证");
        return R.ok().data("info", map);
    }

    @GetMapping({"schoolInfo"})
    public R schoolInfo(String userId) {
        return R.ok().data("schoolInfo", this.userService.schoolInfo(userId));
    }

    @GetMapping({"department"})
    public R department(@PathParam("classId") String classId) {
        return R.ok().data("department", this.userService.department(classId));
    }

    @PutMapping({"strInfo"})
    public R modifyStrInfo(String userId, @RequestBody StrInfoVo infoVo) {
        boolean isFlag = this.userService.modifyStrInfo(userId, infoVo);
        return isFlag ? R.ok() : R.error();
    }

    @GetMapping({"activeUser"})
    public R activeUser(String userId) {
        List<UserInfoVo> userInfoVoList = this.userService.activeUser(userId);
        List<Map<String, Object>> resultList = new ArrayList();

        for(final UserInfoVo userInfoVo : userInfoVoList) {
            resultList.add(new HashMap<String, Object>() {
                {
                    this.put("userId", userInfoVo.getUserId());
                    this.put("userName", userInfoVo.getUserName());
                    this.put("sex", userInfoVo.getSex());
                    this.put("avatar", userInfoVo.getAvatar());
                    this.put("fansNum", userInfoVo.getFansNum());
                    this.put("fansState", userInfoVo.getFansState());
                    this.put("followState", userInfoVo.isFollowState());
                }
            });
        }

        return R.ok().data("activeUser", resultList);
    }

    @PutMapping({"privateArticle"})
    public R privateArticle(String userId, @PathParam("articleId") String articleId, @PathParam("status") @Length(
            min = 0,
            max = 1,
            message = "长度不可用超过2"
    ) @Pattern(
            regexp = "^[0-1]",
            message = "只可以传0或1"
    ) String status) {
        boolean isUpdate = this.intactArticleService.lambdaUpdate().eq(YmIntactArticle::getIntactArticleId, articleId).eq(YmIntactArticle::getUserId, userId).set(YmIntactArticle::getPrivateState, status).update();
        return isUpdate ? R.ok() : R.error();
    }

    @GetMapping({"search-goods"})
    public R myGoods(String userId, @PathParam("content") String content, @PathParam("type") Integer type, @PathParam("page") Integer page) {
        return ObjectUtils.isEmpty(content) ? R.ok().data("goods", this.userService.inStock(userId, type, page)) : R.ok().data("goods", this.intactArticleService.searchMyGoods(userId, content, String.valueOf(type)));
    }

    @GetMapping({"userInfo"})
    public R userInfo(String userId, String judge, Integer page, String uid) {
        if (ObjectUtils.isNotEmpty(uid)) {
            userId = uid;
        }

        return judge.equals("1") ? R.ok().data("userInfo", this.intactArticleService.myArticle(userId, page)) : R.ok().data("userInfo", this.userService.userInfo(userId, judge, page));
    }

    @PutMapping({"modifyGoods"})
    public R modifyGoods(String userId, @RequestBody UpdateGoodsVo goodsVo) {
        boolean isUpdate = this.userService.modifyGoods(userId, goodsVo);
        return isUpdate ? R.ok() : R.error();
    }

    @GetMapping({"/news"})
    public R getInformation(String userId) {
        return R.ok().data("news", this.userService.getNews(userId));
    }
}
