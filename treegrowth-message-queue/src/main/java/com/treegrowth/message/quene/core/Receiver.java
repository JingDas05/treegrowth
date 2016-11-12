package com.treegrowth.message.quene.core;

import com.treegrowth.message.quene.message.UserMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "jsonKafkaListenerContainerFactory")
    public void receiveUserMessage(UserMessage userMessage) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + userMessage.getName());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + userMessage.getName());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + userMessage.getName());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + userMessage.getName());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + userMessage.getName());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + userMessage.getName());
    }
}
