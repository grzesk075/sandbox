package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AddToArrayFormOfIntegerTest {

    @Test
    public void shouldAddToArrayForm() {
        final AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();
        assertEquals(Arrays.asList(1, 2, 3, 4), addToArrayFormOfInteger.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        assertEquals(Arrays.asList(4, 5, 5), addToArrayFormOfInteger.addToArrayForm(new int[]{2, 7, 4}, 181));
        assertEquals(Arrays.asList(1, 0, 2, 1), addToArrayFormOfInteger.addToArrayForm(new int[]{2, 1, 5}, 806));
        assertEquals(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), addToArrayFormOfInteger.addToArrayForm(
                new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        assertEquals(Arrays.asList(1, 2, 0, 0), addToArrayFormOfInteger.addToArrayForm(new int[]{1, 2, 0, 0}, 0));
        assertEquals(Arrays.asList(1, 2, 0, 0), addToArrayFormOfInteger.addToArrayForm(new int[]{0}, 1200));
        assertEquals(Arrays.asList( 0), addToArrayFormOfInteger.addToArrayForm(new int[]{0}, 0));
    }
}