package com.treegrowth.common.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;


public abstract class CustomRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7924131012873526238L;

    private Enum<?> message;
    private String exceptionCode;
    private Object[] arguments;

    public CustomRuntimeException(Enum<?> message) {
        this.message = message;
        this.exceptionCode = exceptionCode(message);

    }

    public CustomRuntimeException() {
        super();
    }

    public CustomRuntimeException(String message) {
        super(message);
    }

    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomRuntimeException(Throwable cause) {
        super(cause);
    }

    public String getExceptionMessage() {
        return messageSource().getMessage(exceptionCode, arguments, super.getLocalizedMessage(), Locale.getDefault());
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setBasename("classpath:" + baseName());
        return messageSource;
    }

    protected abstract String baseName();

    protected abstract String module();

    private String exceptionCode(Enum<?> message) {
        return String.format("%s_%s", module(), message.name().toUpperCase());
    }

}
