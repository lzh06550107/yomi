package cn.liaozh.service_base.handler;

import cn.liaozh.common.result.R;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.exception.YmException;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error();
    }

    @ExceptionHandler({YmException.class})
    @ResponseBody
    public R error(YmException e) {
        ExecutionResult executionResult = e.getExecutionResult();
        return R.error().code(executionResult.getCode()).message(executionResult.getInfo());
    }

    @ExceptionHandler({SignatureVerificationException.class})
    @ResponseBody
    public R error(SignatureVerificationException e) {
        return R.error().code(ExecutionResult.USER_CODE_104.getCode()).message(ExecutionResult.USER_CODE_104.getInfo());
    }

    @ExceptionHandler({TokenExpiredException.class})
    @ResponseBody
    public R error(TokenExpiredException e) {
        return R.error().code(ExecutionResult.USER_CODE_105.getCode()).message(ExecutionResult.USER_CODE_105.getInfo());
    }

    @ExceptionHandler({AlgorithmMismatchException.class})
    @ResponseBody
    public R error(AlgorithmMismatchException e) {
        return R.error().code(ExecutionResult.USER_CODE_106.getCode()).message(ExecutionResult.USER_CODE_106.getInfo());
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public R HttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.info("你的参数不正确");
        String error = "参数转换失败，方法：" + (String) Objects.requireNonNull(e.getMethod()) + ",期望参数类型：" + e.getSupportedHttpMethods();
        return R.error().code(405).message("参数不匹配").data("data", error);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public R httpMessageNotReadable(HttpMessageNotReadableException e) {
        return R.error().code(405).message("参数不匹配").data("data", "json转化异常");
    }
}

