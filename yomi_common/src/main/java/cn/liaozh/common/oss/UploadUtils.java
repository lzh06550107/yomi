package cn.liaozh.common.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class UploadUtils {
    private static final Logger log = LoggerFactory.getLogger(UploadUtils.class);
    private static final String WINDOWS_PATH = "D:/home/yomi/";
    private static final String LINUX_PATH = "/opt/yomi/";
    private static String path;
    private static final String imgUrl = "https://campus.change.tm/img/";

    public UploadUtils() {
        String os = System.getProperty("os.name");
        boolean isWin = os.toLowerCase().startsWith("win");
        if (isWin) {
            path = "D:/home/yomi/";
        } else {
            path = "/opt/yomi/";
        }

    }

    public static String uploadFileAvatar(MultipartFile file) {
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try {
            OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;
            Date today = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String datePath = simpleDateFormat.format(today);
            fileName = datePath + "/" + fileName;
            ossClient.putObject(bucketName, fileName, inputStream);
            ossClient.shutdown();
            return "https://" + bucketName + "." + endpoint + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String uploadLocalFileAvatar(MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String uploadFileName = uuid + filename;
        String datePath = (new SimpleDateFormat("yyyy/MM/dd/")).format(new Date());
        File file = new File(path + datePath);

        try {
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    log.error("创建目录失败!");
                    return null;
                }
            }

            multipartFile.transferTo(new File(path + datePath + uploadFileName));
        } catch (IOException var7) {
            log.error("文件IO 异常!");
            return null;
        }

        return "https://campus.change.tm/img/" + datePath + uploadFileName;
    }

    public static boolean deleteImage(String urlPath) {
        String img = "/img/";
        int imgIndex = urlPath.indexOf(img);
        if (imgIndex == -1) {
            return true;
        } else {
            String pathForDate = urlPath.substring(imgIndex + img.length());
            return (new File(path + pathForDate)).delete();
        }
    }
}

