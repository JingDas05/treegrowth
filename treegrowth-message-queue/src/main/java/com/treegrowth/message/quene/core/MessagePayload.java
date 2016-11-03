package com.treegrowth.message.quene.core;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;
import java.util.Date;

public class MessagePayload<T> implements Message<T>, Serializable {
    private static final long serialVersionUID = 7981327491577050944L;

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
        return null;
    }
}
