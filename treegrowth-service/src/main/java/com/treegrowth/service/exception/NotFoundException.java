package com.treegrowth.service.exception;

public class NotFoundException extends ServiceRuntimeRuntimeException{

    private static final long serialVersionUID = -8504048567983559225L;

    public enum Message {
        USER
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Message message) {
        super(message);
    }

    @Override
    protected String modulePart() {
        return "NOT_FOUND";
    }
}
