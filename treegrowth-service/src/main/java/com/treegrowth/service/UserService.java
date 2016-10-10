package com.treegrowth.service;

import com.treegrowth.model.entity.User;
import com.treegrowth.service.bo.UserDetail;
import com.treegrowth.service.bo.UserDetailBasic;

import java.util.Optional;

public interface UserService {

    UserDetailBasic create(User user);

    UserDetailBasic get(String loginUserId, String userId);

    Optional<UserDetail> findByEmail(String email);

}
