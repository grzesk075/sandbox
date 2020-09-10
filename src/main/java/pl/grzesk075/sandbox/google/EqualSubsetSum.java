package pl.grzesk075.sandbox.google;

/**
 * Equal subset sum partition.
 * <p>
 * Problem statement:
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 */
public class EqualSubsetSum {
    public static boolean hasEqualSubsetSum(final int[] set) {
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
            checkSubset(set, half, j, sum);
        }
        return false;
    }
}