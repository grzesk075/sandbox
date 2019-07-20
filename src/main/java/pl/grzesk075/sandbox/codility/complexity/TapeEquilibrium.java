package pl.grzesk075.sandbox.codility.complexity;

/**
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 * N is an integer within the range [2..100,000]
 * each element of array A is an integer within the range [−1,000..1,000]
 * O(n)
 */
public class TapeEquilibrium {
    class Solution {
        public int solution(int[] A) {

            int minP = 1;
            int maxP = A.length - 1;
            int leftSum = A[0];
            int rightSum = 0;
            for (int i = 1; i < A.length; i++) {
                rightSum += A[i];
            }
            int minDifference = Math.abs(leftSum - rightSum);  // absolute difference
            for (int p = minP + 1; p <= maxP; p++) {
                int v = A[p - 1];
                leftSum += v;
                rightSum -= v;
                int difference = Math.abs(leftSum - rightSum);
                if (difference < minDifference) {
                    minDifference = difference;
                }
            }
            return minDifference;
        }
    }
}
