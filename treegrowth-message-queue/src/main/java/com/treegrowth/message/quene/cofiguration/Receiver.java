package com.treegrowth.message.quene.cofiguration;

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

    @KafkaListener(topics = "tree.b")
    public void receiveUserMessage(String message) {
        System.out.println("11111111111111111111111111111111" + message);
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
