package pl.grzesk075.sandbox.spoj;

import java.util.Scanner;

public class Factorial {

    private Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Factorial().execute();
    }

    private void execute() {
        int rowCount = inputScanner.nextInt();
        inputScanner.nextLine();

        for (int i = 0; i < rowCount; i++) {
            int n = inputScanner.nextInt();
            inputScanner.nextLine();
            long factorial = calculateFactorial(n);
            printFactorial(factorial);
        }
    }

    private void printFactorial(long factorial) {
        char[] digits = String.valueOf(factorial).toCharArray();
        int length = digits.length;
        char tens = '0';
        char ones = digits[length - 1];
        if (length > 1) {
            tens = digits[length - 2];
        }
        System.out.println(String.format("%c %c", tens, ones));
    }

    private long calculateFactorial(int n) {
        long factorial = 1L;
        if (n == 0) {
            n = 1;
        }
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
