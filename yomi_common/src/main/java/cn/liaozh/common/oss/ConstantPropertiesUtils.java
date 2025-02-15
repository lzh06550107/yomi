package cn.liaozh.common.oss;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    public ConstantPropertiesUtils() {
    }

    public void afterPropertiesSet() throws Exception {
        END_POINT = this.endpoint;
        ACCESS_KEY_ID = this.keyId;
        ACCESS_KEY_SECRET = this.keySecret;
        BUCKET_NAME = this.bucketName;
    }
}
