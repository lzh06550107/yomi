package cn.liaozh.service_base.enums;

public enum ArticleSpecial {
    NORMAL("0", "正常文章"),
    SPECIAL("1", "特殊文章");

    private final String code;
    private final String info;

    private ArticleSpecial(String code, String info) {
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
        for(ArticleSpecial type : values()) {
            if (type.getCode().equals(code)) {
                return type.getInfo();
            }
        }

        return null;
    }

    public static ArticleSpecial getByCode(String code) {
        for(ArticleSpecial type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }
}

