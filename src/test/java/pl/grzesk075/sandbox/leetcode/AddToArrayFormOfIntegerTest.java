package pl.grzesk075.sandbox.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class AddToArrayFormOfIntegerTest {

    public static final int TEST_REPETITIONS = 100_000;
    AddToArrayFormOfInteger addToArrayFormOfInteger;

    @Before
    public void setUp() throws Exception {
        addToArrayFormOfInteger = new AddToArrayFormOfInteger();
    }

    @Test
    public void shouldAddToArrayForm() {
        final BiFunction<int[], Integer, List<Integer>> addToArrayForm = addToArrayFormOfInteger::addToArrayForm;
        for (int i = 0; i < TEST_REPETITIONS; i++) {
            assertAddToArrayForm(addToArrayForm);
        }
    }

    @Test
    public void shouldAddToArrayFormFirstSolution() {
        final BiFunction<int[], Integer, List<Integer>> addToArrayForm = addToArrayFormOfInteger::addToArrayFormFirstSolution;
        for (int i = 0; i < TEST_REPETITIONS; i++) {
            assertAddToArrayForm(addToArrayForm);
        }
    }

    @Test
    public void shouldAddToArrayFormLeetCode() {
        final BiFunction<int[], Integer, List<Integer>> addToArrayForm = addToArrayFormOfInteger::addToArrayFormLeetCode;
        for (int i = 0; i < TEST_REPETITIONS; i++) {
            assertAddToArrayForm(addToArrayForm);
        }
    }

    private void assertAddToArrayForm(BiFunction<int[], Integer, List<Integer>> addToArrayForm) {
        assertEquals(Arrays.asList(1, 2, 3, 4), addToArrayForm.apply(new int[]{1, 2, 0, 0}, 34));
        assertEquals(Arrays.asList(4, 5, 5), addToArrayForm.apply(new int[]{2, 7, 4}, 181));
        assertEquals(Arrays.asList(1, 0, 2, 1), addToArrayForm.apply(new int[]{2, 1, 5}, 806));
        assertEquals(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), addToArrayForm.apply(
                new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        assertEquals(Arrays.asList(1, 2, 0, 0), addToArrayForm.apply(new int[]{1, 2, 0, 0}, 0));
        assertEquals(Arrays.asList(1, 2, 0, 0), addToArrayForm.apply(new int[]{0}, 1200));
        assertEquals(Arrays.asList(0), addToArrayForm.apply(new int[]{0}, 0));
    }
}