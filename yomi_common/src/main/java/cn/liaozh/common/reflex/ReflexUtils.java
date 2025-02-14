package cn.liaozh.common.reflex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Objects;

public class ReflexUtils {
    private static final Logger log = LoggerFactory.getLogger(ReflexUtils.class);

    public ReflexUtils() {
    }

    public static boolean checkObjFieldIsNull(Objects obj) {
        for(Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            log.info(f.getName());

            try {
                if (f.get(obj) == null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
