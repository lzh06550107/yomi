package cn.liaozh.service.interceptor;

import cn.liaozh.common.request.HttpHelper;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

public class RequestWrapper extends HttpServletRequestWrapper {
    private final byte[] body;
    Map<String, String[]> params;

    public RequestWrapper(HttpServletRequest request, Map<String, String[]> newParams) {
        super(request);
        this.body = HttpHelper.getBodyString(request).getBytes(StandardCharsets.UTF_8);
        this.params = newParams;
        this.renewParameterMap(request);
    }

    public String getParameter(String name) {
        Object v = this.params.get(name);
        String result;
        if (v == null) {
            result = null;
        } else {
            String[] strArr = (String[])v;
            if (strArr.length > 0) {
                result = strArr[0];
            } else {
                result = null;
            }
        }

        return result;
    }

    public Map<String, String[]> getParameterMap() {
        return this.params;
    }

    public Enumeration<String> getParameterNames() {
        return (new Vector(this.params.keySet())).elements();
    }

    public String[] getParameterValues(String name) {
        Object v = this.params.get(name);
        String[] result;
        if (v == null) {
            result = null;
        } else {
            result = (String[])v;
        }

        return result;
    }

    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    private void renewParameterMap(HttpServletRequest req) {
        String queryString = req.getQueryString();
        if (queryString != null && queryString.trim().length() > 0) {
            String[] params = queryString.split("&");

            for(String param : params) {
                int splitIndex = param.indexOf("=");
                if (splitIndex != -1) {
                    String key = param.substring(0, splitIndex);
                    if (!this.params.containsKey(key)) {
                        String value = param.substring(splitIndex + 1);
                        this.params.put(key, new String[]{value});
                    }
                }
            }
        }

    }

    public ServletInputStream getInputStream() {
        final ByteArrayInputStream bais = new ByteArrayInputStream(this.body);
        return new ServletInputStream() {
            public boolean isFinished() {
                return false;
            }

            public boolean isReady() {
                return false;
            }

            public void setReadListener(ReadListener listener) {
            }

            public int read() {
                return bais.read();
            }
        };
    }
}
