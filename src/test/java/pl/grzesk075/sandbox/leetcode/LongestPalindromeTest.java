package pl.grzesk075.sandbox.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromeTest {

    @Test
    public void shouldFindLongestPalindromeLength() {
        assertEquals(0, LongestPalindrome.getLongestPalindromeLength(""));
        assertEquals(1, LongestPalindrome.getLongestPalindromeLength("a"));
        assertEquals(1, LongestPalindrome.getLongestPalindromeLength("abcdef"));
        assertEquals(2, LongestPalindrome.getLongestPalindromeLength("aabcdef"));
        assertEquals(2, LongestPalindrome.getLongestPalindromeLength("abbcdef"));
        assertEquals(2, LongestPalindrome.getLongestPalindromeLength("abccdef"));
        assertEquals(2, LongestPalindrome.getLongestPalindromeLength("abcddef"));
        assertEquals(2, LongestPalindrome.getLongestPalindromeLength("abcdeef"));
        assertEquals(2, LongestPalindrome.getLongestPalindromeLength("abcdeff"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("aaabb"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("bbaaa"));
        assertEquals(4, LongestPalindrome.getLongestPalindromeLength("aaaab"));
        assertEquals(4, LongestPalindrome.getLongestPalindromeLength("baaaa"));
        assertEquals(5, LongestPalindrome.getLongestPalindromeLength("aaaaa"));
        assertEquals(6, LongestPalindrome.getLongestPalindromeLength("aaaaaa"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("aaabcdef"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abcccdef"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abcdefff"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abacdef"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abcbdef"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abcdcef"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abcdedf"));
        assertEquals(3, LongestPalindrome.getLongestPalindromeLength("abcdefe"));
        assertEquals(4, LongestPalindrome.getLongestPalindromeLength("abbacdef"));
        assertEquals(4, LongestPalindrome.getLongestPalindromeLength("abcddcef"));
        assertEquals(4, LongestPalindrome.getLongestPalindromeLength("abcdeffe"));
        assertEquals(5, LongestPalindrome.getLongestPalindromeLength("abcbadef"));
        assertEquals(5, LongestPalindrome.getLongestPalindromeLength("abcdcbef"));
        assertEquals(5, LongestPalindrome.getLongestPalindromeLength("abcdefed"));
        assertEquals(6, LongestPalindrome.getLongestPalindromeLength("abccba"));
        assertEquals(6, LongestPalindrome.getLongestPalindromeLength("sdfabccbarty"));
        assertEquals(6, LongestPalindrome.getLongestPalindromeLength("abccbaert"));
        assertEquals(6, LongestPalindrome.getLongestPalindromeLength("werabccba"));
    }
}