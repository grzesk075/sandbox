package pl.grzesk075.sandbox.google;

import java.util.ArrayList;
import java.util.List;

public class BrokenKeyboard {
    public List<String> getActualUserInput(final String input, final List<String> dict) {
        final List<String> actualUserInput = new ArrayList<>();

        getActualUserInput("", input, dict, actualUserInput);

        return actualUserInput;
    }

    private void getActualUserInput(String actualInput, String restOfInput,
                                    final List<String> dict, final List<String> actualUserInput) {

//        if (!verifyInput(actualInput, dict)) {
//            return;
//        }

        for (char c : restOfInput.toCharArray()) {
            if (c == ' ') {
                getActualUserInput(actualInput + ' ', restOfInput.substring(1), dict, actualUserInput);
                getActualUserInput(actualInput + 'e', restOfInput.substring(1), dict, actualUserInput);
            } else {
                actualInput = actualInput + c;
                restOfInput = restOfInput.substring(1);
            }
        }
        if (verifyInput(actualInput, dict)) {
            actualUserInput.add(actualInput);
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
