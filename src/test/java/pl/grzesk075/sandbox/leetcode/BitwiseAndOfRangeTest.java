package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import java.util.function.ToIntBiFunction;

import static org.junit.Assert.assertEquals;

public class BitwiseAndOfRangeTest {

    @Test
    public void shouldGetNextPowerOfTwoOrMaxInt() {
        assertEquals(1, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(0));
        assertEquals(2, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(1));
        assertEquals(4, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(2));
        assertEquals(4, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(3));
        assertEquals(8, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(4));
        assertEquals(8, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(5));
        assertEquals(1 << 30, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(1 << 29));
        assertEquals(1 << 30, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt((1 << 29) + 1));
        assertEquals(Integer.MAX_VALUE, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(1 << 30));
        assertEquals(Integer.MAX_VALUE, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt((1 << 30) + 1));
        assertEquals(Integer.MAX_VALUE, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, BitwiseAndOfRange.getNextPowerOfTwoOrMaxInt(Integer.MAX_VALUE - 1));
    }

    @Test
    public void shouldCalculateRangeBitwiseAnd() {
        BitwiseAndOfRange bitwiseAndOfRange = new BitwiseAndOfRange();
        final ToIntBiFunction<Integer, Integer> rangeBitwiseAnd = bitwiseAndOfRange::rangeBitwiseAnd;
        testRangeBitwiseAnd(rangeBitwiseAnd);
    }

@Test
    public void shouldCalculateRangeBitwiseAndBestOfLeetCode() {
        BitwiseAndOfRange bitwiseAndOfRange = new BitwiseAndOfRange();
        final ToIntBiFunction<Integer, Integer> rangeBitwiseAnd = bitwiseAndOfRange::rangeBitwiseAndBestOfLeetCode;
        testRangeBitwiseAnd(rangeBitwiseAnd);
    }

    private void testRangeBitwiseAnd(ToIntBiFunction<Integer, Integer> rangeBitwiseAnd) {
        assertEquals(0, rangeBitwiseAnd.applyAsInt(0, 0));
        assertEquals(126735, rangeBitwiseAnd.applyAsInt(126735, 126735));
        assertEquals(84732, rangeBitwiseAnd.applyAsInt(84732, 84732));
        assertEquals(0, rangeBitwiseAnd.applyAsInt(0, 1));
        assertEquals(4, rangeBitwiseAnd.applyAsInt(5, 7));
        assertEquals(2147483646, rangeBitwiseAnd.applyAsInt(2147483646, 2147483647));
        assertEquals(0, rangeBitwiseAnd.applyAsInt(0, Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, rangeBitwiseAnd.applyAsInt(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
}