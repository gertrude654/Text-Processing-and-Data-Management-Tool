package org.example.textprocessingdatamanagementtool.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularExpressionsTest {

    private final RegularExpressions regex = new RegularExpressions();

    @Test
    public void testSearchPatternInText() {
        // Test that a pattern is found in the text
        assertTrue(regex.searchPatternInText("Hello world", "world"));
        // Test that a pattern is not found in the text
        assertFalse(regex.searchPatternInText("Hello world", "foo"));
    }

    @Test
    public void testMatchPatternInText() {
        // Test that the entire text matches the pattern
        assertTrue(regex.matchPatternInText("Hello world", "Hello world"));
        assertFalse(regex.matchPatternInText("Hello world", "Hello"));
        assertFalse(regex.matchPatternInText("Hello world", "world"));
    }

    @Test
    public void testReplacePatternInText() {
        // Test replacing a pattern in the text
        assertEquals("Hello everyone", regex.replacePatternInText("Hello world", "world", "everyone"));
        assertEquals("Hello world", regex.replacePatternInText("Hello world", "foo", "bar")); // Pattern not found
        assertEquals("Hello world", regex.replacePatternInText("Hello world", "", "bar")); // Empty pattern
    }
}
