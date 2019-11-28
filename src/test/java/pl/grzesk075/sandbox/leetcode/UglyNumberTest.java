package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UglyNumberTest {

    @Test
    public void isUgly() {
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
}