package pl.grzesk075.sandbox.codility.iterations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.grzesk075.sandbox.codility.iterations.BinaryGap.Solution;

public class BinaryGapTest {

    @Test
    public void shouldCalculateGap() {
        
        Solution solution = new BinaryGap().new Solution();
        
        assertEquals(0, solution.solution(1));
        assertEquals(0, solution.solution(2));
        assertEquals(0, solution.solution(3));
        assertEquals(0, solution.solution(4));
        assertEquals(1, solution.solution(5));
        assertEquals(0, solution.solution(6));
        assertEquals(0, solution.solution(7));
        assertEquals(0, solution.solution(8));
        assertEquals(2, solution.solution(9));
        assertEquals(2, solution.solution(338));
        assertEquals(3, solution.solution(1349));
        assertEquals(5, solution.solution(1041));
        assertEquals(0, solution.solution(Integer.MAX_VALUE));
    }
}
