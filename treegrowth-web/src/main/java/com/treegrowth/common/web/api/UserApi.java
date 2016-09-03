package com.treegrowth.common.web.api;

import com.treegrowth.common.web.vo.RegisterUser;
import com.treegrowth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody RegisterUser registerUser){
        userService.create(registerUser.convert());

    }
}
