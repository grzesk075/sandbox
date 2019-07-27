package pl.grzesk075.sandbox.codility.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProductOfThreeTest {
    @Test
    public void shouldFindMaxProductOfThree() {
        final MaxProductOfThree.Solution solution = new MaxProductOfThree().new Solution();
        assertEquals(0, solution.solution(new int[]{0, 3, 7, -1}));
        assertEquals(63, solution.solution(new int[]{0, 3, 7, -1, 3, 3}));
        assertEquals(63, solution.solution(new int[]{-2, -4, 0, 3, 7, -1, 3, 3}));
        assertEquals(70, solution.solution(new int[]{-2, -5, 0, 3, 7, -1, 3, 3}));
        assertEquals(-6, solution.solution(new int[]{-2, -5, -10, -3, -7, -1, -3, -3}));
        assertEquals(1000000000, solution.solution(new int[]{1000, 1000, 1000}));
        assertEquals(1000000000, solution.solution(new int[]{-1000, 0, 4, 9, 93, 100, -1000, 1000}));
        assertEquals(-1000000000, solution.solution(new int[]{1000, -1000, 1000}));
        assertEquals(1000000000, solution.solution(new int[]{-1000, 1000, -1000}));
        assertEquals(-1000000000, solution.solution(new int[]{-1000, -1000, -1000}));
        assertEquals(0, solution.solution(new int[]{0, 0, 0}));
        assertEquals(0, solution.solution(new int[]{0, 4, -2, 0, 9, 0}));
    }
}