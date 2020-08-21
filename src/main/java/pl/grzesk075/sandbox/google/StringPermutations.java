package pl.grzesk075.sandbox.google;

import java.util.Arrays;

/**
 * Print all permutations of a given string.
 * N! results are expected, backtracking algorithm to implement.
 * Algorythm:
 * 1. Replace first non-fixed letter with itself and each other non-fixed letter.
 * 2. Mark this letter as fixed in all of its new position and recursively run.
 * 3. When only one non-fixed letter remains - print and return.
 * First level run has n permutations, next n-1 and so on.
 */
public class StringPermutations {

    public void printPermutations(final String str) {

        printPermutations(str.toCharArray(), new boolean[str.length()]);
    }

    private void printPermutations(final char[] str, final boolean[] fixedLetters) {
        final int n = str.length;
        int letterToSwapAndFixIndex = -1;
        for (int i = 0; i < n; i++) {  // Find first not fixed letter.
            if (!fixedLetters[i]) {
                letterToSwapAndFixIndex = i;
                break;
            }
        }
        if (letterToSwapAndFixIndex == -1) {
            System.out.println(String.valueOf(str));
            return;
        }
        final char letterToSwap = str[letterToSwapAndFixIndex];
        for (int i = 0; i < n; i++) {  // Replace first non-fixed letter with itself and each other non-fixed letter.
            if (!fixedLetters[i]) {
                final char[] permutation = Arrays.copyOf(str, n);
                permutation[letterToSwapAndFixIndex] = str[i];
                permutation[i] = letterToSwap;

                final boolean[] permutationFixedLetters = Arrays.copyOf(fixedLetters, n);
                permutationFixedLetters[i] = true;

                printPermutations(permutation, permutationFixedLetters);
            }
        }
    }
}