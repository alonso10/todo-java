package com.easoft.domain.valueobjects;

import com.easoft.domain.exceptions.EmptyException;
import com.easoft.domain.exceptions.LengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    void testCreateEmptyPassword() {
        assertThrows(EmptyException.class, () -> new Password(""));
    }

    @Test
    void testCreateLessLengthPassword() {
        assertThrows(LengthException.class, () -> new Password("1234567"));
    }

    @Test
    void testCreateCorrectPassword() throws EmptyException, LengthException {
        String plainPass = "Password1234";
        Password password = new Password(plainPass);
        assertNotEquals(password.value(), "");
        assertTrue(password.match(plainPass));
    }
}
