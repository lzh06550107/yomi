package cn.liaozh.common.file;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
    public FileUtils() {
    }

    public static String getSuffix(MultipartFile file) {
        String file_name = file.getOriginalFilename();
        return file_name != null ? file_name.substring(file_name.lastIndexOf(".")) : null;
    }
}
