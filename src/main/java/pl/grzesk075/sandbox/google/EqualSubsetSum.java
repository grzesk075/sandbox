package pl.grzesk075.sandbox.google;

import java.util.Arrays;

/**
 * Equal subset sum partition.
 * <p>
 * Problem statement:
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 */
public class EqualSubsetSum {

    private EqualSubsetSum() {
    }

    /**
     * Binary tree gives better exponential O(2^(N-1)) time complexity -  V=2^(N-1).
     * @param set a set of positive integers
     * @return true, if set can be split into two subsets with equal sums
     */
    public static boolean hasEqualSubsetSumExponential(final int[] set) {
        long total = 0;
        for (int i : set) {
            total += i;
        }
        if (total % 2 == 1) {
            return false;
        }
        long half = total / 2;

        Arrays.sort(set);  // some heuristics here, bigger numbers first leads to fast backtracking

        final int firstNumberIndex = set.length - 1;
        long sumLeft = set[firstNumberIndex];  // biggest number
        long sumRight = 0L;
        return checkSubSums(sumLeft, sumRight, set, half, firstNumberIndex);
    }

    private static boolean checkSubSums(final long sumLeft, final long sumRight,
                                        final int[] set, final long half, final int i) {
        if (sumLeft == half || sumRight == half) {
            return true;
        } else if (sumLeft > half || sumRight > half) {
            return false;  // rule out subtree - backtracking
        }
        if (i == 0) {
            return false;  // leaf node
        }
        final int nextNumberIndex = i - 1;
        final int nextNumber = set[nextNumberIndex];
        if (checkSubSums(sumLeft + nextNumber, sumRight, set, half, nextNumberIndex)) {
            return true;
        }
        return checkSubSums(sumLeft, sumRight + nextNumber, set, half, nextNumberIndex);
    }

    /**
     * Worse factorial O(N!) solution.
     */
    public static boolean hasEqualSubsetSumFactorial(final int[] set) {
        long total = 0;
        for (int i : set) {
            total += i;
        }
        if (total % 2 == 1) {
            return false;
        }
        long half = total / 2;

        for (int i = 0; i < set.length; i++) {
            if (checkSubset(set, half, i, 0)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSubset(final int[] set, final long half, final int i, long sum) {
        sum += set[i];
        if (sum == half) {
            return true;
        } else if (sum > half) {
            return false;
        }
        for (int j = i + 1; j < set.length; j++) {
            if (checkSubset(set, half, j, sum)) {
                return true;
            }
        }
        return false;
    }
}