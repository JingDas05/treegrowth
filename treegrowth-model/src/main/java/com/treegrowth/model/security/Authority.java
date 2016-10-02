package com.treegrowth.model.security;

public enum Authority {
    ADMIN, USER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
