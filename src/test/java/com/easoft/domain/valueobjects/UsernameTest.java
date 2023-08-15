package com.easoft.domain.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsernameTest {

    @Test
    public void testCreateNewUsername() {
        Username username = new Username("Pruebas");
        assertNotNull(username.getValue());
    }
}
