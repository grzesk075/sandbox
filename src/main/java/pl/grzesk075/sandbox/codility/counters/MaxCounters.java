package pl.grzesk075.sandbox.codility.counters;

/**
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 * O(n+m)
 */
public class MaxCounters {
    class Solution {
        public int[] solution(int N, int[] A) {
            int countersShift = 0;
            int maxCounter = 0;
            int[] counters = new int[N + 1];  // indexed by X, values above countersShift
            int[] clearenceByCountersShift = new int[N + 1];  // as counters
            for (int K = 0; K < A.length; K++) {
                int X = A[K];
                if (X == N + 1) {
                    countersShift = maxCounter;
                } else {
                    if (clearenceByCountersShift[X] != countersShift) {
                        counters[X] = 0;
                        clearenceByCountersShift[X] = countersShift;
                    }
                    counters[X]++;
                    if (counters[X] + countersShift > maxCounter) {
                        maxCounter = counters[X] + countersShift;
                    }
                }
            }
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                final int X = i + 1;
                if (clearenceByCountersShift[X] != countersShift) {
                    result[i] = countersShift;
                    continue;
                }
                result[i] = counters[X] + countersShift;
            }
            return result;
        }
    }
}
