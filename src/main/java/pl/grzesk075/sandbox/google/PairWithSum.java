package pl.grzesk075.sandbox.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if array has two integers with sum equals to argument 'sum'.
 * Works for numbers between MIN_INT/2, MAX_INT/2.
 */
public class PairWithSum {

    /* Linear solution for sorted array (ascending). */
    boolean hasPairWithSum1(int[] a, int sum) {
        int l = 0;
        int h = a.length - 1;
        while (l < h) {
            int s = a[l] + a[h];
            if (s == sum) {
                return true;
            }
            if (s > sum) {
                h--;
            } else {
                l++;
            }
        }
        return false;
    }

    /* Linear solution for unsorted array (ascending). */
    boolean hasPairWithSum2(int[] a, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int v : a) {
            if(complements.contains(v)) return true;
            complements.add(sum - v);
        }
        return false;
    }
}
