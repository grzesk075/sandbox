package pl.grzesk075.sandbox.codility.sorting;

import java.util.*;

/**
 * Compute the number of intersections in a sequence of discs.
 */
public class NumberOfDiscIntersections {
    class Solution {
        public int solution(int[] A) {
            int result = 0;
            SortedMap<Integer, List<Integer>> radiusToCenterPositionSortedList =
                    new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < A.length; i++) {
                addToRadiusMap(radiusToCenterPositionSortedList, i, A[i]);
            }
            for (Map.Entry<Integer, List<Integer>> entry : radiusToCenterPositionSortedList.entrySet()) {
                final Integer radius = entry.getKey();
                final List<Integer> centralPositions = entry.getValue();
                for (int centerPosition : centralPositions) {
                    result += countTheSameRadiusDiscIntersections(radius, centerPosition, centralPositions);
                    result += countSmallerDiscIntersections(radius, centerPosition, radiusToCenterPositionSortedList);
                }
            }
            return result;
        }

        private void addToRadiusMap(final SortedMap<Integer, List<Integer>> radiusToCenterPositionSortedList,
                                    final int centerPosition, final int radius) {

            List<Integer> centerPositionSortedList = radiusToCenterPositionSortedList.get(radius);
            if (centerPositionSortedList == null) {
                centerPositionSortedList = new ArrayList<>();
                radiusToCenterPositionSortedList.put(radius, centerPositionSortedList);
            }
            centerPositionSortedList.add(centerPosition);
        }
    }
}
