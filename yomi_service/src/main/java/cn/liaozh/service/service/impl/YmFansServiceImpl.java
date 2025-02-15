package cn.liaozh.service.service.impl;

import cn.liaozh.dao.YmFansMapper;
import cn.liaozh.pojo.YmFans;
import cn.liaozh.pojo.YmQueryUser;
import cn.liaozh.pojo.YmUser;
import cn.liaozh.pojo.vo.PageVo;
import cn.liaozh.pojo.vo.UserFansVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.service.service.YmFansService;
import cn.liaozh.service.service.YmQueryUserService;
import cn.liaozh.service.service.YmUserService;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class YmFansServiceImpl extends MPJBaseServiceImpl<YmFansMapper, YmFans> implements YmFansService {
    @Resource
    private YmUserService userService;
    @Resource
    private YmQueryUserService queryUserService;

    public boolean insertFans(YmFans fans) {
        boolean userFlag = this.baseMapper.selectFans(fans) == 0;
        int insertOrUpdate = userFlag ? this.baseMapper.insert(fans) : this.baseMapper.updateFans(fans);
        if (insertOrUpdate == 1) {
            QueryWrapper<YmFans> fansNumWrapper = new QueryWrapper<>();
            fansNumWrapper.eq("user_id", fans.getUserId());
            return this.userService.updateFansNum(fans.getAnswerUserId(), 1);
        } else {
            throw new YmException(ExecutionResult.DATA_CODE_302);
        }
    }

    public PageVo selectFansList(String userId, int pageNum, String column) {
        boolean answerColumnFlag = "answer_user_id".equals(column);
        PageHelper.startPage(pageNum, 10);
        QueryWrapper<YmFans> fansWrapper = new QueryWrapper<>();
        fansWrapper.eq(column, userId);
        List<YmFans> fanss = this.baseMapper.selectList(fansWrapper);
        PageInfo<List<YmFans>> listPageInfo = new PageInfo<>(Collections.singletonList(fanss));
        List<YmFans> fansList = listPageInfo.getList().get(0);
        List<YmFans> var20 = new ArrayList<>(fansList);
        List<UserInfoVo> listUserInfo = new ArrayList<>();
        if (var20.isEmpty()) {
            return new PageVo();
        } else {
            List<String> userIdList = new ArrayList();

            for (YmFans fans : var20) {
                if (answerColumnFlag) {
                    userIdList.add(fans.getUserId());
                } else {
                    userIdList.add(fans.getAnswerUserId());
                }
            }

            QueryWrapper<YmQueryUser> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.in("user_id", userIdList);
            List<YmQueryUser> queryUserList = this.queryUserService.list(userQueryWrapper);
            String answerFansListStr = null;
            if (answerColumnFlag) {
                QueryWrapper<YmFans> fansQueryWrapper = new QueryWrapper<>();
                fansQueryWrapper.eq("user_id", userId);
                answerFansListStr = this.baseMapper.selectList(fansQueryWrapper).toString();
            }

            List<YmUser> userList = this.userService.listByIds(userIdList);

            for (int i = 0; i < queryUserList.size() - 1; ++i) {
                int queryId = queryUserList.get(i).getQueryId();
                UserInfoVo userInfoVo = new UserInfoVo();
                userInfoVo.setId(queryId);
                YmUser user = userList.get(i);
                BeanUtils.copyProperties(user, userInfoVo);
                if (answerColumnFlag) {
                    boolean answerFansState = answerFansListStr.contains(user.getUserId());
                    userInfoVo.setFansState(answerFansState);
                }

                listUserInfo.add(userInfoVo);
            }

            String pageStr = listPageInfo.getList().toString();
            int startIndex = pageStr.indexOf("total=") + "total=".length();
            int endIndex = pageStr.indexOf(",", startIndex);
            String totalNum = pageStr.substring(startIndex, endIndex);
            return new PageVo(Long.parseLong(totalNum), listUserInfo);
        }
    }

    public Page<UserInfoVo> selectFansList(String userId, String judge, Integer page) {
        Map<String, Object> key = new HashMap<>();
        Map<String, Object> queryUserId = new HashMap<>();
        Page<UserInfoVo> userInfoVoPage = new Page<>();
        IPage<YmFans> ymFansIPages;
        List<String> collect;
        QueryWrapper<YmFans> wrapper = new QueryWrapper<>();
        if (judge.equals("0")) {
            wrapper.lambda().eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0");
            Page<YmFans> ymFansPage = new Page<>((long) page, 20L);
            ymFansIPages = this.baseMapper.selectPage(ymFansPage, wrapper);
            collect = ymFansIPages.getRecords().stream().map(YmFans::getAnswerUserId).collect(Collectors.toList());
        } else {
            wrapper.lambda().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getIsDeleted, "0");
            Page<YmFans> ymFansPage = new Page<>((long) page, 20L);
            ymFansIPages = this.baseMapper.selectPage(ymFansPage, wrapper);
            collect = ymFansIPages.getRecords().stream().map(YmFans::getUserId).collect(Collectors.toList());
        }

        if (collect.isEmpty()) {
            BeanUtils.copyProperties(ymFansIPages, userInfoVoPage);
            return userInfoVoPage;
        } else {
            List<YmUser> ymUsers = this.userService.listByIds(collect);
            List<YmQueryUser> queryUserList = this.baseMapper.queryUserId(collect);
            List<YmFans> likeEachOther;
            if (judge.equals("0")) {
                likeEachOther = this.lambdaQuery().in(YmFans::getUserId, ymUsers.stream().map(YmUser::getUserId).collect(Collectors.toList())).eq(YmFans::getIsDeleted, "0").list();
            } else {
                likeEachOther = this.lambdaQuery().in(YmFans::getAnswerUserId, ymUsers.stream().map(YmUser::getUserId).collect(Collectors.toList())).eq(YmFans::getIsDeleted, "0").list();
            }

            likeEachOther.forEach((temp) -> key.put(temp.getUserId() + "::" + temp.getAnswerUserId(), 0));
            queryUserList.forEach((temp) -> queryUserId.put(temp.getUserId(), temp.getQueryId()));
            ArrayList<UserInfoVo> userInfoVos = new ArrayList();
            ymUsers.forEach((temp) -> {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(temp, userInfoVo);
                if (judge.equals("0")) {
                    userInfoVo.setFansState(true);
                    userInfoVo.setFollowState(key.containsKey(temp.getUserId() + "::" + userId));
                }

                if (judge.equals("1")) {
                    userInfoVo.setFansState(key.containsKey(userId + "::" + temp.getUserId()));
                    userInfoVo.setFollowState(true);
                }

                userInfoVo.setId((Integer) queryUserId.get(temp.getUserId()));
                userInfoVos.add(userInfoVo);
            });
            BeanUtils.copyProperties(ymFansIPages, userInfoVoPage);
            userInfoVoPage.setRecords(userInfoVos);
            return userInfoVoPage;
        }
    }

    public boolean deleteAnswerFans(YmFans fans) {
        QueryWrapper<YmFans> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", fans.getUserId()).eq("answer_user_id", fans.getAnswerUserId());
        int delete = this.baseMapper.delete(wrapper);

        if (delete != 1) {
            throw new YmException(ExecutionResult.DATA_CODE_302);
        }

        return this.userService.updateFansNum(fans.getAnswerUserId(), 2);

    }

    public boolean selectAnswerFans(UserFansVo userFansVo) {
        QueryWrapper<YmFans> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userFansVo.getUserId()).eq("answer_user_id", userFansVo.getAnswerUserId());
        YmFans fans = this.baseMapper.selectOne(wrapper);
        return fans != null;
    }

    public int removeSoftDeleted() {
        return this.baseMapper.deleteFansData();
    }

    public Page<UserInfoVo> fuzzyQueryFans(String judge, String userId, String content, Integer page) {
        Map<String, Object> key = new HashMap<>();
        Map<String, Object> queryUserId = new HashMap<>();
        Page<UserInfoVo> userInfoVoPage = new Page<>();
        List<String> collect;
        if (judge.equals("0")) {
            List<YmFans> fansList = this.lambdaQuery().eq(YmFans::getAnswerUserId, userId).list();
            List<YmFans> list = this.lambdaQuery().eq(YmFans::getUserId, userId).eq(YmFans::getIsDeleted, "0").list();
            collect = list.stream().map(YmFans::getAnswerUserId).collect(Collectors.toList());
        } else {
            List<YmFans> fansList = this.lambdaQuery().eq(YmFans::getUserId, userId).list();
            List<YmFans> list = this.lambdaQuery().eq(YmFans::getAnswerUserId, userId).eq(YmFans::getIsDeleted, "0").list();
            collect = list.stream().map(YmFans::getUserId).collect(Collectors.toList());
        }

        if (collect.isEmpty()) {
            return userInfoVoPage;
        }

        Page<YmUser> ymUserPage = this.userService.lambdaQuery().in(YmUser::getUserId, collect).page(new Page((long) page, 10L));
        List<YmQueryUser> queryUserList = this.baseMapper.queryUserId(collect);
        queryUserList.forEach((temp) -> queryUserId.put(temp.getUserId(), temp.getQueryId()));
        List<YmFans> likeEachOther;
        if (judge.equals("0")) {
            likeEachOther = this.lambdaQuery().in(YmFans::getUserId, ymUserPage.getRecords().stream().map(YmUser::getUserId).collect(Collectors.toList())).list();
        } else {
            likeEachOther = this.lambdaQuery().in(YmFans::getAnswerUserId, ymUserPage.getRecords().stream().map(YmUser::getUserId).collect(Collectors.toList())).list();
        }

        likeEachOther.forEach((temp) -> key.put(temp.getUserId() + "::" + temp.getAnswerUserId(), 0));
        ArrayList<UserInfoVo> userInfoVos = new ArrayList<>();
        if (judge.equals("0")) {
            ymUserPage.getRecords().forEach((temp) -> {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(temp, userInfoVo);
                userInfoVo.setFansState(true);
                userInfoVo.setFollowState(key.containsKey(userId + "::" + temp.getUserId()));
                userInfoVo.setId((Integer) queryUserId.get(temp.getUserId()));
                userInfoVos.add(userInfoVo);
            });
        } else {
            ymUserPage.getRecords().forEach((temp) -> {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(temp, userInfoVo);
                userInfoVo.setFansState(key.containsKey(userId + "::" + temp.getUserId()));
                userInfoVo.setFollowState(key.containsKey(userId + "::" + temp.getUserId()));
                userInfoVo.setId((Integer) queryUserId.get(temp.getUserId()));
                userInfoVos.add(userInfoVo);
            });
        }

        List<UserInfoVo> collect1 = userInfoVos.stream().filter((temp) -> {
            String regEx = "[" + content + "]";
            Pattern c = Pattern.compile(regEx);
            Matcher mc = c.matcher(temp.getUserName());
            String result = mc.replaceAll("").trim();
            return temp.getUserName().length() != result.length();
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(ymUserPage, userInfoVoPage);
        userInfoVoPage.setRecords(collect1);
        userInfoVoPage.setSize(10L);
        return userInfoVoPage;

    }

    public boolean getOneFans(String userId, String id) {
        YmFans fans = this.baseMapper.getOneFans(userId, id);
        return fans.getIsDeleted().equals("0");
    }

    public boolean addFollow(String userId, String id) {
        YmFans fans = this.baseMapper.getOneFans(userId, id);
        if (fans == null) {
            fans = new YmFans();
            fans.setUserId(userId);
            fans.setAnswerUserId(id);
            return this.save(fans);
        }

        switch (fans.getIsDeleted()) {
            case "0":
                this.baseMapper.attention(fans.getFansId());
                return true;
            case "1":
                this.baseMapper.noAttention(fans.getFansId());
                return true;
            default:
                return false;
        }
    }

    public String attentionUser(String userId, String id) {
        if (userId.equals(id)) {
            return "操作失败";
        }

        YmFans ymFans = this.lambdaQuery().eq(YmFans::getAnswerUserId, id).eq(YmFans::getUserId, userId).one();
        if (ymFans == null) {
            ymFans = new YmFans();
            ymFans.setAnswerUserId(id);
            ymFans.setUserId(userId);
            this.save(ymFans);
            this.userService.lambdaUpdate().eq(YmUser::getUserId, id).setSql("fans_num = fans_num+1").update();
            return "操作成功";
        }

        if (ymFans.getIsDeleted().equals("0")) {

            boolean fansUpdated = this.lambdaUpdate()
                    .eq(YmFans::getUserId, userId)
                    .eq(YmFans::getAnswerUserId, id)
                    .eq(YmFans::getIsDeleted, "0")
                    .set(YmFans::getIsDeleted, "1")
                    .update();

            boolean userUpdated = this.userService.lambdaUpdate()
                    .eq(YmUser::getUserId, id)
                    .setSql("fans_num = fans_num - 1") // 使用 setSql 直接操作数据库，效率更高
                    .update();
        } else {
            boolean fansUpdated = this.lambdaUpdate()
                    .eq(YmFans::getUserId, userId)
                    .eq(YmFans::getAnswerUserId, id)
                    .eq(YmFans::getIsDeleted, "1")
                    .set(YmFans::getIsDeleted, "0")
                    .update();

            boolean userUpdated = this.userService.lambdaUpdate()
                    .eq(YmUser::getUserId, id)
                    .setSql("fans_num = fans_num + 1")
                    .update();
        }

        return "操作成功";

    }
}

