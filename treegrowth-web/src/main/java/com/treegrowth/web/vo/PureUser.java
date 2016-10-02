package com.treegrowth.web.vo;

import com.treegrowth.model.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.treegrowth.common.RegexPattern.REGEX_MAIL;
import static com.treegrowth.common.RegexPattern.REGEX_USER_NAME;

public class PureUser {

    @NotNull
    @Pattern(regexp = REGEX_USER_NAME)
    private String name;

    @NotNull
    private String passWord;

    @NotNull
    @Pattern(regexp = REGEX_MAIL)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User convert() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.passWord);
        return user;
    }

}
