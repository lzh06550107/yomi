package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(
        value = "Record对象",
        description = "操作记录"
)
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("操作记录id")
    @TableId(
            value = "record_id",
            type = IdType.AUTO
    )
    private Integer recordId;
    @ApiModelProperty("模块标题")
    private String title;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("操作的id")
    private String id;
    @ApiModelProperty("使用的那个方法")
    private String method;
    @ApiModelProperty("请求类型")
    private String requestMethod;
    @ApiModelProperty("当前使用的ip")
    private String operIp;
    @ApiModelProperty("请求的参数")
    private String operParam;
    @ApiModelProperty("返回的参数")
    private String jsonResult;
    @ApiModelProperty("异常信息")
    private String errorMsg;
    @ApiModelProperty("创建时间")
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createTime;

    public Record() {
    }

    public Integer getRecordId() {
        return this.recordId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public String getOperIp() {
        return this.operIp;
    }

    public String getOperParam() {
        return this.operParam;
    }

    public String getJsonResult() {
        return this.jsonResult;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public Record setRecordId(final Integer recordId) {
        this.recordId = recordId;
        return this;
    }

    public Record setTitle(final String title) {
        this.title = title;
        return this;
    }

    public Record setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    public Record setId(final String id) {
        this.id = id;
        return this;
    }

    public Record setMethod(final String method) {
        this.method = method;
        return this;
    }

    public Record setRequestMethod(final String requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public Record setOperIp(final String operIp) {
        this.operIp = operIp;
        return this;
    }

    public Record setOperParam(final String operParam) {
        this.operParam = operParam;
        return this;
    }

    public Record setJsonResult(final String jsonResult) {
        this.jsonResult = jsonResult;
        return this;
    }

    public Record setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public Record setCreateTime(final String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String toString() {
        return "Record(recordId=" + this.getRecordId() + ", title=" + this.getTitle() + ", userId=" + this.getUserId() + ", id=" + this.getId() + ", method=" + this.getMethod() + ", requestMethod=" + this.getRequestMethod() + ", operIp=" + this.getOperIp() + ", operParam=" + this.getOperParam() + ", jsonResult=" + this.getJsonResult() + ", errorMsg=" + this.getErrorMsg() + ", createTime=" + this.getCreateTime() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Record)) {
            return false;
        } else {
            Record other = (Record)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$recordId = this.getRecordId();
                Object other$recordId = other.getRecordId();
                if (this$recordId == null) {
                    if (other$recordId != null) {
                        return false;
                    }
                } else if (!this$recordId.equals(other$recordId)) {
                    return false;
                }

                Object this$title = this.getTitle();
                Object other$title = other.getTitle();
                if (this$title == null) {
                    if (other$title != null) {
                        return false;
                    }
                } else if (!this$title.equals(other$title)) {
                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$method = this.getMethod();
                Object other$method = other.getMethod();
                if (this$method == null) {
                    if (other$method != null) {
                        return false;
                    }
                } else if (!this$method.equals(other$method)) {
                    return false;
                }

                Object this$requestMethod = this.getRequestMethod();
                Object other$requestMethod = other.getRequestMethod();
                if (this$requestMethod == null) {
                    if (other$requestMethod != null) {
                        return false;
                    }
                } else if (!this$requestMethod.equals(other$requestMethod)) {
                    return false;
                }

                Object this$operIp = this.getOperIp();
                Object other$operIp = other.getOperIp();
                if (this$operIp == null) {
                    if (other$operIp != null) {
                        return false;
                    }
                } else if (!this$operIp.equals(other$operIp)) {
                    return false;
                }

                Object this$operParam = this.getOperParam();
                Object other$operParam = other.getOperParam();
                if (this$operParam == null) {
                    if (other$operParam != null) {
                        return false;
                    }
                } else if (!this$operParam.equals(other$operParam)) {
                    return false;
                }

                Object this$jsonResult = this.getJsonResult();
                Object other$jsonResult = other.getJsonResult();
                if (this$jsonResult == null) {
                    if (other$jsonResult != null) {
                        return false;
                    }
                } else if (!this$jsonResult.equals(other$jsonResult)) {
                    return false;
                }

                Object this$errorMsg = this.getErrorMsg();
                Object other$errorMsg = other.getErrorMsg();
                if (this$errorMsg == null) {
                    if (other$errorMsg != null) {
                        return false;
                    }
                } else if (!this$errorMsg.equals(other$errorMsg)) {
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Record;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $recordId = this.getRecordId();
        result = result * 59 + ($recordId == null ? 43 : $recordId.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $method = this.getMethod();
        result = result * 59 + ($method == null ? 43 : $method.hashCode());
        Object $requestMethod = this.getRequestMethod();
        result = result * 59 + ($requestMethod == null ? 43 : $requestMethod.hashCode());
        Object $operIp = this.getOperIp();
        result = result * 59 + ($operIp == null ? 43 : $operIp.hashCode());
        Object $operParam = this.getOperParam();
        result = result * 59 + ($operParam == null ? 43 : $operParam.hashCode());
        Object $jsonResult = this.getJsonResult();
        result = result * 59 + ($jsonResult == null ? 43 : $jsonResult.hashCode());
        Object $errorMsg = this.getErrorMsg();
        result = result * 59 + ($errorMsg == null ? 43 : $errorMsg.hashCode());
        Object $createTime = this.getCreateTime();
        result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
        return result;
    }
}
