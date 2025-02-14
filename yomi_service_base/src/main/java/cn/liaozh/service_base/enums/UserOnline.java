package cn.liaozh.service_base.enums;

public enum UserOnline {
    ONLINE("0", "用户在线"),
    OFFLINE("1", "用户离线");

    private final String code;
    private final String info;

    private UserOnline(String code, String info) {
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
        for(UserOnline type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static UserOnline getByCode(String code) {
        for(UserOnline type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}

