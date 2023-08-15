package com.easoft.domain.valueobjects;

public class Username {
    private final String username;

    public Username(String username) {
        if (null == username || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is not valid");
        }

        this.username = username;
    }

    public String getValue() {
        return username;
    }
}
