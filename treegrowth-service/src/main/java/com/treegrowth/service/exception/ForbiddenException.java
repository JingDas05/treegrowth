package com.treegrowth.service.exception;

public class ForbiddenException extends ServiceRuntimeRuntimeException {

    private static final long serialVersionUID = -5596334077739195063L;

    public enum Message {
        USER_DETAIL
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(Message message) {
        super(message);
    }

    @Override
    protected String modulePart() {
        return "FORBIDDEN";
    }
}
