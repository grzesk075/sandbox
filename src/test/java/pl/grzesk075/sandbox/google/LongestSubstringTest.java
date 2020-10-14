package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringTest {

    @Test
    public void getLongestSubstringLengthTest() {
        assertEquals(0, LongestSubstring.getLongestSubstringLength("", 5));
        assertEquals(1, LongestSubstring.getLongestSubstringLength("a", 5));
        assertEquals(3, LongestSubstring.getLongestSubstringLength("abc", 5));
        assertEquals(4, LongestSubstring.getLongestSubstringLength("abac", 5));
        assertEquals(8, LongestSubstring.getLongestSubstringLength("xfabacxf", 5));
        assertEquals(3, LongestSubstring.getLongestSubstringLength("xfabacxf", 2));
        assertEquals(15, LongestSubstring.getLongestSubstringLength("abcdefadcbbaaeeeabcdeffffffffff", 5));
        assertEquals(15, LongestSubstring.getLongestSubstringLength("adcbbaaeeeabcdeffffffffffabcdef", 5));
        assertEquals(15, LongestSubstring.getLongestSubstringLength("ffffffffffabcdefadcbbaaeeeabcde", 5));
    }
}