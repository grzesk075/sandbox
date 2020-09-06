package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidNumberTest {

    @Test
    public void isNumberTest() {
        assertTrue(ValidNumber.isNumber("0"));
        assertTrue(ValidNumber.isNumber("1"));
        assertTrue(ValidNumber.isNumber("-1"));
        assertTrue(ValidNumber.isNumber("152434543"));
        assertTrue(ValidNumber.isNumber("-152434543"));
        assertTrue(ValidNumber.isNumber("-000152434543"));
        assertTrue(ValidNumber.isNumber("-000152434543.2345"));
        assertTrue(ValidNumber.isNumber("-000152434543.2345e1234"));
        assertTrue(ValidNumber.isNumber("000152434543.2345e1234"));
        assertTrue(ValidNumber.isNumber("000152434543.2345e-1234"));
        assertTrue(ValidNumber.isNumber("000152434543.2345e-01234"));
        assertTrue(ValidNumber.isNumber("+000152434543.2345e1234"));

        assertFalse(ValidNumber.isNumber("e"));
        assertFalse(ValidNumber.isNumber("1e"));
        assertFalse(ValidNumber.isNumber("e1"));
        assertFalse(ValidNumber.isNumber("+"));
        assertFalse(ValidNumber.isNumber("-"));
        assertFalse(ValidNumber.isNumber("++152434543"));
        assertFalse(ValidNumber.isNumber("+1524+34543"));
        assertFalse(ValidNumber.isNumber("--152434543"));
        assertFalse(ValidNumber.isNumber("-1524-34543"));
        assertFalse(ValidNumber.isNumber("-000152m434543"));
        assertFalse(ValidNumber.isNumber("-000152434543e"));
        assertFalse(ValidNumber.isNumber("-000152434543.e1"));
        assertFalse(ValidNumber.isNumber("-000.152434543.2345"));
        assertFalse(ValidNumber.isNumber("-00015e2434543.2345e1234"));
        assertFalse(ValidNumber.isNumber("."));
        assertFalse(ValidNumber.isNumber(".e"));
        assertFalse(ValidNumber.isNumber("e"));
        assertFalse(ValidNumber.isNumber("e."));
        assertFalse(ValidNumber.isNumber("+e"));
        assertFalse(ValidNumber.isNumber("-e"));
    }
}