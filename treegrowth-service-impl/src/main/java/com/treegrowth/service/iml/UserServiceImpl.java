package com.treegrowth.service.iml;

import com.treegrowth.dao.repository.UserRepository;
import com.treegrowth.model.entity.User;
import com.treegrowth.service.MailService;
import com.treegrowth.service.UserService;
import com.treegrowth.service.bo.UserDetail;
import com.treegrowth.service.bo.UserDetailBasic;
import com.treegrowth.service.exception.ConflictException;
import com.treegrowth.service.exception.ForbiddenException;
import com.treegrowth.service.iml.cell.UserCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.treegrowth.common.RegexPattern.REGEX_MAIL;
import static com.treegrowth.common.utils.Conditions.checkState;
import static com.treegrowth.service.exception.ConflictException.Message.USER_EXIST;
import static com.treegrowth.service.exception.ForbiddenException.Message.USER_DETAIL;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserCell userCell;
    @Autowired
    private MailService mailService;

    @Override
    public UserDetailBasic create(User user) {
        checkState(!userRepository.findByEmail(user.getEmail()).isPresent(), () -> new ConflictException(USER_EXIST));
        user.setRegistrationTime(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        mailService.send(savedUser);
        return new UserDetailBasic().from(savedUser);
    }

    @Override
    public UserDetailBasic get(String loginUserId, String userId) {
        checkState(loginUserId.equals(userId), () -> new ForbiddenException(USER_DETAIL));
        return userCell.getBasic(userId);
    }

    @Override
    public Optional<UserDetail> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            User savedUser = user.get();
            UserDetail userDetail = new UserDetail();
            userDetail.setId(savedUser.getId());
            userDetail.setUsername(savedUser.getName());
            userDetail.setPassword(savedUser.getPassword());
            userDetail.setPhone(savedUser.getPhoneNumber());
            userDetail.setUserConfirmStatus(savedUser.getUserConfirmStatus());
            userDetail.setAuthorities(savedUser.getAuthorities());
            return Optional.of(userDetail);
        }
        return Optional.empty();
    }
}
