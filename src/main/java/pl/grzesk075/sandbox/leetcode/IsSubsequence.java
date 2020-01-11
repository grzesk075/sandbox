package pl.grzesk075.sandbox.leetcode;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIdx = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(sIdx)) {
                if (++sIdx == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
