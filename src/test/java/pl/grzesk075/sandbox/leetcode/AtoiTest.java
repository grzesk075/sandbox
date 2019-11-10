package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class AtoiTest {

    public static final double NUMBER_OF_REPETITIONS = 1_000_000;

    @Test
    public void checkSolution() {
        final Atoi.Solution solution = new Atoi().new Solution();
        shouldDoAtoi(solution::myAtoi);
    }

    @Test
    public void checkBetterSolution() {
        final Atoi.BetterSolution betterSolution = new Atoi().new BetterSolution();
        shouldDoAtoi(betterSolution::myAtoi);
    }

    private void shouldDoAtoi(Function<String, Integer> atoi) {

        for (int i = 0; i < NUMBER_OF_REPETITIONS; i++) {
            assertEquals(0, atoi.apply("0").intValue());
            assertEquals(0, atoi.apply("").intValue());
            assertEquals(45, atoi.apply("45").intValue());
            assertEquals(-45, atoi.apply("-45").intValue());
            assertEquals(0, atoi.apply(null).intValue());
            assertEquals(0, atoi.apply("0-1").intValue());
            assertEquals(0, atoi.apply("0+1").intValue());
            assertEquals(10, atoi.apply("10e2").intValue());
            assertEquals(2, atoi.apply("       2").intValue());
            assertEquals(0, atoi.apply(" ++1").intValue());
            assertEquals(0, atoi.apply(" --1").intValue());
            assertEquals(123, atoi.apply("    +0000123").intValue());
            assertEquals(123, atoi.apply("    +0000123-").intValue());
            assertEquals(123, atoi.apply("    +0000123+").intValue());
            assertEquals(-123, atoi.apply("   -0000123rfqrqwreqewr").intValue());
            assertEquals(0, atoi.apply("   -0000 123rfqrqwreqewr").intValue());
            assertEquals(Integer.MIN_VALUE, atoi.apply("   -0000123937859237495603483465475859959595905959p").intValue());
            assertEquals(Integer.MAX_VALUE, atoi.apply("   +0000123937859237495603483465475859959595905959p").intValue());
            assertEquals(Integer.MAX_VALUE, atoi.apply("70000123937859237495603483465475859959595905959p").intValue());
        }
    }
}