package com.treegrowth.service;

import com.treegrowth.model.entity.User;
import com.treegrowth.service.bo.AmendedUser;
import com.treegrowth.service.bo.UserDetail;
import com.treegrowth.service.bo.UserDetailBasic;

import java.util.Optional;

public interface UserService {

    UserDetailBasic create(User user);

    void delete(String userId);

    UserDetailBasic update(String userId, AmendedUser amendedUser);

    UserDetailBasic get(String loginUserId, String userId);

    Optional<UserDetail> findByEmail(String email);
}
