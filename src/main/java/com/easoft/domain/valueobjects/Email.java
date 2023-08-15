package com.easoft.domain.valueobjects;

import java.util.regex.Pattern;

public class Email {

    private final String email;

    public Email(String email) {
        if (null == email || !this.validate(email)) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }

    private boolean validate(String email) {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    public String getValue() {
        return email;
    }
}
