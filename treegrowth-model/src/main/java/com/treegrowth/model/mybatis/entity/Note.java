package com.treegrowth.model.mybatis.entity;

import java.io.Serializable;

public class Note implements Serializable {
    private static final long serialVersionUID = 8682818119565336598L;

    private Long id;

    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() + "," + getName();
    }
}
