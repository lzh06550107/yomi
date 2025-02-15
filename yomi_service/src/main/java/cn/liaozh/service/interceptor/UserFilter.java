package cn.liaozh.service.interceptor;

import cn.liaozh.common.jwt.JwtUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class UserFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(UserFilter.class);

    public UserFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
//        super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Map<String, String[]> paramMap = new HashMap(request.getParameterMap());
        String token = httpRequest.getHeader("token");
        if (token == null) {
            chain.doFilter(request, response);
        } else {
            logger.info("传递修改后的 request");
            String userId = JwtUtil.getUserIdByToken(token);
            paramMap.put("userId", new String[]{String.valueOf(userId)});
            RequestWrapper parameterRequestWrapper = new RequestWrapper(httpRequest, paramMap);
            chain.doFilter(parameterRequestWrapper, response);
        }

    }

    public void destroy() {
//        super.destroy();
    }
}
