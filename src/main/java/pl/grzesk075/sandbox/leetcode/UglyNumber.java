package pl.grzesk075.sandbox.leetcode;

/**
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    private static final int[] PRIME_FACTORS = {2, 3, 5};

    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int quotient = num;
        do {
            boolean divisable = false;
            for (int primeFactor : PRIME_FACTORS) {
                if (quotient % primeFactor == 0) {
                    divisable = true;
                    quotient = quotient / primeFactor;
                    break;
                }
            }
            if (!divisable) {
                return false;
            }
        } while (quotient != 1);
        return true;
    }
}
