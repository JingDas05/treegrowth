package com.treegrowth.service;

import com.treegrowth.model.entity.User;
import com.treegrowth.service.bo.UserDetailBasic;

public interface UserService {

    UserDetailBasic create(User user);

}
