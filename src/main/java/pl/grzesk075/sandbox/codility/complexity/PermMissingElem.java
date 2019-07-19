package pl.grzesk075.sandbox.codility.complexity;

/**
 * A is int array of N elements
 * N is an integer within the range [0..100,000]
 * the elements of A are all distinct
 * each element of array A is an integer within the range [1..(N + 1)]
 * so one element is "missing" - return it
 */
public class PermMissingElem {
    class Solution {
        public int solution(int[] A) {
            final int N = A.length;
            final boolean[] existent = new boolean[N + 2];
            for (int i = 0; i < N; i++) {
                existent[A[i]] = true;
            }
            for (int i = 1; i <= N + 1; i++) {
                if (!existent[i]) {
                    return i;
                }
            }
            throw new IllegalStateException();
        }
    }
}
