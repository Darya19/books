package com.epam.day6.response;

public class Response<T> {

    private Status status;
    private ErrorCode errorCode;
    private T result;

    public Response(Status status, ErrorCode errorCode, T result) {
        this.status = status;
        this.errorCode = errorCode;
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultResponse{");
        sb.append("status=").append(status);
        sb.append(", errorCode='").append(errorCode).append('\'');
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response<?> response = (Response<?>) o;

        if (status != response.status) return false;
        if (errorCode != response.errorCode) return false;
        return result != null ? result.equals(response.result) : response.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = status != null ? status.hashCode() : 0;
        result1 = 31 * result1 + (errorCode != null ? errorCode.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}

