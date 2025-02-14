package cn.liaozh.service.service.impl;

import cn.liaozh.common.oss.UploadUtils;
import cn.liaozh.service.service.ImgUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImgUploadServiceImpl implements ImgUploadService {
    public ImgUploadServiceImpl() {
    }

    public String commonUpload(MultipartFile file, int imgSize) {
        return UploadUtils.uploadLocalFileAvatar(file);
    }

    public List<String> commonUpload(MultipartFile[] file, int imgSize) {
        List<String> list = new ArrayList();

        for(MultipartFile multipartFile : file) {
            list.add(UploadUtils.uploadLocalFileAvatar(multipartFile));
        }

        return list;
    }
}
