package pl.grzesk075.sandbox.leetcode;

public abstract class LongestPalindrome {
    public static int getLongestPalindromeLength(final String s){
        if(s.isEmpty()){
            return 0;
        }
        int longest = 1;
        // pos - position of middel point of searched palindrome a<1>aabb
        // shift is distance in letters from middle point
        for (int pos = 1; pos < s.length(); pos++) {
            if (longest >= calcMaxPosiblePalindromeLength(pos, s.length())) {
                break;
            }
            boolean breakEven = false;
            boolean breakOdd = false;
            for (int shift = 1; pos - shift >= 0 && pos + shift - 1 < s.length() && !(breakEven && breakOdd); shift++) {
                int palindromeLength = 0;
                String palindrome = null;
                if (!breakEven) { // aa
                    if (s.charAt(pos - shift) != s.charAt(pos + shift - 1)) {
                        breakEven = true;
                    } else {
                        palindromeLength = 2 * shift;
                        palindrome = s.substring(pos - shift, pos + shift);
                    }
                }
                if (!breakOdd && pos - shift - 1 >= 0) { // aaa
                    if (s.charAt(pos - shift - 1) != s.charAt(pos + shift - 1)) {
                        breakOdd = true;
                    } else {
                        palindromeLength = 2 * shift + 1;
                        palindrome = s.substring(pos - shift - 1, pos + shift);
                    }
                }
                if (palindromeLength > longest) {
                    longest = palindromeLength;
                    System.out.println("Found longer palindrome: " + palindrome);
                }
            }
        }
        return longest;
    }

    private static int calcMaxPosiblePalindromeLength(final int pos, final int length) {
        final int charsToBeginning = pos;
        final int charsToEnd = length - pos;

        if (charsToBeginning <= charsToEnd) {
            return 2 * charsToBeginning;
        } else {
            return 2 * charsToEnd + 1;
        }
    }
}
