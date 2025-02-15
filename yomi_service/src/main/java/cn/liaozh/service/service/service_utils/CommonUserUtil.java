package cn.liaozh.service.service.service_utils;

import cn.liaozh.pojo.YmUser;
import cn.liaozh.service_base.enums.ExecutionResult;
import cn.liaozh.service_base.enums.UserDisabled;
import cn.liaozh.service_base.exception.YmException;

public class CommonUserUtil {

    public static YmUser verificationUser(YmUser user) {
        boolean nullFlag = user == null;
        if (nullFlag) {
            throw new YmException(ExecutionResult.USER_CODE_101);
        } else {
            boolean disabledFlag = UserDisabled.DISABLE.getCode().equals(user.getIsDisabled());
            if (disabledFlag) {
                throw new YmException(ExecutionResult.USER_CODE_102);
            } else {
                return user;
            }
        }
    }
}
