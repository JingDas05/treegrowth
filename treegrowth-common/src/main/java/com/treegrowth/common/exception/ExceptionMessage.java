package com.treegrowth.common.exception;

import java.io.Serializable;

public class ExceptionMessage implements Serializable {

    private static final long serialVersionUID = 5906695796265079212L;

    private String code;
    private String detail;

    public ExceptionMessage() {
    }

    public ExceptionMessage(CustomRuntimeException customRuntimeException) {
        this.code = customRuntimeException.getExceptionCode();
        this.detail = customRuntimeException.getExceptionMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
