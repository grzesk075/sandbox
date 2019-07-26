package pl.grzesk075.sandbox.codility.sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);  // O(N * log(N))
            int p1 = A[0] * A[1] * A[A.length - 1];
            int p2 = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
            if (p2 > p1) {
                return p2;
            } else {
                return p1;
            }
        }
    }
}
