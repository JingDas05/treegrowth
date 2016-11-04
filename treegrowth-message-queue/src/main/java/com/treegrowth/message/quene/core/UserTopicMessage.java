package com.treegrowth.message.quene.core;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class UserTopicMessage<T> implements CommonMessage<T> {

    private static final long serialVersionUID = -1688113693438120635L;

    private T payload;
    private Date sendDate;

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public T getPayload() {
        return payload;
    }

    @Override
    public MessageHeaders getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, "user");
        headers.put(KafkaHeaders.PARTITION_ID, "a");
        return new MessageHeaders(headers);
    }
}
