package cn.liaozh.service_base.enums;

public enum CommentType {
    TEXT_COMMENT("0", "文本评论"),
    IMG_COMMENT("1", "图片评论");

    private final String code;
    private final String info;

    private CommentType(String code, String info) {
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
        for(CommentType type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static CommentType getByCode(String code) {
        for(CommentType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
