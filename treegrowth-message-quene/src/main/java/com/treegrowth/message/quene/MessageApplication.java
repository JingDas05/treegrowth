package com.treegrowth.message.quene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class);
    }
}
