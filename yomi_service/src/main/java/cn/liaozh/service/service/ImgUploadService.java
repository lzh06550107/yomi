package cn.liaozh.service.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImgUploadService {

    String commonUpload(MultipartFile file, int imgSize);

    List<String> commonUpload(MultipartFile[] file, int imgSize);
}
