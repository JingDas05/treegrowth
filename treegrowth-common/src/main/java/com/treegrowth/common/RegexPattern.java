package com.treegrowth.common;

public interface RegexPattern {

    String REGEX_USER_NAME = "^[^-!$%^&*()_+|~=`{}\\[\\]:/;<>?,.@#'\"\\\\]{1,20}$";
    String REGEX_USER_PASSWORD = "^[\\s\\S]{6,20}$";
    String REGEX_PHONE = "^(1[3578][0-9]{9}|(\\d{3,4}-)\\d{7,8}(-\\d{1,4})?)$";
    String REGEX_MAIL = "^[^@\\s]+@(?:[^@\\s.]+)(?:\\.[^@\\s.]+)+$";
    String REGEX_TEMPLATE_NAME = "^[\\w-]+$";
}
