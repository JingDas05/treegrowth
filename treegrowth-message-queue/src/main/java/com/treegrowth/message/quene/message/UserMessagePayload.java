package com.treegrowth.message.quene.message;

import java.io.Serializable;

public class UserMessagePayload implements Serializable {

    private static final long serialVersionUID = -1571957782905618474L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
