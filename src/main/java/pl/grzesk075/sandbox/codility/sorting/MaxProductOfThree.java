package pl.grzesk075.sandbox.codility.sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);  // O(N * log(N))
            //A = countingSort(A, -1000, 1000);  // should be O(n), but Codility reports O(N * log(N))
            int p1 = A[0] * A[1] * A[A.length - 1];
            int p2 = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
            if (p2 > p1) {
                return p2;
            } else {
                return p1;
            }
        }

        private int[] countingSort(final int[] array, final int minValue, final int maxValue) {
            final int[] counters = new int[maxValue - minValue + 1];
            for (int i = 0; i < array.length; i++) {
                counters[array[i] - minValue]++;
            }
            final int[] result = new int[array.length];
            int resultIndex = 0;
            for (int i = 0; i < counters.length; i++) {
                for (int j = 0; j < counters[i]; j++) {
                    result[resultIndex++] = i + minValue;
                }
            }
            return result;
        }
    }
}
