package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ClosestNumbersTest {

    @Test
    public void getClosestNumbersTest() {
        assertArrayEquals(new int[]{}, ClosestNumbers.getClosestNumbers(new int[]{}, 2, 7));
        assertArrayEquals(new int[]{1}, ClosestNumbers.getClosestNumbers(new int[]{1}, 2, 7));
        assertArrayEquals(new int[]{1}, ClosestNumbers.getClosestNumbers(new int[]{1}, 1, 7));
        final int[] sortedNumbers = {-3, -2, -1, 0, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(new int[]{7}, ClosestNumbers.getClosestNumbers(sortedNumbers, 1, 7));
        assertArrayEquals(new int[]{6, 7, 8}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, 7));
        assertArrayEquals(new int[]{7, 8, 9}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, 8));
        assertArrayEquals(new int[]{7, 8, 9}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, 9));
        assertArrayEquals(new int[]{7, 8, 9}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, 10));
        assertArrayEquals(new int[]{7, 8, 9}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, Integer.MAX_VALUE));
        assertArrayEquals(new int[]{3, 3, 3}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, 3));
        assertArrayEquals(new int[]{-3, -2, -1}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, -2));
        assertArrayEquals(new int[]{-3, -2, -1}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, -3));
        assertArrayEquals(new int[]{-3, -2, -1}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, -8));
        assertArrayEquals(new int[]{-3, -2, -1}, ClosestNumbers.getClosestNumbers(sortedNumbers, 3, Integer.MIN_VALUE));
        assertArrayEquals(new int[]{0, 2}, ClosestNumbers.getClosestNumbers(sortedNumbers, 2, 1));
        assertArrayEquals(new int[]{0, 2, 3, 3, 3, 4}, ClosestNumbers.getClosestNumbers(sortedNumbers, 6, 2));
        assertArrayEquals(sortedNumbers, ClosestNumbers.getClosestNumbers(sortedNumbers, sortedNumbers.length, 2));
    }
}