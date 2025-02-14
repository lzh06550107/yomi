package cn.liaozh.service_base.enums;

public enum UserNotice {
    OPEN("0", "推送开启"),
    CLOSE("1", "推送关闭");

    private final String code;
    private final String info;

    private UserNotice(String code, String info) {
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
        for(UserNotice type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static UserNotice getByCode(String code) {
        for(UserNotice type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
