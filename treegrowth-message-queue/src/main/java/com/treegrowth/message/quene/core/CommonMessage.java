package com.treegrowth.message.quene.core;

import org.springframework.messaging.Message;

import java.io.Serializable;

public interface CommonMessage<T> extends Message<T>, Serializable {

}
