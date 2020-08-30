package pl.grzesk075.sandbox.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find the kth largest element in a number stream.
 * <p>
 * Problem Statement:
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 * The class should have the following two things:​
 * * The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
 * * The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 */
public class KthLargestElementInStream {

    private final int K;

    private final List<Integer> largestNumbers = new ArrayList<>();

    private Integer[] largestNumbersHelperArray;

    public KthLargestElementInStream(final int[] initialNumbers, final int K) {
        this.K = K;

        Arrays.sort(initialNumbers);

        Integer last = null;
        for (int i = initialNumbers.length - 1; i >= 0; i--) {
            final Integer num = Integer.valueOf(initialNumbers[i]);
            if (num.equals(last)) {
                continue;
            }
            last = num;
            largestNumbers.add(num);
            if (largestNumbers.size() == K) {
                break;
            }
        }
    }

    public int add(int num) {
        if (largestNumbersHelperArray == null || largestNumbersHelperArray.length != largestNumbers.size()) {
            largestNumbersHelperArray = new Integer[largestNumbers.size()];
        }
        final int index = Arrays.binarySearch(largestNumbers.toArray(largestNumbersHelperArray), num, Collections.reverseOrder());
        if (index >= 0) {
            return largestNumbers.get(K - 1);
        }
        final int insertionPoint = -index - 1;
        largestNumbers.add(insertionPoint, num);
        if (largestNumbers.size() > K) {
            largestNumbers.remove(K);
        }
        return largestNumbers.get(K - 1);
    }
}
