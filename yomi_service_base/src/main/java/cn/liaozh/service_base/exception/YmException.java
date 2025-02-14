package cn.liaozh.service_base.exception;

import cn.liaozh.service_base.enums.ExecutionResult;

public class YmException extends RuntimeException {
    private ExecutionResult executionResult;

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof YmException)) {
            return false;
        } else {
            YmException other = (YmException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$executionResult = this.getExecutionResult();
                Object other$executionResult = other.getExecutionResult();
                if (this$executionResult == null) {
                    if (other$executionResult != null) {
                        return false;
                    }
                } else if (!this$executionResult.equals(other$executionResult)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YmException;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        Object $executionResult = this.getExecutionResult();
        result = result * 59 + ($executionResult == null ? 43 : $executionResult.hashCode());
        return result;
    }

    public ExecutionResult getExecutionResult() {
        return this.executionResult;
    }

    public void setExecutionResult(final ExecutionResult executionResult) {
        this.executionResult = executionResult;
    }

    public String toString() {
        return "YmException(executionResult=" + this.getExecutionResult() + ")";
    }

    public YmException(final ExecutionResult executionResult) {
        this.executionResult = executionResult;
    }

    public YmException() {
    }
}
