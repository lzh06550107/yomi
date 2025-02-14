package cn.liaozh.service_base.exception;

import cn.liaozh.common.result.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice({"cn.liaozh.service.controller"})
public class YmExceptionControllerAdvice {
    private static final Logger log = LoggerFactory.getLogger(YmExceptionControllerAdvice.class);

    public YmExceptionControllerAdvice() {
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public R handleVaildException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, String> errorMap = new HashMap();
        bindingResult.getFieldErrors().forEach((fieldError) -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        log.error("数据校验出现问题{}", e.getMessage());
        return R.error().code(401).message("提交数据不合法").data("data", errorMap);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public R handleBindGetException(ConstraintViolationException e) {
        Map<String, String> map = new HashMap();
        e.getConstraintViolations().forEach((temp) -> {
            PathImpl propertyPath = (PathImpl)temp.getPropertyPath();
            NodeImpl leafNode = propertyPath.getLeafNode();
            String name = leafNode.getName();
            String value = temp.getMessageTemplate();
            map.put(name, value);
        });
        return R.error().code(401).message("提交数据不合法").data("data", map);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public R mismatchErrorHandler(MethodArgumentTypeMismatchException e) {
        String errmsg = "参数转换失败，方法：" + ((Method) Objects.requireNonNull(e.getParameter().getMethod())).getName() + ",期望参数类型：" + e.getParameter().getParameterType() + ",参数：" + e.getName() + ",信息：" + e.getMessage();
        log.error(errmsg);
        return R.error().code(401).message("参数不匹配").data("data", errmsg);
    }
}
