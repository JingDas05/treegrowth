package com.treegrowth.message.quene.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, ?> template;

    public void send(Message<?> message) {
        template.send(message);
    }
}
