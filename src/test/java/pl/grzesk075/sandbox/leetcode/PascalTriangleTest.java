package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PascalTriangleTest {
    @Test
    public void shouldGeneratePascalTriangle() {
        final PascalTriangle.Solution solution = new PascalTriangle().new Solution();
        assertEquals(0, solution.generate(0).size());
        assertEquals(Arrays.asList(1), solution.generate(1).get(0));
        assertEquals(Arrays.asList(1, 1), solution.generate(2).get(1));
        assertEquals(Arrays.asList(1, 2, 1), solution.generate(3).get(2));
        assertEquals(Arrays.asList(1, 3, 3, 1), solution.generate(4).get(3));
        assertEquals(Arrays.asList(1, 4, 6, 4, 1), solution.generate(5).get(4));

        assertEquals(5, solution.generate(5).size());

        assertEquals(Arrays.asList(1), solution.generate(5).get(0));
        assertEquals(Arrays.asList(1, 1), solution.generate(5).get(1));
        assertEquals(Arrays.asList(1, 2, 1), solution.generate(5).get(2));
        assertEquals(Arrays.asList(1, 3, 3, 1), solution.generate(5).get(3));
    }
}