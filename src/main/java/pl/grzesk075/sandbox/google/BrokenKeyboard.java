package pl.grzesk075.sandbox.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking algorithm.
 * The backtracking algorithm traverses the search tree recursively, from the root down, in depth-first order.
 * It verifies and abandons branches at any time.
 * Time complexity is quadratic to exponential.
 * Looks O(n*n) for this solution.
 */
public class BrokenKeyboard {

    public static final char BROKEN_KEY = 'e';
    public static final char BROKEN_KEY_RESULT = ' ';

    public List<String> getActualUserInput(final String input, final List<String> dict) {

        final List<String> actualUserInput = new ArrayList<>();
        getActualUserInput("", input, dict, actualUserInput);
        return actualUserInput;
    }

    private void getActualUserInput(String actualInput, String restOfInput,
                                    final List<String> dict, final List<String> actualUserInput) {

        if (restOfInput.isEmpty()) {
            if (verifyInput(actualInput, dict)) {
                actualUserInput.add(actualInput);
            }
            return;
        }
        if (!actualInput.isEmpty() && actualInput.charAt(actualInput.length() - 1) == BROKEN_KEY_RESULT) {
            if (!verifyInput(actualInput, dict)) {
                return;
            }
        }
        final char c = restOfInput.charAt(0);
        if (c == BROKEN_KEY_RESULT) {
            getActualUserInput(actualInput + BROKEN_KEY_RESULT, restOfInput.substring(1), dict, actualUserInput);
            getActualUserInput(actualInput + BROKEN_KEY, restOfInput.substring(1), dict, actualUserInput);
        } else {
            getActualUserInput(actualInput + c, restOfInput.substring(1), dict, actualUserInput);
        }
    }

    private boolean verifyInput(final String actualInput, final List<String> dict) {
        final String[] tokens = actualInput.split(" ");
        for (String token : tokens) {
            if (!token.isEmpty() && !dict.contains(token)) {
                return false;
            }
        }
        return true;
    }
}
