package cn.liaozh.service.controller;

import cn.liaozh.common.nonEmptyJudgment.ObjectUtils;
import cn.liaozh.common.result.R;
import cn.liaozh.pojo.YmFans;
import cn.liaozh.pojo.vo.PageVo;
import cn.liaozh.pojo.vo.UserFansVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import cn.liaozh.service.service.YmFansService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping({"/ym_server/fans"})
public class YmFansController {
    @Resource
    private YmFansService fansService;

    @GetMapping({"query"})
    public R fuzzyQueryFans(String userId, @RequestParam("judge") String judge, @RequestParam("content") String content, @RequestParam("page") Integer page) {
        Page<UserInfoVo> list;
        if (ObjectUtils.isEmpty(content)) {
            list = this.fansService.selectFansList(userId, judge, page);
        } else {
            list = this.fansService.fuzzyQueryFans(judge, userId, content, page);
        }

        Map<String, Object> map = new HashMap();
        map.put("records", list.getRecords());
        map.put("total", list.getTotal());
        map.put("size", list.getSize());
        map.put("current", list.getCurrent());
        map.put("searchCount", list.searchCount());
        map.put("countId", list.countId());
        map.put("pages", list.getPages());
        return R.ok().data(map);
    }

    @GetMapping({"getOneFans"})
    public R getOneFans(String userId, @PathParam("id") String id) {
        boolean bol = this.fansService.getOneFans(userId, id);
        return R.ok().data("status", bol);
    }

    @PostMapping({"addFollow"})
    public R attentionUser(String userId, @PathParam("followUserId") String followUserId) {
        String result = this.fansService.attentionUser(userId, followUserId);
        boolean isSuccess = "操作成功".equals(result);
        return isSuccess ? R.ok() : R.error();
    }

    @PostMapping
    public R addFans(@RequestBody YmFans fans, String userId) {
        fans.setUserId(userId);
        boolean flag = this.fansService.insertFans(fans);
        return flag ? R.ok() : R.error().message("粉丝数更新失败");
    }

    @DeleteMapping
    public R deleteAnswerFans(@RequestBody YmFans fans, String userId) {
        fans.setUserId(userId);
        boolean flag = this.fansService.deleteAnswerFans(fans);
        return flag ? R.ok() : R.error();
    }

    @GetMapping({"queryAnswer/{userId}/{pageNum}"})
    public R getAnswerFansList(@PathVariable String userId, @PathVariable int pageNum) {
        PageVo answerFansList = this.fansService.selectFansList(userId, pageNum, "user_id");
        return R.ok().data("answerFansList", answerFansList);
    }

    @GetMapping({"answerFans/{answerUserId}"})
    public R getAnswerFans(String userId, @PathVariable String answerUserId) {
        UserFansVo userFansVo = new UserFansVo(userId, answerUserId);
        boolean flag = this.fansService.selectAnswerFans(userFansVo);
        return R.ok().data("fanState", flag);
    }

    @GetMapping({"query/{userId}/{pageNum}"})
    public R getFansList(@PathVariable String userId, @PathVariable int pageNum) {
        PageVo pageVo = this.fansService.selectFansList(userId, pageNum, "answer_user_id");
        return R.ok().data("list", pageVo);
    }
}

