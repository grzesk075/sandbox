package pl.grzesk075.sandbox.codility.conters;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermCheckTest {
    @Test
    public void shouldCheckIfIsPermutation() {
        final PermCheck.Solution solution = new PermCheck().new Solution();
        assertEquals(1, solution.solution(new int[]{1}));
        assertEquals(1, solution.solution(new int[]{1, 2}));
        assertEquals(1, solution.solution(new int[]{1, 2, 3}));
        assertEquals(1, solution.solution(new int[]{3, 1, 2}));
        assertEquals(0, solution.solution(new int[]{2}));
        assertEquals(0, solution.solution(new int[]{1000000000}));
        assertEquals(0, solution.solution(new int[]{1000000000, 1}));
    }
}