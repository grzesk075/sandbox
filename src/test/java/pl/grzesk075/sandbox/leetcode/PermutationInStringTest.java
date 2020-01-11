package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationInStringTest {

    @Test
    public void shouldCheckInclusion() {
        final PermutationInString permutationInString = new PermutationInString();
        assertTrue(permutationInString.checkInclusion("a","a"));
        assertTrue(permutationInString.checkInclusion("z","z"));
        assertTrue(permutationInString.checkInclusion("z","adadadzadadaddaz"));
        assertTrue(permutationInString.checkInclusion("ab","eidbaooo"));

        assertFalse(permutationInString.checkInclusion("z","a"));
        assertFalse(permutationInString.checkInclusion("a","z"));
        assertFalse(permutationInString.checkInclusion("zz","z"));
        assertFalse(permutationInString.checkInclusion("ab","eidboaoo"));
    }
}