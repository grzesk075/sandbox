package pl.grzesk075.sandbox.leetcode;

public class LongestPalindrome {
    public static int getLongestPalindromeLength(final String s){
        if(s.isEmpty()){
            return 0;
        }
        int longest = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1, shift = 0; i - j - shift > 0 && i + j - 1 < s.length(); j++) {

            }
        }
        return longest;
    }
}
