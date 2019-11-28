package pl.grzesk075.sandbox.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive integer");
        }
        final Set<Integer> processedSums = new HashSet<>();
        int sum = n;
        do {
            final String digits = String.valueOf(sum);
            sum = 0;
            for (int i = 0; i < digits.length(); i++) {
                final int digit = digits.charAt(i) - '0';
                sum += digit * digit;
            }
            if (!processedSums.add(sum)) {
                return false;
            }
        } while (sum != 1);
        return true;
    }
}
