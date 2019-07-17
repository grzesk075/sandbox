package pl.grzesk075.sandbox.codility.complexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrogJmpTest {
    @Test
    public void shouldCalculateFrogJump() {
        FrogJmp.Solution solution = new FrogJmp().new Solution();
        assertEquals(0, solution.solution(1, 1, 1));
        assertEquals(0, solution.solution(1, 1, 1000000000));
        assertEquals(0, solution.solution(1000000000, 1000000000, 1000000000));
        assertEquals(0, solution.solution(1000000000, 1000000000, 1));
        assertEquals(0, solution.solution(1000000, 1000000, 1000000));
        assertEquals(1, solution.solution(1, 2, 1));
        assertEquals(1, solution.solution(1, 2, 2));
        assertEquals(1, solution.solution(1, 2, 3));
        assertEquals(1, solution.solution(1, 2, 1000000000));
        assertEquals(1, solution.solution(1, 1000000000, 1000000000));
        assertEquals(1, solution.solution(1000000000-1, 1000000000, 1));
        assertEquals(1, solution.solution(1000000000-1, 1000000000, 1000000000));
        assertEquals(1, solution.solution(1, 4, 3));
        assertEquals(2, solution.solution(1, 5, 2));
        assertEquals(2, solution.solution(1, 5, 3));
    }
}