package com.treegrowth.service.iml.cell;

import com.treegrowth.dao.repository.UserRepository;
import com.treegrowth.model.entity.User;
import com.treegrowth.service.bo.UserDetailBasic;
import com.treegrowth.service.exception.NotFoundException;
import com.treegrowth.service.iml.cache.annotation.UserBasicCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.treegrowth.service.exception.NotFoundException.Message.USER;

@Component
@Transactional
@EnableCaching
public class UserCell {

    @Autowired
    private UserRepository userRepository;

    @UserBasicCache
    public UserDetailBasic getBasic(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER));
        UserDetailBasic userDetailBasic = new UserDetailBasic();
        userDetailBasic.setId(user.getId());
        userDetailBasic.setName(user.getName());
        userDetailBasic.setEmail(user.getEmail());
        userDetailBasic.setPhoneNumber(user.getPhoneNumber());
        userDetailBasic.setRegistrationTime(user.getRegistrationTime());
        userDetailBasic.setLastAccessTime(user.getLastAccessTime());
        userDetailBasic.setUserConfirmStatus(user.getUserConfirmStatus());
        return userDetailBasic;
    }
}
