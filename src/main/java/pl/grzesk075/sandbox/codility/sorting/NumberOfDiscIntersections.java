package pl.grzesk075.sandbox.codility.sorting;

import java.util.*;

/**
 * Compute the number of intersections in a sequence of discs.
 */
public class NumberOfDiscIntersections {
    class Solution {

        public static final int MAX_RESULT = 10000000;

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
                    result += countSmallerDiscIntersections(r, centerPosition, radiusToCenterPositionSortedList, maxAbsolutePosition);
                    if (result > MAX_RESULT) {
                        break;
                    }
                }
            }
            return result > MAX_RESULT ? -1 : result;
        }

        private int countSmallerDiscIntersections(final int radius, final int centerPosition,
                                                  final SortedMap<Integer, List<Integer>> radiusToCenterPositionSortedList,
                                                  final int maxAbsolutePosition) {
            int result = 0;
            final SortedMap<Integer, List<Integer>> smallerRadiusesMap = radiusToCenterPositionSortedList.tailMap(radius);
            for (Map.Entry<Integer, List<Integer>> entry : smallerRadiusesMap.entrySet()) {
                final Integer r = entry.getKey();
                if (r == radius) {
                    continue;
                }
                final int[] centralPositions = entry.getValue().stream().mapToInt(i -> i).toArray();
                result += countDifferentRadiusDiscIntersections(radius, centerPosition, r, centralPositions, maxAbsolutePosition);
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
            final int maxPosition = (long) centerPosition + 2L * (long) radius > (long) maxAbsolutePosition ?
                    maxAbsolutePosition : centerPosition + 2 * radius;
            return countIntercections(Arrays.binarySearch(centralPositions, minPosition),
                    Arrays.binarySearch(centralPositions, maxPosition));
        }

        private int countDifferentRadiusDiscIntersections(final int radius, final int centerPosition,
                                                          final int r, final int[] centralPositions,
                                                          final int maxAbsolutePosition) {

            assert radius > r;
            final int minPosition = (long) centerPosition - radius - r < 0 ? 0 : centerPosition - radius - r;
            final int maxPosition = (long) centerPosition + radius + r > maxAbsolutePosition ?
                    maxAbsolutePosition : centerPosition + radius + r;
            return countIntercections(Arrays.binarySearch(centralPositions, minPosition),
                    Arrays.binarySearch(centralPositions, maxPosition));
        }

        private int countIntercections(final int binarySearchResultOfMinPosition, final int binarySearchResultOfMaxPosition) {
            if (binarySearchResultOfMinPosition >= 0 && binarySearchResultOfMaxPosition >= 0) {
                return binarySearchResultOfMaxPosition - binarySearchResultOfMinPosition + 1;
            }
            if (binarySearchResultOfMinPosition < 0 && binarySearchResultOfMaxPosition < 0) {
                return binarySearchResultOfMinPosition - binarySearchResultOfMaxPosition;
            }
            if (binarySearchResultOfMinPosition < 0) {
                return binarySearchResultOfMaxPosition + binarySearchResultOfMinPosition + 2;
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
