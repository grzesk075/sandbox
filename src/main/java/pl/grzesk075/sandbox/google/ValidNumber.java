package pl.grzesk075.sandbox.google;

/**
 * Determine if the number is valid.
 * <p>
 * Problem statement:
 * Given an input string, determine if it makes a valid number or not.
 * For simplicity, assume that white spaces are not present in the input.
 * <p>
 * The most common regex algorithms are of O(N) time complexity.
 */
public class ValidNumber {
    public static boolean isNumber(final String numberString) {
        return numberString.matches("[+\\-]?[0-9]+(\\.[0-9]+)?(e[+\\-]?[0-9]+)?");
    }
}
