package pl.grzesk075.sandbox.codility.sorting;

import java.util.HashSet;
import java.util.Set;

/**
 * Compute number of distinct values in an array.
 */
public class Distinct {
    /**
     * Codility reports O(N*log(N)) or O(N). This is enough. Large intake takes 0.4s.
     */
    class Solution {
        public int solution(int[] A) {
            final Set<Integer> distinctValues = new HashSet<>(A.length / 2);
            for (Integer i : A) {
                distinctValues.add(i);
            }
            return distinctValues.size();
        }
    }

    /**
     * Should be linear, but Codility reports also O(N*log(N)) or O(N).
     * Large intake takes 0.2s (two times faster than with HashSet).
     */
    class FasterSolution {
        public int solution(int[] A) {
            int distinctCount = 0;
            final boolean[] existingValues = new boolean[2000001];
            for (int v : A) {
                final int i = v + 1000000;
                if (existingValues[i]) {
                    continue;
                }
                existingValues[i] = true;
                distinctCount++;
            }
            return distinctCount;
        }
    }
}
