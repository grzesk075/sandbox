package pl.grzesk075.sandbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsInString {

    public static final int ALPHABET_LENGTH = 'z' - 'a' + 1;

    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> indices = new ArrayList<>();
        final int permutationLength = p.length();
        if (s.length() < permutationLength) {
            return indices;
        }
        final int[] s1Signature = getSignature(p);
        final int[] s2Signature = getSignature(s.substring(0, permutationLength));
        int tailIdx = 0;
        if (Arrays.equals(s1Signature, s2Signature)) {
            indices.add(tailIdx);
        }
        for (char c : s.substring(permutationLength).toCharArray()) {
            s2Signature[c - 'a']++;
            s2Signature[s.charAt(tailIdx++) - 'a']--;
            if (Arrays.equals(s1Signature, s2Signature)) {
                indices.add(tailIdx);
            }
        }
        return indices;
    }

    private int[] getSignature(String s) {

        final int[] signature = new int[ALPHABET_LENGTH];
        for (char c : s.toCharArray()) {
            signature[c - 'a']++;  // a->0, b->1, ...
        }
        return signature;
    }
}
