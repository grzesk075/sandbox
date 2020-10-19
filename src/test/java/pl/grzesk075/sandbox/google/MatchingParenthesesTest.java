package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchingParenthesesTest {

    @Test
    public void doParenthesesMatch() {
        assertTrue(MatchingParentheses.doParenthesesMatch("abc()def()[as]{}([{a}a])aaa"));
        assertTrue(MatchingParentheses.doParenthesesMatch("abc"));
        assertTrue(MatchingParentheses.doParenthesesMatch("{}[](()()((())))abc"));

        assertFalse(MatchingParentheses.doParenthesesMatch("{}[](()()(((())))abc"));
        assertFalse(MatchingParentheses.doParenthesesMatch("({}[](()()((())))abc"));
        assertFalse(MatchingParentheses.doParenthesesMatch("){}[](()()((())))abc"));
        assertFalse(MatchingParentheses.doParenthesesMatch("{}[](()()((())))abc)"));
        assertFalse(MatchingParentheses.doParenthesesMatch("{}[](()()((())))abc("));
        assertFalse(MatchingParentheses.doParenthesesMatch("{"));
        assertFalse(MatchingParentheses.doParenthesesMatch("s{a"));
        assertFalse(MatchingParentheses.doParenthesesMatch("s}{a"));
        assertFalse(MatchingParentheses.doParenthesesMatch("}"));
        assertFalse(MatchingParentheses.doParenthesesMatch("[(])"));
        assertFalse(MatchingParentheses.doParenthesesMatch("z[a(s]d)f"));
    }
}