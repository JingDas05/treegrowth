package com.treegrowth.message.quene.message;

public class UserMessage {

    private String name;

    public UserMessage() {
    }

    public UserMessage(String _name) {
        this.name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
