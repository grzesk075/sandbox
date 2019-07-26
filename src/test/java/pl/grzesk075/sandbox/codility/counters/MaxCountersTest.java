package pl.grzesk075.sandbox.codility.counters;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxCountersTest {
    @Test
    public void shouldCalculateCounters() {
        final MaxCounters.Solution solution = new MaxCounters().new Solution();
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution.solution(5, new int[]{3,4,4,6,1,4,4}));
    }
}