package com.easoft.domain.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsernameTest {

    @Test
    public void testCreateNewUsername() {
        Username username = new Username("Pruebas");
        assertNotNull(username.getValue());
    }

    @Test
    public void testUsernameNotValid() {
        assertThrows(IllegalArgumentException.class, () -> new Username(""));
    }
}
