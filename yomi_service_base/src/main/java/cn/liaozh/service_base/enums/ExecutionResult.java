package cn.liaozh.service_base.enums;

public enum ExecutionResult {
    USER_CODE_101(101, "该用户不存在"),
    USER_CODE_102(102, "该用户被禁用"),
    USER_CODE_103(103, "用户权限异常"),
    USER_CODE_104(104, "无效签名"),
    USER_CODE_105(105, "token过期"),
    USER_CODE_106(106, "token算法不一致"),
    USER_CODE_107(107, "无效token！"),
    USER_CODE_108(108, "两次密码不一致"),
    USER_CODE_109(109, "该用户已注册"),
    USER_CODE_110(110, "密码错误"),
    USER_CODE_111(111, "您的密码不能少于6位！"),
    DATA_CODE_301(301, "添加数据失败"),
    DATA_CODE_302(302, "修改数据失败"),
    DATA_CODE_303(303, "删除数据失败"),
    DATA_CODE_304(304, "数据过大"),
    DATA_CODE_305(305, "文件类型错误"),
    REQUEST_CODE_401(401, "请求参数异常"),
    CAPTCHA_CODE_402(402, "验证码错误"),
    CAPTCHA_CODE_403(403, "验证码已过期"),
    CAPTCHA_CODE_404(404, "三分钟后可以重新申请验证码"),
    DATA_CODE_400(400, "阅读量增加异常"),
    ARTICLE_CODE_405(405, "内容包含敏感词"),
    NUMBER_CODE_406(406, "请填写正确的学号/姓名/系别"),
    LIKE_CODE_501(501, "你已经点过赞了"),
    AUTH_CODE_601(601, "用户未认证"),
    AUTH_CODE_602(602, "该信息已被其他用户认证"),
    AUTH_CODE_603(603, "您已经认证过"),
    COMMIT_CODE_701(701, "请勿频繁操作");

    private final Integer code;
    private final String info;

    private ExecutionResult(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public static String getInfo(Integer code) {
        for(ExecutionResult type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static ExecutionResult getByCode(Integer code) {
        for(ExecutionResult type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
