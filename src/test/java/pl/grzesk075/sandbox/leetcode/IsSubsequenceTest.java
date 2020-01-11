package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsSubsequenceTest {

    @Test
    public void shouldCheckSubsequence() {
        final IsSubsequence isSubsequence = new IsSubsequence();
        assertTrue(isSubsequence.isSubsequence("abc", "abc"));
        assertTrue(isSubsequence.isSubsequence("a", "a"));
        assertTrue(isSubsequence.isSubsequence("aa", "aa"));
        assertTrue(isSubsequence.isSubsequence("abc", "aabbcc"));
        assertTrue(isSubsequence.isSubsequence("abc", "asbsc"));
        assertTrue(isSubsequence.isSubsequence("abc", "agfdasfadsfasbscafdafadfdasfadsfdas"));
        assertTrue(isSubsequence.isSubsequence("", "agfdasfadsfasbscafdafadfdasfadsfdas"));

        assertFalse(isSubsequence.isSubsequence("abc", "bac"));
        assertFalse(isSubsequence.isSubsequence("abc", "ac"));
        assertFalse(isSubsequence.isSubsequence("abc", "acb"));
        assertFalse(isSubsequence.isSubsequence("abc", "b"));
        assertFalse(isSubsequence.isSubsequence("abc", "x"));
        assertFalse(isSubsequence.isSubsequence("abc", "xkljlkjkljhkjlk"));
    }
}