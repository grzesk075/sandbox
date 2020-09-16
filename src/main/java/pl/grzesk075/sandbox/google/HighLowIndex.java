package pl.grzesk075.sandbox.google;

import java.util.Arrays;

/**
 * Find the high and low index.
 * <p>
 * Problem statement:
 * Given a sorted array of integers, return the low and high index of the given key.
 * Return -1 if not found. The array length can be in the millions with many duplicates.
 */
public class HighLowIndex {

    public static Indices findHighAndLowIndices(final int[] a, final int key) {

        Indices result = new Indices(-1, -1);
        int lowerThanKeyIdx = 0;
        int higherThanKeyIdx = a.length - 1;
        if (key < a[lowerThanKeyIdx] || a[higherThanKeyIdx] < key) {
            return result;
        }
        int lowResult = -1;
        int highResult = -1;
        if (key == a[lowerThanKeyIdx]) {
            lowResult = lowerThanKeyIdx;
        }
        if (key == a[higherThanKeyIdx]) {
            highResult = higherThanKeyIdx;
        }
        //use Arrays.binarySearch(a, key);

        result.low = lowResult;
        result.high = highResult;
        return result;
    }

    public static class Indices {
        int low;
        int high;

        public Indices(final int low, final int high) {
            this.low = low;
            this.high = high;
        }
    }
}
