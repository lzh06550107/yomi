package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserVo {

    private String userId;

    @JsonIgnore
    private String openId;

    private String userName;

    private String classId;

    private String phoneNumber;

    @ApiModelProperty("个性签名")
    private String signature;

    private Integer fansNum;

    private String sex;

    @JsonIgnore
    private String online;

    private String avatar;

    public UserVo(YmUser ymUser) {
        this.userId = ymUser.getUserId();
        this.openId = ymUser.getOpenId();
        this.userName = ymUser.getUserName();
        this.classId = ymUser.getClassId();
        this.phoneNumber = ymUser.getPhoneNumber();
        this.signature = ymUser.getSignature();
        this.fansNum = ymUser.getFansNum();
        this.sex = ymUser.getSex();
        this.online = ymUser.getOnline();
        this.avatar = ymUser.getAvatar();
    }

}
