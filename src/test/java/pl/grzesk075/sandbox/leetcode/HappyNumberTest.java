package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HappyNumberTest {

    @Test
    public void isHappy() {
        final HappyNumber happyNumber = new HappyNumber();
        assertTrue(happyNumber.isHappy(1));
        assertTrue(happyNumber.isHappy(13));
        assertTrue(happyNumber.isHappy(94111));
        assertTrue(happyNumber.isHappy(19));
        assertTrue(happyNumber.isHappy(23));
        assertTrue(happyNumber.isHappy(1000090000));
        assertTrue(happyNumber.isHappy(190000));
        assertTrue(happyNumber.isHappy(100));
        assertTrue(happyNumber.isHappy(10));
        assertTrue(happyNumber.isHappy(1000000));
        assertTrue(happyNumber.isHappy(1000000000));

        assertFalse(happyNumber.isHappy(2));
        assertFalse(happyNumber.isHappy(3));
        assertFalse(happyNumber.isHappy(4));
        assertFalse(happyNumber.isHappy(5));
        assertFalse(happyNumber.isHappy(284672543));
        assertFalse(happyNumber.isHappy(999));
        assertFalse(happyNumber.isHappy(9999));
        assertFalse(happyNumber.isHappy(999999));
        assertFalse(happyNumber.isHappy(Integer.MAX_VALUE));
    }
}