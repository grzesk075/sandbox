package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortByParityTest {

    @Test
    public void shouldSortArrayByParity() {
        final SortByParity sortByParity = new SortByParity();
        assertArrayEquals(new int[]{2, 4, 1, 3}, sortByParity.sortArrayByParity(new int[]{3, 1, 2, 4}));
        assertArrayEquals(new int[]{2, 0, 1, 3}, sortByParity.sortArrayByParity(new int[]{3, 1, 2, 0}));
        assertArrayEquals(new int[]{0, 0}, sortByParity.sortArrayByParity(new int[]{0, 0}));
        assertArrayEquals(new int[]{0}, sortByParity.sortArrayByParity(new int[]{0}));
    }
}