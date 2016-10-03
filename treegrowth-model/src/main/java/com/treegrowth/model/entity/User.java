package com.treegrowth.model.entity;

import com.treegrowth.model.converter.UserAuthorityConverter;
import com.treegrowth.model.entity.inner.user.UserConfirmStatus;
import com.treegrowth.model.security.Authority;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.EnumSet;

import static com.treegrowth.common.RegexPattern.REGEX_MAIL;
import static com.treegrowth.common.RegexPattern.REGEX_PHONE;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "tg_user")
public class User extends Base {
    private static final long serialVersionUID = 8771265627335859033L;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Pattern(regexp = REGEX_PHONE)
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Pattern(regexp = REGEX_MAIL)
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "user_confirm_status", unique = true)
    @Enumerated(STRING)
    private UserConfirmStatus userConfirmStatus;

    @Column(name = "authorities")
    @Convert(converter = UserAuthorityConverter.class)
    private EnumSet<Authority> authorities;

    @Column(name = "last_access_time", unique = true)
    private Date lastAccessTime;

    @Column(name = "registration_time", unique = true)
    private Date registrationTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserConfirmStatus getUserConfirmStatus() {
        return userConfirmStatus;
    }

    public void setUserConfirmStatus(UserConfirmStatus userConfirmStatus) {
        this.userConfirmStatus = userConfirmStatus;
    }

    public EnumSet<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(EnumSet<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
}
