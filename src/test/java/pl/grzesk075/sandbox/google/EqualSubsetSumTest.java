package pl.grzesk075.sandbox.google;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EqualSubsetSumTest {

    private static final int[] EQUAL_SUBSETS_0 = new int[]{1, 1};
    private static final int[] EQUAL_SUBSETS_1 = new int[]{1, 1, 2};
    private static final int[] EQUAL_SUBSETS_2 = new int[]{1, 1, 2, 5, 6, 3};
    private static final int[] EQUAL_SUBSETS_3 =
            new int[]{1, 1, 2, 5, 6, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 7, 3, 3, 1, 8, 8, 8, 20, 4};
    private static final int[] EQUAL_SUBSETS_4 =
            new int[]{1, 1, 2, 5, 6, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 7, 3, 3, 1, 8, 8, 8, 20, 4,
                    Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

    private static final int[] NOT_EQUAL_SUBSETS_0 = new int[]{1};
    private static final int[] NOT_EQUAL_SUBSETS_1 = new int[]{1, 3, 3};
    private static final int[] NOT_EQUAL_SUBSETS_2 = new int[]{8, 8, 8, 8, 8, 10};
    private static final int[] NOT_EQUAL_SUBSETS_3 =
            new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 22};
    private static final int[] NOT_EQUAL_SUBSETS_4 =
            new int[]{1, 1, 2, 5, 6, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 7, 3, 3, 1, 8, 8, 8, 20, 4,
                    Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 12222222};

    @Test
    public void hasEqualSubsetSumExponential() {
        assertTrue(EqualSubsetSum.hasEqualSubsetSumExponential(EQUAL_SUBSETS_0));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumExponential(EQUAL_SUBSETS_1));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumExponential(EQUAL_SUBSETS_2));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumExponential(EQUAL_SUBSETS_3));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumExponential(EQUAL_SUBSETS_4));

        assertFalse(EqualSubsetSum.hasEqualSubsetSumExponential(NOT_EQUAL_SUBSETS_0));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumExponential(NOT_EQUAL_SUBSETS_1));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumExponential(NOT_EQUAL_SUBSETS_2));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumExponential(NOT_EQUAL_SUBSETS_3));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumExponential(NOT_EQUAL_SUBSETS_4));
    }

    @Test
    public void hasEqualSubsetSumFactorial() {
        assertTrue(EqualSubsetSum.hasEqualSubsetSumFactorial(EQUAL_SUBSETS_0));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumFactorial(EQUAL_SUBSETS_1));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumFactorial(EQUAL_SUBSETS_2));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumFactorial(EQUAL_SUBSETS_3));
        assertTrue(EqualSubsetSum.hasEqualSubsetSumFactorial(EQUAL_SUBSETS_4));

        assertFalse(EqualSubsetSum.hasEqualSubsetSumFactorial(NOT_EQUAL_SUBSETS_0));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumFactorial(NOT_EQUAL_SUBSETS_1));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumFactorial(NOT_EQUAL_SUBSETS_2));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumFactorial(NOT_EQUAL_SUBSETS_3));
        assertFalse(EqualSubsetSum.hasEqualSubsetSumFactorial(NOT_EQUAL_SUBSETS_4));
    }
}