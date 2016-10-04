package com.treegrowth.service.bo;

import com.treegrowth.model.entity.inner.user.UserConfirmStatus;
import com.treegrowth.model.security.Authority;

import java.io.Serializable;
import java.util.EnumSet;

public class UserDetail implements Serializable{

    private static final long serialVersionUID = -4803531504117175586L;

    private String id;
    private String username;
    private String phone;
    private String password;
    private UserConfirmStatus userConfirmStatus;
    private EnumSet<Authority> authorities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserConfirmStatus getUserConfirmStatus() {
        return userConfirmStatus;
    }

    public void setUserConfirmStatus(UserConfirmStatus userConfirmStatus) {
        this.userConfirmStatus = userConfirmStatus;
    }

    public boolean hasStatus(UserConfirmStatus userConfirmStatus) {
        return userConfirmStatus!=null&&userConfirmStatus==this.userConfirmStatus;
    }

    public EnumSet<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(EnumSet<Authority> authorities) {
        this.authorities = authorities;
    }

    public String[] authorities() {
        EnumSet<Authority> roles = getAuthorities();
        if (roles == null) {
            roles = EnumSet.noneOf(Authority.class);
        }
        roles.add(Authority.USER);
        return roles.stream().map(Authority::authority).toArray(String[]::new);
    }

}
