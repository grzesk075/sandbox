package pl.grzesk075.sandbox.google;

import java.util.Arrays;

/**
 * Find ‘k’ closest numbers.
 * <p>
 * Problem Statement:
 * Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
 * Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
 */
public class ClosestNumbers {
    public static int[] getClosestNumbers(int[] sortedNumbers, int K, int X) {
        final int length = sortedNumbers.length;
        if (K >= length) {
            return sortedNumbers;
        }
        final int idx = Arrays.binarySearch(sortedNumbers, X);
        int insertionPoint = idx >= 0 ? idx : -idx - 1;
        int fromIdx = insertionPoint;
        int toIdx = insertionPoint;

        while (toIdx - fromIdx < K) {
            boolean canGoRight = toIdx < length;
            boolean canGoLeft = fromIdx > 0;
            if (canGoLeft && canGoRight) {
                if (X - sortedNumbers[fromIdx - 1] <= sortedNumbers[toIdx] - X) {
                    fromIdx--;
                } else {
                    toIdx++;
                }
            } else if (canGoRight) {
                toIdx++;
            } else {
                fromIdx--;
            }
        }
        return Arrays.copyOfRange(sortedNumbers, fromIdx, toIdx);
    }
}
