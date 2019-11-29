package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumberTest {

    @Test
    public void shouldRecognizeUglyNumber() {
        final UglyNumber uglyNumber = new UglyNumber();
        assertTrue(uglyNumber.isUgly(1));
        assertTrue(uglyNumber.isUgly(2));
        assertTrue(uglyNumber.isUgly(3));
        assertTrue(uglyNumber.isUgly(4));
        assertTrue(uglyNumber.isUgly(5));
        assertTrue(uglyNumber.isUgly(6));
        assertTrue(uglyNumber.isUgly(8));
        assertTrue(uglyNumber.isUgly(9));
        assertTrue(uglyNumber.isUgly(10));
        assertTrue(uglyNumber.isUgly(2 * 3 * 5 * 5 * 3 * 2));

        assertFalse(uglyNumber.isUgly(2 * 3 * 5 * 5 * 31 * 2));
        assertFalse(uglyNumber.isUgly(7));
        assertFalse(uglyNumber.isUgly(11));
        assertFalse(uglyNumber.isUgly(13));
        assertFalse(uglyNumber.isUgly(17));
        assertFalse(uglyNumber.isUgly(19));
        assertFalse(uglyNumber.isUgly(21));
        assertFalse(uglyNumber.isUgly(31));
        assertFalse(uglyNumber.isUgly(49));

        assertFalse(uglyNumber.isUgly(0));
        assertFalse(uglyNumber.isUgly(-1));
        assertFalse(uglyNumber.isUgly(Integer.MIN_VALUE));
        assertFalse(uglyNumber.isUgly(Integer.MAX_VALUE));
    }

    @Test
    public void shouldFindNthUglyNumber() {
        final UglyNumber uglyNumber = new UglyNumber();
        assertEquals(1, uglyNumber.nthUglyNumber(1));
        assertEquals(2, uglyNumber.nthUglyNumber(2));
        assertEquals(3, uglyNumber.nthUglyNumber(3));
        assertEquals(4, uglyNumber.nthUglyNumber(4));
        assertEquals(5, uglyNumber.nthUglyNumber(5));
        assertEquals(6, uglyNumber.nthUglyNumber(6));
        assertEquals(8, uglyNumber.nthUglyNumber(7));
        assertEquals(9, uglyNumber.nthUglyNumber(8));
        assertEquals(10, uglyNumber.nthUglyNumber(9));
        assertEquals(12, uglyNumber.nthUglyNumber(10));
        assertEquals(15, uglyNumber.nthUglyNumber(11));
        assertEquals(16, uglyNumber.nthUglyNumber(12));
        assertEquals(18, uglyNumber.nthUglyNumber(13));
        assertEquals(2123366400, uglyNumber.nthUglyNumber(1690));
    }
}