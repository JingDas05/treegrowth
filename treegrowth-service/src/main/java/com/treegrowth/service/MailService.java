package com.treegrowth.service;

import com.treegrowth.model.entity.User;

public interface MailService {

    void send(User user);
}
