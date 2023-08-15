package com.easoft.domain.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void testGenerateEmail() {
        String emailTest = "alice@example.com";
        Email email = new Email(emailTest);
        assertNotNull(email.getValue());
    }

    @Test
    public void testGenerateEmailNotValid() {
        String emailNotValid = "";
        assertThrows(IllegalArgumentException.class, () -> new Email(emailNotValid));
    }
}
