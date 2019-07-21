package pl.grzesk075.sandbox.codility.conters;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogRiverOneTest {
    @Test
    public void shouldCalculateMinJumpTime() {
        final FrogRiverOne.Solution solution = new FrogRiverOne().new Solution();
        assertEquals(0, solution.solution(1, new int[]{1}));
        assertEquals(1, solution.solution(1, new int[]{2,1}));
        assertEquals(1, solution.solution(2, new int[]{2,1}));
        assertEquals(6, solution.solution(5, new int[]{1,3,1,4,2,3,5,4}));
        assertEquals(-1, solution.solution(5, new int[]{1,3,1,4,3,3,5,4}));
    }
}