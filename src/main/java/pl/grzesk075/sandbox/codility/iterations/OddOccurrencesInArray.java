package pl.grzesk075.sandbox.codility.iterations;

import java.util.Arrays;

public class OddOccurrencesInArray {
    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            int occurrencesCount = 1;
            int previousValue = A[0];
            for (int i = 1; i < A.length; i++) {
                if (A[i] == previousValue) {
                    occurrencesCount++;
                } else if (occurrencesCount % 2 == 1) {
                    return previousValue;
                } else {
                    occurrencesCount = 1;
                    previousValue = A[i];
                }
            }
            return previousValue;
        }
    }
}
