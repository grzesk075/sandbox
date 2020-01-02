package pl.grzesk075.sandbox.leetcode;

public class SortByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int evenPointer = 0;
        int oddPointer = A.length - 1;
        for (int a : A) {
            if (a % 2 == 0) {
                result[evenPointer++] = a;
            } else {
                result[oddPointer--] = a;
            }
        }
        return result;
    }
}
