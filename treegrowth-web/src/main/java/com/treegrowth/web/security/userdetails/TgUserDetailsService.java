package com.treegrowth.web.security.userdetails;

import com.treegrowth.service.UserService;
import com.treegrowth.service.bo.UserDetail;
import com.treegrowth.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.treegrowth.service.exception.NotFoundException.Message.USER;

@Service("customUserDetailService")
public class TgUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserDetail userDetail = userService.findByEmail(userName).orElseThrow(() -> new NotFoundException(USER));
        return new TgUserDetails(userDetail);
    }
}