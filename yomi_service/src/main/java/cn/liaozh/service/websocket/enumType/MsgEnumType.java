package cn.liaozh.service.websocket.enumType;

public enum MsgEnumType {
    SYSTEM("0", "系统通知"),
    LIKE_ARTICLE("1", "点赞文章通知"),
    COMMENT_ARTICLE("2", "评论文章通知"),
    LIKE_ARTICLE_COMMENT("3", "点赞文章评论通知"),
    LIKE_GOODS("4", "点赞商品通知"),
    COMMENT_GOODS("5", "评论商品通知"),
    LIKE_GOODS_COMMENT("6", "点赞商品评论通知"),
    COMMENT_TO_COMMENT("7", "评论回复评论"),
    USER_SEND_MSG("8", "私信");

    public final String type;
    public final String content;

    private MsgEnumType(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return this.type;
    }

    public static MsgEnumType getByCode(String code) {
        for(MsgEnumType type : values()) {
            if (type.getType().equals(code)) {
                return type;
            }
        }

        return null;
    }
}
