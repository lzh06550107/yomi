package cn.liaozh.service.enums;

public enum OperatorFriendRequestTypeEnum {
    IGNORE(0, "忽略"),
    PASS(1, "通过");

    public final Integer type;
    public final String msg;

    private OperatorFriendRequestTypeEnum(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public Integer getType() {
        return this.type;
    }

    public static String getMsgByType(Integer type) {
        for(OperatorFriendRequestTypeEnum operType : values()) {
            if (operType.getType() == type) {
                return operType.msg;
            }
        }

        return null;
    }
}
