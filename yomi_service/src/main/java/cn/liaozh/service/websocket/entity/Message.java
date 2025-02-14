package cn.liaozh.service.websocket.entity;

import cn.liaozh.service.websocket.enumType.MsgEnumType;

public class Message {
    private String userId;
    private String userName;
    private String avatar;
    private String toUserId;
    private String toUserName;
    private String toUserAvatar;
    private MsgEnumType msgType;
    private String msgChatId;
    private String content;

    public Message() {
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getToUserId() {
        return this.toUserId;
    }

    public String getToUserName() {
        return this.toUserName;
    }

    public String getToUserAvatar() {
        return this.toUserAvatar;
    }

    public MsgEnumType getMsgType() {
        return this.msgType;
    }

    public String getMsgChatId() {
        return this.msgChatId;
    }

    public String getContent() {
        return this.content;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public void setToUserId(final String toUserId) {
        this.toUserId = toUserId;
    }

    public void setToUserName(final String toUserName) {
        this.toUserName = toUserName;
    }

    public void setToUserAvatar(final String toUserAvatar) {
        this.toUserAvatar = toUserAvatar;
    }

    public void setMsgType(final MsgEnumType msgType) {
        this.msgType = msgType;
    }

    public void setMsgChatId(final String msgChatId) {
        this.msgChatId = msgChatId;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Message)) {
            return false;
        } else {
            Message other = (Message)o;
            if (!other.canEqual(this)) {
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

                Object this$userName = this.getUserName();
                Object other$userName = other.getUserName();
                if (this$userName == null) {
                    if (other$userName != null) {
                        return false;
                    }
                } else if (!this$userName.equals(other$userName)) {
                    return false;
                }

                Object this$avatar = this.getAvatar();
                Object other$avatar = other.getAvatar();
                if (this$avatar == null) {
                    if (other$avatar != null) {
                        return false;
                    }
                } else if (!this$avatar.equals(other$avatar)) {
                    return false;
                }

                Object this$toUserId = this.getToUserId();
                Object other$toUserId = other.getToUserId();
                if (this$toUserId == null) {
                    if (other$toUserId != null) {
                        return false;
                    }
                } else if (!this$toUserId.equals(other$toUserId)) {
                    return false;
                }

                Object this$toUserName = this.getToUserName();
                Object other$toUserName = other.getToUserName();
                if (this$toUserName == null) {
                    if (other$toUserName != null) {
                        return false;
                    }
                } else if (!this$toUserName.equals(other$toUserName)) {
                    return false;
                }

                Object this$toUserAvatar = this.getToUserAvatar();
                Object other$toUserAvatar = other.getToUserAvatar();
                if (this$toUserAvatar == null) {
                    if (other$toUserAvatar != null) {
                        return false;
                    }
                } else if (!this$toUserAvatar.equals(other$toUserAvatar)) {
                    return false;
                }

                Object this$msgType = this.getMsgType();
                Object other$msgType = other.getMsgType();
                if (this$msgType == null) {
                    if (other$msgType != null) {
                        return false;
                    }
                } else if (!this$msgType.equals(other$msgType)) {
                    return false;
                }

                Object this$msgChatId = this.getMsgChatId();
                Object other$msgChatId = other.getMsgChatId();
                if (this$msgChatId == null) {
                    if (other$msgChatId != null) {
                        return false;
                    }
                } else if (!this$msgChatId.equals(other$msgChatId)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Message;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $avatar = this.getAvatar();
        result = result * 59 + ($avatar == null ? 43 : $avatar.hashCode());
        Object $toUserId = this.getToUserId();
        result = result * 59 + ($toUserId == null ? 43 : $toUserId.hashCode());
        Object $toUserName = this.getToUserName();
        result = result * 59 + ($toUserName == null ? 43 : $toUserName.hashCode());
        Object $toUserAvatar = this.getToUserAvatar();
        result = result * 59 + ($toUserAvatar == null ? 43 : $toUserAvatar.hashCode());
        Object $msgType = this.getMsgType();
        result = result * 59 + ($msgType == null ? 43 : $msgType.hashCode());
        Object $msgChatId = this.getMsgChatId();
        result = result * 59 + ($msgChatId == null ? 43 : $msgChatId.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "Message(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", avatar=" + this.getAvatar() + ", toUserId=" + this.getToUserId() + ", toUserName=" + this.getToUserName() + ", toUserAvatar=" + this.getToUserAvatar() + ", msgType=" + this.getMsgType() + ", msgChatId=" + this.getMsgChatId() + ", content=" + this.getContent() + ")";
    }
}

