package cn.liaozh.service.interceptor;

import cn.liaozh.common.jwt.JwtUtil;
import cn.liaozh.common.request.HttpHelper;
import cn.liaozh.common.request.RequestUtils;
import cn.liaozh.pojo.Record;
import cn.liaozh.service.service.RecordService;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class YmInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(YmInterceptor.class);
    @Autowired
    private RecordService recordService;

    public YmInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getRequestURI().contains("bili-fans")) {
            return true;
        } else {
            String token;
            try {
                token = request.getHeader("token");
                JwtUtil.checkToken(token);
            } catch (SignatureVerificationException var13) {
                throw new YmException(ExecutionResult.USER_CODE_104);
            } catch (TokenExpiredException var14) {
                throw new YmException(ExecutionResult.USER_CODE_105);
            } catch (AlgorithmMismatchException var15) {
                throw new YmException(ExecutionResult.USER_CODE_106);
            } catch (JWTDecodeException var16) {
                throw new YmException(ExecutionResult.USER_CODE_107);
            }

            String userId = JwtUtil.getUserIdByToken(token);
            Map<String, Object> paramMap = HttpHelper.getParamMap(request);
            String jsonData = HttpHelper.getBodyString(request);
            String operParam;
            if (!jsonData.isEmpty() && paramMap != null) {
                operParam = jsonData + ";" + paramMap;
            } else if (!jsonData.equals("")) {
                operParam = jsonData;
            } else {
                operParam = String.valueOf(paramMap);
            }

            Record record = new Record();
            String ipAddress = RequestUtils.getIpAddress(request);
            record.setUserId(userId);
            record.setMethod(request.getRequestURI());
            record.setRequestMethod(request.getMethod());
            record.setOperIp(ipAddress);
            record.setOperParam(operParam);
            log.info(String.valueOf(record));

            try {
                this.recordService.save(record);
                return true;
            } catch (Exception var12) {
                throw new YmException(ExecutionResult.DATA_CODE_301);
            }
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
