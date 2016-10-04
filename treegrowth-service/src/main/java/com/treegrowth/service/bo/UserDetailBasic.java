package com.treegrowth.service.bo;

import com.treegrowth.model.converter.UserAuthorityConverter;
import com.treegrowth.model.entity.User;
import com.treegrowth.model.entity.inner.user.UserConfirmStatus;
import com.treegrowth.model.security.Authority;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;

import static com.treegrowth.common.RegexPattern.REGEX_MAIL;
import static com.treegrowth.common.RegexPattern.REGEX_PHONE;
import static javax.persistence.EnumType.STRING;

public class UserDetailBasic implements Serializable{

    private static final long serialVersionUID = -1667935136465278580L;

    private String id;
    private String name;
    private String email;
    private Date registrationTime;
    private String phoneNumber;
    private UserConfirmStatus userConfirmStatus;
    private Date lastAccessTime;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserConfirmStatus getUserConfirmStatus() {
        return userConfirmStatus;
    }

    public void setUserConfirmStatus(UserConfirmStatus userConfirmStatus) {
        this.userConfirmStatus = userConfirmStatus;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public UserDetailBasic from(User user) {
        UserDetailBasic userDetailBasic = new UserDetailBasic();
        userDetailBasic.setId(user.getId());
        userDetailBasic.setName(user.getName());
        userDetailBasic.setEmail(user.getEmail());
        userDetailBasic.setRegistrationTime(user.getRegistrationTime());
        return userDetailBasic;
    }


}
