package cn.liaozh.service_base.enums;

public enum AppIsDel {
    NOT_DELETE("0", "未删除"),
    DELETED("1", "已删除");

    private final String code;
    private final String info;

    private AppIsDel(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public static String getInfo(String code) {
        for(AppIsDel type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static AppIsDel getByCode(String code) {
        for(AppIsDel type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
