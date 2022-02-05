package pl.grzesk075.sandbox.spoj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Prints prime numbers.
 * Input:
 * 2
 * 1 10
 * 3 5
 *
 * Output:
 * 2
 * 3
 * 5
 * 7
 *
 * 3
 * 5
 */
public class PrimeGenerator {

    private int[][] mn;

    private boolean[] notPrimes;

    private int maxNumber;

    private void execute() {
        loadInput();
        markNotPrimes();
        printOutput();
    }

    private void loadInput() {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        mn = new int[count][2];

        for (int i = 0; i < count; i++) {
            mn[i][0] = scanner.nextInt();
            mn[i][1] = scanner.nextInt();
            scanner.nextLine();
            maxNumber = mn[i][1] > maxNumber ? mn[i][1] : maxNumber;
        }
        notPrimes = new boolean[maxNumber + 1];
        notPrimes[0] = true;
        notPrimes[1] = true;
    }

    private void markNotPrimes() {
        for (int i = 2; i <= maxNumber / 2; i++) {
            if (notPrimes[i]) {
                continue;
            }
            int notPrime = i + i;
            while (notPrime <= maxNumber) {
                notPrimes[notPrime] = true;
                notPrime += i;
            }
        }
    }

    private void printOutput() {
        Arrays.stream(mn).flatMap(this::getPrimes).forEach(System.out::println);
    }

    private Stream<String> getPrimes(int[] mn) {
        Stream.Builder<String> builder = Stream.builder();
        for (int i = mn[0]; i <= mn[1]; i++) {
            if (!notPrimes[i]) {
                builder.add(String.valueOf(i));
            }
        }
        builder.add("");
        return builder.build();
    }

    public static void main(String[] args) {
        new PrimeGenerator().execute();
    }
}
