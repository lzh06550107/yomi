package cn.liaozh.service.websocket.entity;

public class UnreadMessages {
    private String userId;
    private String type = "UnreadMessages";
    private long msgNum;

    public UnreadMessages() {
    }

    public String getUserId() {
        return this.userId;
    }

    public String getType() {
        return this.type;
    }

    public long getMsgNum() {
        return this.msgNum;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setMsgNum(final long msgNum) {
        this.msgNum = msgNum;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UnreadMessages)) {
            return false;
        } else {
            UnreadMessages other = (UnreadMessages)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getMsgNum() != other.getMsgNum()) {
                return false;
            } else {
                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UnreadMessages;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $msgNum = this.getMsgNum();
        result = result * 59 + (int)($msgNum >>> 32 ^ $msgNum);
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "UnreadMessages(userId=" + this.getUserId() + ", type=" + this.getType() + ", msgNum=" + this.getMsgNum() + ")";
    }
}

