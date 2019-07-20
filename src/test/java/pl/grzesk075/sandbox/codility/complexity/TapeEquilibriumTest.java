package pl.grzesk075.sandbox.codility.complexity;

import org.junit.Test;

import static org.junit.Assert.*;

public class TapeEquilibriumTest {
    @Test
    public void shouldCalculateMinDifference() {
        final TapeEquilibrium.Solution solution = new TapeEquilibrium().new Solution();
        assertEquals(0, solution.solution(new int[]{0, 0}));
        assertEquals(0, solution.solution(new int[]{1, 1}));
        assertEquals(0, solution.solution(new int[]{1000, 1000}));
        assertEquals(0, solution.solution(new int[]{-1000, -1000}));
        assertEquals(2000, solution.solution(new int[]{-1000, 1000}));
        assertEquals(2000, solution.solution(new int[]{1000, -1000}));
        assertEquals(0, solution.solution(new int[]{1, 2, 3}));
        assertEquals(0, solution.solution(new int[]{5, 2, 3}));
        assertEquals(1, solution.solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(0, solution.solution(new int[]{1, -2, 3}));
    }
}