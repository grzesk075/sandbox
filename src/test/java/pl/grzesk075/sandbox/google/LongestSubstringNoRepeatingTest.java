package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringNoRepeatingTest {

    @Test
    public void canBeRearrangedTest() {
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("a"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("ab"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("abc"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("abaca"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("ababab"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("abba"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("aba"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("aab"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("abcdef"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("aaaaaabcdef"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("bcdefaaaaaa"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("aaabcdefaaa"));
        assertTrue(LongestSubstringNoRepeating.canBeRearranged("bababbaba"));

        assertFalse(LongestSubstringNoRepeating.canBeRearranged("aaabcdefaaaa"));
        assertFalse(LongestSubstringNoRepeating.canBeRearranged("aaabcadefaaa"));
        assertFalse(LongestSubstringNoRepeating.canBeRearranged("aaaabcdefaaa"));
        assertFalse(LongestSubstringNoRepeating.canBeRearranged("aa"));
        assertFalse(LongestSubstringNoRepeating.canBeRearranged("bababbabab"));
    }
}