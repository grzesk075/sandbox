package pl.grzesk075.sandbox.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        final List<Integer> result = new ArrayList<>();
        final StringBuilder kReversed = new StringBuilder(String.valueOf(K)).reverse();
        int i = 0;
        int carry = 0;
        int aPointer = A.length - 1 - i;
        final int kLength = kReversed.length();
        do {
            final int aDigit = aPointer >= 0 ? A[aPointer] : 0;
            final int kDigit = kLength > i ? kReversed.charAt(i) - '0' : 0;
            final int sum = aDigit + kDigit + carry;
            final int resultDigit = sum % 10;
            carry = sum / 10;
            result.add(resultDigit);
            i++;
            aPointer = A.length - 1 - i;
        } while (carry > 0 || aPointer >= 0 || kLength > i);
        Collections.reverse(result);
        return result;
    }

    public List<Integer> addToArrayFormLeetCode(int[] A, int K) {
        List res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }
}
