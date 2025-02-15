package cn.liaozh.service.controller;

import cn.liaozh.common.oss.UploadUtils;
import cn.liaozh.common.request.RequestUtils;
import cn.liaozh.common.result.R;
import cn.liaozh.service.service.ImgUploadService;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping({"/ym_server/common"})
@CrossOrigin
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    @Resource
    private ImgUploadService imgUploadService;

    @PostMapping({"upload-file"})
    public R uploadFile(MultipartFile file) {
        return R.ok().data("url", this.imgUploadService.commonUpload(file, 12));
    }

    @PostMapping({"delete-file"})
    public R deleteFile(String userId, @RequestBody String urlPath) {
        if (Objects.isNull(userId)) {
            throw new YmException(ExecutionResult.USER_CODE_103);
        }

        String url = JSON.parseObject(urlPath).getString("url");
        boolean isDeleted = UploadUtils.deleteImage(url);
        return isDeleted ? R.ok() : R.error();

    }

    @GetMapping({"bili-fans"})
    public R getBiliFans() {
        String uid = "418417029";
        JSONObject urlResult = RequestUtils.getUrlResult("https://api.bilibili.com/x/relation/stat?vmid=" + uid);
        return R.ok().data("fansNum", urlResult.getJSONObject("data").getLong("follower"));
    }
}
