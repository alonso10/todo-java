package com.easoft.domain.valueobjects;

import java.util.Objects;
import java.util.UUID;

public class Identifier {

    private final UUID value;

    public Identifier() {
        this.value = UUID.randomUUID();
    }

    public Identifier(String uuid) {
        try {
            this.value = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("UUID not valid");
        }
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
