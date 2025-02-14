package cn.liaozh.service_base.enums;

public enum UserDisabled {
    ENABLE("0", "用户启用"),
    DISABLE("1", "用户禁用");

    private final String code;
    private final String info;

    private UserDisabled(String code, String info) {
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
        for(UserDisabled type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static UserDisabled getByCode(String code) {
        for(UserDisabled type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}

