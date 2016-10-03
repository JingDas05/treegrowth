package com.treegrowth.service.exception;

public class ConflictException extends ServiceRuntimeRuntimeException {

    private static final long serialVersionUID = 4315920331197156127L;

    public enum Message {
        USER_EXIST
    }

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(Message message) {
        super(message);
    }


    @Override
    protected String modulePart() {
        return "CONFLICT";
    }
}
