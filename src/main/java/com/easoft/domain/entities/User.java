package com.easoft.domain.entities;

import com.easoft.domain.valueobjects.Email;
import com.easoft.domain.valueobjects.Identifier;
import com.easoft.domain.valueobjects.Password;
import com.easoft.domain.valueobjects.Username;

public class User {
    private Identifier id;
    private Email email;

    private Username username;

    private Password password;


    public boolean matchesPassword(Password password) {
        return this.password.match(password.value());
    }

}
