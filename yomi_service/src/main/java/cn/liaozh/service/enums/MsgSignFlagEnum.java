package cn.liaozh.service.enums;

public enum MsgSignFlagEnum {
    unsign(0, "未签收"),
    signed(1, "已签收");

    public final Integer type;
    public final String content;

    private MsgSignFlagEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return this.type;
    }
}

