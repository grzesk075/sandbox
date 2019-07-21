package pl.grzesk075.sandbox.codility.conters;

/**
 * Check whether array A is a permutation.
 */
public class PermCheck {
    class Solution {
        public int solution(int[] A) {
            final int N = A.length;
            final int[] counters = new int[N + 1];
            for (int i = 0; i < N; i++) {
                if (A[i] > N) {
                    return 0;
                }
                counters[A[i]]++;
            }
            for (int i = 1; i <= N; i++) {
                if (counters[i] != 1) {
                    return 0;
                }
            }
            return 1;
        }
    }
}
