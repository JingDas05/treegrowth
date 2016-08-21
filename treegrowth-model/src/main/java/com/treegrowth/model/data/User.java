package com.treegrowth.model.data;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
