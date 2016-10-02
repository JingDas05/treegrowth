package com.treegrowth.service.iml;

import com.treegrowth.dao.repository.UserRepository;
import com.treegrowth.model.entity.User;
import com.treegrowth.service.UserService;
import com.treegrowth.service.bo.UserDetailBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetailBasic create(User user) {
        //Conditions.checkState(!userRepository.findByEmail(user.getEmail()).isPresent() -> );

        user.setRegistrationTime(new Date());
        user.setPassword(user.getPassword());
        User savedUser = userRepository.save(user);
        return new UserDetailBasic().from(savedUser);
    }
}
