package cn.liaozh.service_base.enums;

public enum MsgType {
    LIKE("0", "点赞消息", ""),
    SYSTEM("1", "系统消息", ""),
    COMMENT("2", "评论消息", ""),
    MSG("3", "私信消息", "您有新的私信");

    private final String code;
    private final String info;
    private final String tips;

    private MsgType(String code, String info, String tips) {
        this.code = code;
        this.info = info;
        this.tips = tips;
    }

    public String getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public String getTips() {
        return this.tips;
    }
}

