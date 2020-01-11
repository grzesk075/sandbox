package pl.grzesk075.sandbox.leetcode;

import java.util.Arrays;

public class PermutationInString {

    public static final int ALPHABET_LENGTH = 'z' - 'a' + 1;

    public boolean checkInclusion(String s1, String s2) {
        final int permutationLength = s1.length();
        if (s2.length() < permutationLength) {
            return false;
        }
        final int[] s1Signature = getSignature(s1);
        final int[] s2Signature = getSignature(s2.substring(0, permutationLength));
        if (Arrays.equals(s1Signature, s2Signature)) {
            return true;
        }
        int tailIdx = 0;
        for (char c : s2.substring(permutationLength).toCharArray()) {
            s2Signature[c - 'a']++;
            s2Signature[s2.charAt(tailIdx++) - 'a']--;
            if (Arrays.equals(s1Signature, s2Signature)) {
                return true;
            }
        }
        return false;
    }

    private int[] getSignature(String s) {

        final int[] signature = new int[ALPHABET_LENGTH];
        for (char c : s.toCharArray()) {
            signature[c - 'a']++;  // a->0, b->1, ...
        }
        return signature;
    }
}
