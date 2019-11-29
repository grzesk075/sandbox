package pl.grzesk075.sandbox.leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    private static final int[] PRIME_FACTORS = {2, 3, 5};

    private static final long FIRST_UGLY_NUMBER = 1;

    private static final int FIRST_UGLY_NUMBER_NO = 1;

    private static final int MAX_SUPPORTED_UGLY_NUMBER_NO = 1690;

    public boolean isUgly(int num) {
        if (num < FIRST_UGLY_NUMBER) {
            return false;
        }
        if (num == FIRST_UGLY_NUMBER) {
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

    public int nthUglyNumber(int n) {
        if (n < FIRST_UGLY_NUMBER_NO || n > MAX_SUPPORTED_UGLY_NUMBER_NO) {
            throw new IllegalArgumentException(String.format("n must be between %d and %d (inclusive)",
                    FIRST_UGLY_NUMBER, MAX_SUPPORTED_UGLY_NUMBER_NO));
        }
        final SortedSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(FIRST_UGLY_NUMBER);
        long uglyNumber = FIRST_UGLY_NUMBER;
        int uglyNumberNo = FIRST_UGLY_NUMBER_NO;
        while (uglyNumberNo != n) {
            for (int i = 0; i < PRIME_FACTORS.length; i++) {
                int primeFactor = PRIME_FACTORS[i];
                uglyNumbers.add(uglyNumber * primeFactor);
            }
            uglyNumber = uglyNumbers.tailSet(uglyNumber + 1).first();
            uglyNumberNo++;
        }
        System.out.println(n + " consecutive ugly numbers:");
        uglyNumbers.stream().limit(n).forEach(System.out::println);
        return (int) uglyNumber;
    }
}
