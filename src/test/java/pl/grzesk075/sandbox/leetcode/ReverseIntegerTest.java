package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {
    @Test
    public void shouldRevertInteger() {
        final ReverseInteger.Solution solution = new ReverseInteger().new Solution();
        assertEquals(0, solution.reverse(0));
        assertEquals(5, solution.reverse(5));
        assertEquals(-8, solution.reverse(-8));
        assertEquals(8, solution.reverse(80));
        assertEquals(9, solution.reverse(90000));
        assertEquals(-4, solution.reverse(-400));
        assertEquals(54321, solution.reverse(12345));
        assertEquals(0, solution.reverse(Integer.MIN_VALUE));
    }
}