package com.treegrowth.service.bo;

import com.treegrowth.model.entity.User;

import java.util.Date;

public class UserDetailBasic {

    private String id;
    private String name;
    private String email;
    private Date registrationTime;

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
