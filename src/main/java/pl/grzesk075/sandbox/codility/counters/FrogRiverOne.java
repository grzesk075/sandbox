package pl.grzesk075.sandbox.codility.counters;

/**
 * Find the earliest time when a frog can jump to the other side of a river.
 * O(n+2x)
 */
public class FrogRiverOne {
    class Solution {
        public int solution(int X, int[] A) {
            int[] minTimeOfPosition = new int[X + 1];
            for (int i = 1; i < X + 1; i++) {
                minTimeOfPosition[i] = -1;
            }
            for (int time = 0; time < A.length; time++) {
                final int position = A[time];
                if (position > X || minTimeOfPosition[position] > -1) {
                    continue;
                }
                minTimeOfPosition[position] = time;
            }
            int jumpTime = -1;
            for (int position = 1; position < X + 1; position++) {
                final int time = minTimeOfPosition[position];
                if (time == -1) {
                    return -1;
                }
                if (time > jumpTime) {
                    jumpTime = time;
                }
            }
            return jumpTime;
        }
    }
}
