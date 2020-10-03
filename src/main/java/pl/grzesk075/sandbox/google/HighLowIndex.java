package pl.grzesk075.sandbox.google;

/**
 * Find the high and low index.
 * <p>
 * Problem statement:
 * Given a sorted array of integers, return the low and high index of the given key.
 * Return -1 if not found. The array length can be in the millions with many duplicates.
 */
public class HighLowIndex {

    /**
     * Linear O(n).
     * Usage of modified binary search would give O(log(n)), but could be too complicated to meet assessment deadline.
     */
    public static Indices findHighAndLowIndices(final int[] a, final int key) {
        int low = -1;
        int high = -1;
        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            int v = a[i];
            if (v == key) {
                if (!found) {
                    found = true;
                    low = i;
                }
            } else if (v > key) {
                if (found) {
                    high = i - 1;
                }
                break;
            }
        }
        if (found && high == -1) {
            high = a.length - 1;
        }
        return new Indices(low, high);
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
