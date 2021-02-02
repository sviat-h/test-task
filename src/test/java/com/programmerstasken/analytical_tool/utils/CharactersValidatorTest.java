package com.programmerstasken.analytical_tool.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharactersValidatorTest {

    @Test
    void isNumeric() {
        boolean actualResult1 = CharactersValidator.isNumeric("8.15.1");
        boolean actualResult2 = CharactersValidator.isNumeric("1.");
        boolean actualResult3 = CharactersValidator.isNumeric("s");
        boolean actualResult4 = CharactersValidator.isNumeric("2");

        assertTrue(actualResult1);
        assertFalse(actualResult2);
        assertFalse(actualResult3);
        assertTrue(actualResult4);
    }

    @Test
    void isDate() {
        boolean actualDate1 = CharactersValidator.isDate("15.10.2012");
        boolean actualDate2 = CharactersValidator.isDate("15.10.2012.");
        boolean actualDate3 = CharactersValidator.isDate("dd.mm.yyyy");

        assertTrue(actualDate1);
        assertFalse(actualDate2);
        assertFalse(actualDate3);
    }
}