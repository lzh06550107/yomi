package cn.liaozh.service.enums;

public enum SearchFriendsStatusEnum {
    SUCCESS(0, "OK"),
    USER_NOT_EXIST(1, "无此用户..."),
    NOT_YOURSELF(2, "不能添加你自己..."),
    ALREADY_FRIENDS(3, "该用户已经是你的好友...");

    public final Integer status;
    public final String msg;

    private SearchFriendsStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return this.status;
    }

    public static String getMsgByKey(Integer status) {
        for(SearchFriendsStatusEnum type : values()) {
            if (type.getStatus() == status) {
                return type.msg;
            }
        }

        return null;
    }
}
