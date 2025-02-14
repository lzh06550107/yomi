package cn.liaozh.pojo.vo;

public class MsgChatVo {
    private Integer unreadNum = 0;
    private String msg = "";
    private String type;

    public Integer getUnreadNum() {
        return this.unreadNum;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getType() {
        return this.type;
    }

    public MsgChatVo setUnreadNum(final Integer unreadNum) {
        this.unreadNum = unreadNum;
        return this;
    }

    public MsgChatVo setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public MsgChatVo setType(final String type) {
        this.type = type;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MsgChatVo)) {
            return false;
        } else {
            MsgChatVo other = (MsgChatVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$unreadNum = this.getUnreadNum();
                Object other$unreadNum = other.getUnreadNum();
                if (this$unreadNum == null) {
                    if (other$unreadNum != null) {
                        return false;
                    }
                } else if (!this$unreadNum.equals(other$unreadNum)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
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
        return other instanceof MsgChatVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $unreadNum = this.getUnreadNum();
        result = result * 59 + ($unreadNum == null ? 43 : $unreadNum.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "MsgChatVo(unreadNum=" + this.getUnreadNum() + ", msg=" + this.getMsg() + ", type=" + this.getType() + ")";
    }

    public MsgChatVo(final Integer unreadNum, final String msg, final String type) {
        this.unreadNum = unreadNum;
        this.msg = msg;
        this.type = type;
    }

    public MsgChatVo() {
    }
}
