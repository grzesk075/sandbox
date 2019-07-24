package pl.grzesk075.sandbox.codility.prefixsums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PassingCarsTest {
    @Test
    public void shouldCountPassingCars() {
        final PassingCars.Solution solution = new PassingCars().new Solution();
        assertEquals(5, solution.solution(new int[]{0, 1, 0, 1, 1}));
    }
}