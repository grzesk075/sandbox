package pl.grzesk075.sandbox.leetcode;

public class LongestPalindrome {
    public int getLongestPalindromeLength(final String s){
        if(s.isEmpty()){
            return 0;
        }
        int longest = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <=1 && i+j<s.length(); j++) {

            }
        }
        return longest;
    }
}
