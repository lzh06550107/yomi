package cn.liaozh.pojo;

import cn.liaozh.pojo.vo.OperObjVo;
import cn.liaozh.pojo.vo.UserInfoVo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class YmChatMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(
            value = "id",
            type = IdType.ASSIGN_ID
    )
    private String id;
    private String sendUserId;
    private String acceptUserId;
    private String msg;
    private String image;
    private String signFlag;
    @ApiModelProperty("创建时间")
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;
    @ApiModelProperty("修改时间")
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateTime;
    private String type;
    @TableField(
            exist = false
    )
    private UserInfoVo sendUser;
    @TableField(
            exist = false
    )
    private OperObjVo operObj;
    @TableField(
            exist = false
    )
    private String tips;
    @TableField(
            exist = false
    )
    private String content;

    public YmChatMsg() {
    }

    public String getId() {
        return this.id;
    }

    public String getSendUserId() {
        return this.sendUserId;
    }

    public String getAcceptUserId() {
        return this.acceptUserId;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getImage() {
        return this.image;
    }

    public String getSignFlag() {
        return this.signFlag;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getType() {
        return this.type;
    }

    public UserInfoVo getSendUser() {
        return this.sendUser;
    }

    public OperObjVo getOperObj() {
        return this.operObj;
    }

    public String getTips() {
        return this.tips;
    }

    public String getContent() {
        return this.content;
    }

    public YmChatMsg setId(final String id) {
        this.id = id;
        return this;
    }

    public YmChatMsg setSendUserId(final String sendUserId) {
        this.sendUserId = sendUserId;
        return this;
    }

    public YmChatMsg setAcceptUserId(final String acceptUserId) {
        this.acceptUserId = acceptUserId;
        return this;
    }

    public YmChatMsg setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public YmChatMsg setImage(final String image) {
        this.image = image;
        return this;
    }

    public YmChatMsg setSignFlag(final String signFlag) {
        this.signFlag = signFlag;
        return this;
    }

    public YmChatMsg setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public YmChatMsg setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public YmChatMsg setType(final String type) {
        this.type = type;
        return this;
    }

    public YmChatMsg setSendUser(final UserInfoVo sendUser) {
        this.sendUser = sendUser;
        return this;
    }

    public YmChatMsg setOperObj(final OperObjVo operObj) {
        this.operObj = operObj;
        return this;
    }

    public YmChatMsg setTips(final String tips) {
        this.tips = tips;
        return this;
    }

    public YmChatMsg setContent(final String content) {
        this.content = content;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmChatMsg)) {
            return false;
        } else {
            YmChatMsg other = (YmChatMsg)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$sendUserId = this.getSendUserId();
                Object other$sendUserId = other.getSendUserId();
                if (this$sendUserId == null) {
                    if (other$sendUserId != null) {
                        return false;
                    }
                } else if (!this$sendUserId.equals(other$sendUserId)) {
                    return false;
                }

                Object this$acceptUserId = this.getAcceptUserId();
                Object other$acceptUserId = other.getAcceptUserId();
                if (this$acceptUserId == null) {
                    if (other$acceptUserId != null) {
                        return false;
                    }
                } else if (!this$acceptUserId.equals(other$acceptUserId)) {
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

                Object this$image = this.getImage();
                Object other$image = other.getImage();
                if (this$image == null) {
                    if (other$image != null) {
                        return false;
                    }
                } else if (!this$image.equals(other$image)) {
                    return false;
                }

                Object this$signFlag = this.getSignFlag();
                Object other$signFlag = other.getSignFlag();
                if (this$signFlag == null) {
                    if (other$signFlag != null) {
                        return false;
                    }
                } else if (!this$signFlag.equals(other$signFlag)) {
                    return false;
                }

                Object this$createTime = this.getCreateTime();
                Object other$createTime = other.getCreateTime();
                if (this$createTime == null) {
                    if (other$createTime != null) {
                        return false;
                    }
                } else if (!this$createTime.equals(other$createTime)) {
                    return false;
                }

                Object this$updateTime = this.getUpdateTime();
                Object other$updateTime = other.getUpdateTime();
                if (this$updateTime == null) {
                    if (other$updateTime != null) {
                        return false;
                    }
                } else if (!this$updateTime.equals(other$updateTime)) {
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

                Object this$sendUser = this.getSendUser();
                Object other$sendUser = other.getSendUser();
                if (this$sendUser == null) {
                    if (other$sendUser != null) {
                        return false;
                    }
                } else if (!this$sendUser.equals(other$sendUser)) {
                    return false;
                }

                Object this$operObj = this.getOperObj();
                Object other$operObj = other.getOperObj();
                if (this$operObj == null) {
                    if (other$operObj != null) {
                        return false;
                    }
                } else if (!this$operObj.equals(other$operObj)) {
                    return false;
                }

                Object this$tips = this.getTips();
                Object other$tips = other.getTips();
                if (this$tips == null) {
                    if (other$tips != null) {
                        return false;
                    }
                } else if (!this$tips.equals(other$tips)) {
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
        return other instanceof YmChatMsg;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $sendUserId = this.getSendUserId();
        result = result * 59 + ($sendUserId == null ? 43 : $sendUserId.hashCode());
        Object $acceptUserId = this.getAcceptUserId();
        result = result * 59 + ($acceptUserId == null ? 43 : $acceptUserId.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $image = this.getImage();
        result = result * 59 + ($image == null ? 43 : $image.hashCode());
        Object $signFlag = this.getSignFlag();
        result = result * 59 + ($signFlag == null ? 43 : $signFlag.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        Object $updateTime = this.getUpdateTime();
        result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $sendUser = this.getSendUser();
        result = result * 59 + ($sendUser == null ? 43 : $sendUser.hashCode());
        Object $operObj = this.getOperObj();
        result = result * 59 + ($operObj == null ? 43 : $operObj.hashCode());
        Object $tips = this.getTips();
        result = result * 59 + ($tips == null ? 43 : $tips.hashCode());
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "YmChatMsg(id=" + this.getId() + ", sendUserId=" + this.getSendUserId() + ", acceptUserId=" + this.getAcceptUserId() + ", msg=" + this.getMsg() + ", image=" + this.getImage() + ", signFlag=" + this.getSignFlag() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ", type=" + this.getType() + ", sendUser=" + this.getSendUser() + ", operObj=" + this.getOperObj() + ", tips=" + this.getTips() + ", content=" + this.getContent() + ")";
    }
}
