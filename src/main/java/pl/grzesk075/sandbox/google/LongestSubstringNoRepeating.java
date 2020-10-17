package pl.grzesk075.sandbox.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement:
 * Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
 *
 * Linear O(n). Counting occurrences of each letter and applying results in arithmetic formula.
 * When more than half (ceiling) is occupied by one letter, letters can't be rearranged to keep them separate.
 */
public class LongestSubstringNoRepeating {
    public static boolean canBeRearranged(String s) {
        Map<Character, Integer> char2Count = new HashMap<>();
        for (char c : s.toCharArray()) {
            final Integer count = char2Count.get(c);
            if (count == null) {
                char2Count.put(c, 1);
            } else {
                char2Count.put(c, count + 1);
            }
        }
        int maxCount = (s.length() + 1) / 2;
        for (Integer count : char2Count.values()) {
            if (count > maxCount) {
                return false;
            }
        }
        return true;
    }
}
