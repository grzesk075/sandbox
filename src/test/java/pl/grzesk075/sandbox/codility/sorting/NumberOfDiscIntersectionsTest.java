package pl.grzesk075.sandbox.codility.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfDiscIntersectionsTest {
    @Test
    public void shouldCalculateNumberOfDiscIntersections() {
        final NumberOfDiscIntersections.Solution solution = new NumberOfDiscIntersections().new Solution();
        assertEquals(0, solution.solution(new int[]{}));
        assertEquals(0, solution.solution(new int[]{0}));
        assertEquals(0, solution.solution(new int[]{1}));
        assertEquals(0, solution.solution(new int[]{Integer.MAX_VALUE}));
        assertEquals(0, solution.solution(new int[]{0, 0}));
        assertEquals(0, solution.solution(new int[]{0, 0, 0}));
        assertEquals(0, solution.solution(new int[]{0, 0, 0, 0}));
        assertEquals(0, solution.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
        assertEquals(1, solution.solution(new int[]{1, 1}));
        assertEquals(1, solution.solution(new int[]{1, 0}));
        assertEquals(1, solution.solution(new int[]{0, 1}));
        assertEquals(3, solution.solution(new int[]{1, 1, 1}));
        assertEquals(2, solution.solution(new int[]{1, 1, 0}));
        assertEquals(2, solution.solution(new int[]{0, 1, 1}));
        assertEquals(3, solution.solution(new int[]{1, 0, 1}));
        assertEquals(3, solution.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
        assertEquals(3, solution.solution(new int[]{Integer.MAX_VALUE, 0, Integer.MAX_VALUE}));
        assertEquals(11, solution.solution(new int[]{1, 5, 2, 1, 4, 0}));
    }
}