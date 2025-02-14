package cn.liaozh.service_base.enums;

public enum ContentType {
    ARTICLE("0", "文章"),
    GOODS("1", "商品");

    private final String code;
    private final String info;

    private ContentType(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }
}
