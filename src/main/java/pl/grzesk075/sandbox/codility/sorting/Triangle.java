package pl.grzesk075.sandbox.codility.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Determine whether a triangle can be built from a given set of edges.
 * O(N*log(N))
 */
public class Triangle {
    class Solution {
        public int solution(int[] A) {
            List<Integer> positiveEdges = new ArrayList<>(A.length / 2);
            for (int e : A) {
                if (e > 0) {
                    positiveEdges.add(e);
                }
            }
            Collections.sort(positiveEdges);
            for (int i = 0; i < positiveEdges.size() - 2; i++) {
                long p = positiveEdges.get(i).longValue();
                long q = positiveEdges.get(i + 1).longValue();
                long r = positiveEdges.get(i + 2).longValue();
                if (p + q > r) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
