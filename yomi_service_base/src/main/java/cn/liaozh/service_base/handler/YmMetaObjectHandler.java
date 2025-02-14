package cn.liaozh.service_base.handler;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import cn.liaozh.common.time.TimeUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class YmMetaObjectHandler implements MetaObjectHandler {
    private static final Logger log = LoggerFactory.getLogger(YmMetaObjectHandler.class);

    public YmMetaObjectHandler() {
    }

    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", TimeUtils.getTime(), metaObject);
        this.setFieldValByName("updateTime", TimeUtils.getTime(), metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", TimeUtils.getTime(), metaObject);
    }
}
