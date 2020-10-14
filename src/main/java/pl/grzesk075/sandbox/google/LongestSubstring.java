package pl.grzesk075.sandbox.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest substring with no more than ‘k’ distinct characters.
 * <p>
 * Problem statement:
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Caterpillar method O(n).
 */
public class LongestSubstring {
    public static int getLongestSubstringLength(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int lowIdx = -1;
        int len = 0;
        int maxLen = 0;
        for (int highIdx = 0; highIdx < s.length(); highIdx++) {
            final char c = s.charAt(highIdx);
            final Integer cnt = m.get(c);
            if (cnt == null) {
                m.put(c, 1);
            } else {
                m.put(c, cnt + 1);
            }
            len++;
            if (m.size() > k) {
                do {
                    lowIdx++;
                    len--;
                    final char rem = s.charAt(lowIdx);
                    final Integer remCnt = m.get(rem);
                    if (remCnt == 1) {
                        m.remove(rem);
                    } else {
                        m.put(rem, remCnt - 1);
                    }
                } while (m.size() > k);
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
