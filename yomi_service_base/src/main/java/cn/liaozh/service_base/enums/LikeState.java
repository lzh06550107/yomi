package cn.liaozh.service_base.enums;

public enum LikeState {
    LIKE("0", "已经点赞"),
    CANCEL("1", "取消点赞");

    private final String code;
    private final String info;

    private LikeState(String code, String info) {
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
        for(LikeState type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static LikeState getByCode(String code) {
        for(LikeState type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
