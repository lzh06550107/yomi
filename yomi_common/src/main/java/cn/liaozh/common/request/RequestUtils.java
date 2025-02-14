package cn.liaozh.common.request;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RequestUtils {
    private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

    public RequestUtils() {
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip != null && ip.contains(",")) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }

        return ip;
    }

    public static JSONObject getUrlResult(String url) {
        String res = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(5000).setRedirectsEnabled(false).build();
        httpget.setConfig(requestConfig);

        try {
            CloseableHttpResponse response = httpClient.execute(httpget);
            HttpEntity responseEntity = response.getEntity();
            log.info("响应url>>" + url);
            log.info("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                res = EntityUtils.toString(responseEntity);
                log.info("响应内容长度为:" + responseEntity.getContentLength());
                log.info("响应内容为:" + res);
            }

            httpClient.close();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JSON.parseObject(res);
    }

    public static String getUserIdInRequest(HttpServletRequest request) {
        String userId = null;
        Map<String, Object> paramMap = HttpHelper.getParamMap(request);
        if (paramMap != null) {
            userId = (String)paramMap.get("userId");
        }

        String jsonData = HttpHelper.getBodyString(request);
        if (userId == null && jsonData.contains("userId")) {
            JSONObject jsonObj = JSONObject.parseObject(jsonData);
            userId = jsonObj.getString("userId");
        }

        return userId;
    }

    public static String sendPost(String url, JSONObject jsonObject) {
        String content = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        StringEntity s = new StringEntity(jsonObject.toJSONString(), StandardCharsets.UTF_8);
        s.setContentEncoding(StandardCharsets.UTF_8.name());
        s.setContentType("application/json");
        httpPost.setEntity(s);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((response != null ? response.getStatusLine().getStatusCode() : 0) == 200) {
            try {
                content = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("POST请求响应体为>>>>>>>" + content);
        return content;
    }
}

