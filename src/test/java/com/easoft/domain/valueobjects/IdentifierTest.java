package com.easoft.domain.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdentifierTest {

    @Test
    public void testGenerateNewIdentifier() {
        Identifier id = new Identifier();
        assertNotNull(id.getValue());
    }

    @Test
    public void testCreateIdentifierFromValidString() {
        String uuidValid = "f47ac10b-58cc-4372-a567-0e02b2c3d479";
        Identifier id = new Identifier(uuidValid);
        assertEquals(uuidValid, id.toString());
    }

    @Test
    public void testCreateIdentifierFromNotValidString() {
        String uuidNotValid = "f47ac10b";
        assertThrows(IllegalArgumentException.class, () -> new Identifier(uuidNotValid));
    }

    @Test
    public void testIdentifierEquals() {
        String uuidValid = "f47ac10b-58cc-4372-a567-0e02b2c3d479";
        Identifier id1 = new Identifier(uuidValid);
        Identifier id2 = new Identifier(uuidValid);
        assertEquals(id1, id2);
    }

    @Test
    public void testIdentifierNotEquals() {
        Identifier id1 = new Identifier();
        Identifier id2 = new Identifier();
        assertNotEquals(id1.toString(), id2.toString());
    }
}
