package com.treegrowth.model.data;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User extends Basic {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
