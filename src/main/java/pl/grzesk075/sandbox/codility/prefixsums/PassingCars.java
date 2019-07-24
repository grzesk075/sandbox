package pl.grzesk075.sandbox.codility.prefixsums;

public class PassingCars {
    class Solution {
        public int solution(int[] A) {
            final int N = A.length;
            final int[] prefixSums = new int[N + 1];
            for (int i = 0; i < N; i++) {
                prefixSums[i + 1] = prefixSums[i] + A[i];
            }
            final int totalSum = prefixSums[N];
            int passingCars = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] == 1) {
                    continue;
                }
                passingCars+=totalSum-prefixSums[i+1];
            }
            return passingCars;
        }
    }
}
