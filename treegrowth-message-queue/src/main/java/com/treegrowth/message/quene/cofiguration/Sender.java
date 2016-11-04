package com.treegrowth.message.quene.cofiguration;

import com.treegrowth.message.quene.core.CommonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, CommonMessage> kafkaTemplate;

    public void sendMessage(Message<? extends CommonMessage> message) {
        // the KafkaTemplate provides asynchronous send methods returning a Future
        ListenableFuture<SendResult<String, CommonMessage>> future = kafkaTemplate.send(message);

        // you can register a callback with the listener to receive the result of the send asynchronously
        future.addCallback(
                new ListenableFutureCallback<SendResult<String, CommonMessage>>() {
                    @Override
                    public void onFailure(Throwable ex) {
                        LOGGER.error("unable send the message = '{}'", message);
                    }

                    @Override
                    public void onSuccess(SendResult<String, CommonMessage> result) {
                        LOGGER.info("message = '{}',offset='{}'", message, result.getRecordMetadata().offset());
                    }
                }
        );
    }
}
