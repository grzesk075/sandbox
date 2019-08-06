package pl.grzesk075.sandbox.codility.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Compute the number of intersections in a sequence of discs.
 */
public class NumberOfDiscIntersections {
    class Solution {
        public int solution(int[] A) {
            int result = 0;
            final int maxAbsolutePosition = A.length - 1;
            SortedMap<Integer, List<Integer>> radiusToCenterPositionSortedList =
                    new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < A.length; i++) {
                addToRadiusMap(radiusToCenterPositionSortedList, i, A[i]);
            }
            for (Map.Entry<Integer, List<Integer>> entry : radiusToCenterPositionSortedList.entrySet()) {
                final Integer radius = entry.getKey();
                final int[] centralPositions = entry.getValue().toArray(new int[]);
                for (int centerPosition : centralPositions) {
                    result += countTheSameRadiusDiscIntersections(radius, centerPosition, centralPositions, maxAbsolutePosition);
                    //result += countSmallerDiscIntersections(radius, centerPosition, radiusToCenterPositionSortedList);
                }
            }
            return result;
        }

        private int countTheSameRadiusDiscIntersections(final int radius, final int centerPosition,
                                                        final int[] centralPositions,
                                                        final int maxAbsolutePosition) {

            if (radius == 0 || centerPosition == maxAbsolutePosition) {
                return 0;
            }
            final int minPosition = centerPosition + 1;
            final int maxPosition = centerPosition + 2 * radius;  // can exceed maxAbsolutePosition
            return countIntercections(Arrays.binarySearch(centralPositions, minPosition),
                    Arrays.binarySearch(centralPositions, maxPosition));
        }

        private int countIntercections(final int binarySearchResultOfMinPosition, final int binarySearchResultOfMaxPosition) {
            if (binarySearchResultOfMinPosition >= 0 && binarySearchResultOfMaxPosition >= 0) {
                return binarySearchResultOfMaxPosition - binarySearchResultOfMinPosition + 1;
            }
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
