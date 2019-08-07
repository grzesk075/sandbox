package pl.grzesk075.sandbox.codility.sorting;

import java.util.*;

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
                final Integer r = entry.getKey();
                final int[] centralPositions = entry.getValue().stream().mapToInt(i -> i).toArray();
                for (int centerPosition : centralPositions) {
                    result += countTheSameRadiusDiscIntersections(r, centerPosition, centralPositions, maxAbsolutePosition);
                    result += countSmallerDiscIntersections(r, centerPosition, radiusToCenterPositionSortedList);
                }
            }
            return result;
        }

        private int countSmallerDiscIntersections(final int radius, final int centerPosition,
                                                  final SortedMap<Integer, List<Integer>> radiusToCenterPositionSortedList) {

            int result = 0;
            final SortedMap<Integer, List<Integer>> smallerRadiusesMap = radiusToCenterPositionSortedList.tailMap(radius);
            for (Map.Entry<Integer, List<Integer>> entry : smallerRadiusesMap.entrySet()) {
                final Integer r = entry.getKey();
                if (r == radius) {
                    continue;
                }
                final int[] centralPositions = entry.getValue().stream().mapToInt(i -> i).toArray();
                result += countDifferentRadiusDiscIntersections(radius, centerPosition, r, centralPositions);
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

        private int countDifferentRadiusDiscIntersections(final int radius, final int centerPosition,
                                                          final int r, final int[] centralPositions) {

            assert radius > r;
            final int minPosition = centerPosition - radius - r;  // can be lower than 0
            final int maxPosition = centerPosition + radius + r;  // can exceed maxAbsolutePosition
            return countIntercections(Arrays.binarySearch(centralPositions, minPosition),
                    Arrays.binarySearch(centralPositions, maxPosition));
        }

        private int countIntercections(final int binarySearchResultOfMinPosition, final int binarySearchResultOfMaxPosition) {
            if (binarySearchResultOfMinPosition >= 0 && binarySearchResultOfMaxPosition >= 0) {
                return binarySearchResultOfMaxPosition - binarySearchResultOfMinPosition + 1;
            }
            if (binarySearchResultOfMinPosition < 0 && binarySearchResultOfMaxPosition <= 0) {
                return binarySearchResultOfMinPosition - binarySearchResultOfMaxPosition;
            }
            if (binarySearchResultOfMinPosition < 0) {
                return binarySearchResultOfMaxPosition + binarySearchResultOfMinPosition + 1;
            }
            return -binarySearchResultOfMaxPosition - 1 - binarySearchResultOfMinPosition;
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
