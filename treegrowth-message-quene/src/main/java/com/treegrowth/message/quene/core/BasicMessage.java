package com.treegrowth.message.quene.core;

import java.io.Serializable;
import java.util.Date;

public class BasicMessage<T> implements Serializable {
    private static final long serialVersionUID = 7981327491577050944L;

    private T payload;
    private Date sendDate;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
