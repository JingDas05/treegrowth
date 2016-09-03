package com.treegrowth.common.service.iml;

import com.treegrowth.model.data.User;
import com.treegrowth.repository.UserRepository;
import com.treegrowth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
