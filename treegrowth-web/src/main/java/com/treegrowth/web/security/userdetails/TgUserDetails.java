package com.treegrowth.web.security.userdetails;


import com.treegrowth.service.bo.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class TgUserDetails implements UserDetails{
    private static final long serialVersionUID = -7562987760932622812L;

    private UserDetail user;

    public TgUserDetails() {}

    public TgUserDetails(UserDetail userDetail) {
        this.user = userDetail;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(user.authorities());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return this.user.getId();
    }

    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj ==null) return false;
        if (!(obj instanceof TgUserDetails)) return false;
        return this.getUsername().equals(((TgUserDetails) obj).getUsername());
    }
}
