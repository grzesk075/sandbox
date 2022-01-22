package pl.grzesk075.sandbox.spoj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * JZLICZ
 */
public class CountCharacters {

    private Map<Character, Integer> charCount = new HashMap<>();

    public void execute() {
        readInputData();
        printOutputData();
    }

    private void readInputData() {
        Scanner consoleIn = new Scanner(System.in);
        int rowCount = consoleIn.nextInt();
        consoleIn.nextLine();
        for (int i = 0; i < rowCount; i++) {
            String line = consoleIn.nextLine();
            for (Character c : line.toCharArray()) {
                if (!Character.isLetter(c)) {
                    continue;
                }
                int newCount = charCount.containsKey(c) ? charCount.get(c) + 1 : 1;
                charCount.put(c, newCount);
            }
        }
    }

    private void printOutputData() {
        charCount.entrySet().stream()
                .map(entry -> String.format("%c %d", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new CountCharacters().execute();
    }
}
