package pl.grzesk075.sandbox.codility.iterations;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicRotationTest {

    @Test
    public void shouldRotateArray() {
        final CyclicRotation.Solution solution = new CyclicRotation().new Solution();
        assertArrayEquals(solution.solution(new int[]{3}, 123), new int[]{3});
        assertArrayEquals(solution.solution(new int[]{3, 5}, 1), new int[]{5, 3});
        assertArrayEquals(solution.solution(new int[]{3, 5}, 2), new int[]{3, 5});
        assertArrayEquals(solution.solution(new int[]{3, 5}, 3), new int[]{5, 3});
        assertArrayEquals(solution.solution(new int[]{3, 5}, 5), new int[]{5, 3});
        assertArrayEquals(solution.solution(new int[]{3, 5}, 7), new int[]{5, 3});
        assertArrayEquals(solution.solution(new int[]{3, 5}, 4), new int[]{3, 5});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 1), new int[]{5, 7, 3});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 4), new int[]{5, 7, 3});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 7), new int[]{5, 7, 3});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 2), new int[]{3, 5, 7});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 5), new int[]{3, 5, 7});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 8), new int[]{3, 5, 7});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 3), new int[]{7, 3, 5});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 6), new int[]{7, 3, 5});
        assertArrayEquals(solution.solution(new int[]{7, 3, 5}, 9), new int[]{7, 3, 5});
    }
}