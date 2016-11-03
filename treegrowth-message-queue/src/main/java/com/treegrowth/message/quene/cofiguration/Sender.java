package com.treegrowth.message.quene.cofiguration;

import com.treegrowth.message.quene.core.MessagePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, MessagePayload> kafkaTemplate;

    public void sendMessage(String topic, MessagePayload message) {
        // the KafkaTemplate provides asynchronous send methods returning a Future
        ListenableFuture<SendResult<String, MessagePayload>> future = kafkaTemplate.send(topic, message);

        // you can register a callback with the listener to receive the result of the send asynchronously
        future.addCallback(
                new ListenableFutureCallback<SendResult<String, MessagePayload>>() {
                    @Override
                    public void onFailure(Throwable ex) {
                        LOGGER.error("unable send the message = '{}'", message);
                    }

                    @Override
                    public void onSuccess(SendResult<String, MessagePayload> result) {
                        LOGGER.info("message = '{}',offset='{}'", message, result.getRecordMetadata().offset());
                    }
                }
        );
    }
}
