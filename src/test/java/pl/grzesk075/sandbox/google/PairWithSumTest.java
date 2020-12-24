package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PairWithSumTest {

    private final PairWithSum pairWithSum = new PairWithSum();
    private static final int SUM = 8;
    private static final int[] CONTAINING_1 = new int[]{1, 1, 4, 4};
    private static final int[] CONTAINING_2 = new int[]{-100, -50, -1, -3, 0, 1, 3, 4, 9, 23, 99};
    private static final int[] NOT_CONTAINING_1 = new int[]{-100, -50, -10, -3, 0, 1, 3, 4, 9, 23, 99};
    private static final int[] NOT_CONTAINING_2 = new int[]{1, 1, 4, 5};

    @Test
    public void hasPairWithSum1() {

        assertTrue(pairWithSum.hasPairWithSum1(CONTAINING_1, SUM));
        assertTrue(pairWithSum.hasPairWithSum1(CONTAINING_2, SUM));
        assertFalse(pairWithSum.hasPairWithSum1(NOT_CONTAINING_1, SUM));
        assertFalse(pairWithSum.hasPairWithSum1(NOT_CONTAINING_2, SUM));
    }

    @Test
    public void hasPairWithSum2() {

        assertTrue(pairWithSum.hasPairWithSum2(CONTAINING_1, SUM));
        assertTrue(pairWithSum.hasPairWithSum2(CONTAINING_2, SUM));
        assertFalse(pairWithSum.hasPairWithSum2(NOT_CONTAINING_1, SUM));
        assertFalse(pairWithSum.hasPairWithSum2(NOT_CONTAINING_2, SUM));
    }
}