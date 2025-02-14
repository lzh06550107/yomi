package cn.liaozh.service_base.enums;

public enum UserSex {
    MAN("2", "男"),
    WOMAN("1", "女"),
    SECRECY("0", "保密");

    private final String code;
    private final String info;

    private UserSex(String code, String info) {
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
        for(UserSex type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static UserSex getByCode(String code) {
        for(UserSex type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
