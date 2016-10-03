package com.treegrowth.web.api;

import com.treegrowth.service.bo.UserDetailBasic;
import com.treegrowth.web.vo.PureUser;

import com.treegrowth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public UserDetailBasic create(@Valid @RequestBody PureUser pureUser){
        return userService.create(pureUser.convert());
    }
}
