package pl.grzesk075.sandbox.codility.iterations;

import org.junit.Test;
import pl.grzesk075.sandbox.codility.iterations.OddOccurrencesInArray.Solution;

import static org.junit.Assert.*;

public class OddOccurrencesInArrayTest {
    @Test
    public void shouldCalculateOddOccurrencesInArray() {
        Solution solution = new OddOccurrencesInArray().new Solution();
        assertEquals(solution.solution(new int[]{1, 7, 1, 7, 8, 8, 9, 2, 3, 2, 3}), 9);
        assertEquals(solution.solution(new int[]{1, 5, 1000000000, 1, 1000000000, 1, 1000000000, 5, 9, 1, 1000000000, 3, 6, 6, 3}), 9);
        assertEquals(solution.solution(new int[]{5}), 5);
        assertEquals(solution.solution(new int[]{1, 1, 1}), 1);
        assertEquals(solution.solution(new int[]{3, 3, 3, 3, 3}), 3);
        assertEquals(solution.solution(new int[]{1, 3, 3, 3, 3, 3, 1}), 3);
        assertEquals(solution.solution(new int[]{1, 1000000000, 1000000000}), 1);
        assertEquals(solution.solution(new int[]{1, 1, 1000000000}), 1000000000);
        assertEquals(solution.solution(new int[]{1, 1, 1, 1, 1000000000}), 1000000000);
        assertEquals(solution.solution(new int[]{1, 1, 1, 1, 1, 9, 9}), 1);
        assertEquals(solution.solution(new int[]{1, 1, 1, 1, 1000000000, 1000000000, 1000000000}), 1000000000);
    }
}