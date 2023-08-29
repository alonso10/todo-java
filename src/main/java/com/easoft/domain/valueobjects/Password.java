package com.easoft.domain.valueobjects;

import com.easoft.domain.exceptions.EmptyException;
import com.easoft.domain.exceptions.LengthException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
    private final String password;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);

    public Password(String password) throws EmptyException, LengthException {
        validate(password);
        this.password = password;
    }

    public Boolean match(String text) {
        return encoder.matches(text, hash(password));
    }

    private String hash(String text) {
        return encoder.encode(text);
    }

    public String value() {
        return hash(password);
    }

    private void validate(String text) throws LengthException, EmptyException {
        if (null == text || text.isEmpty()) {
            throw new EmptyException("Password must not be empty");
        }

        if (text.length() < 8) {
            throw new LengthException("Password must be 7 characters");
        }
    }
}
