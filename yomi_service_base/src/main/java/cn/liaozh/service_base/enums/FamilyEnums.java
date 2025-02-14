package cn.liaozh.service_base.enums;

public enum FamilyEnums {
    RECOMMEND("0", "综合推荐"),
    ATTENTION("1", "关注");

    private final String code;
    private final String info;

    private FamilyEnums(String code, String info) {
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
        for(FamilyEnums type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static FamilyEnums getByCode(String code) {
        for(FamilyEnums type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
