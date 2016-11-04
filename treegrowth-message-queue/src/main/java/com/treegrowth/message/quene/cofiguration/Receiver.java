package com.treegrowth.message.quene.cofiguration;

import com.treegrowth.message.quene.message.UserMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "tree.a")
    public void receiveMessage(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }

    @KafkaListener(topics = "user.a")
    public void receiveUserMessage(UserMessage userMessage) {
        System.out.println("11111111111111111111111111111111" + userMessage.getPayload().getName());
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
