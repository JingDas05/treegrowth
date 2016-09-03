package com.treegrowth.common.web.vo;


import com.treegrowth.model.data.User;

import javax.validation.constraints.Pattern;

import static com.treegrowth.common.RegexPattern.REGEX_USER_NAME;

public class RegisterUser {


    @Pattern( regexp = REGEX_USER_NAME)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User convert() {
        User user = new User();
        user.setName(this.name);
        return user;
    }

}
