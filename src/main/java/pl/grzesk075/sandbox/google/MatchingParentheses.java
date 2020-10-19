package pl.grzesk075.sandbox.google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * O(n), stack.
 */
public class MatchingParentheses {

    public static final String OPEN = "([{";
    public static final String CLOSE = ")]}";

    public static boolean doParenthesesMatch(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            final int open = OPEN.indexOf((int) c);
            final int close = CLOSE.indexOf((int) c);
            if (open >= 0) {
                stack.push(c);
            } else if (close >= 0) {
                char complementary = OPEN.charAt(close);
                if (stack.isEmpty() || stack.pop() != complementary) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
