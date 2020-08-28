package pl.grzesk075.sandbox.google;

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

    private final int[] largestNumbers;

    public KthLargestElementInStream(final int[] initialNumbers, final int K) {
        this.K = K;
        largestNumbers = new int[K];


    }

    public int add(int num) {


        return largestNumbers[K];
    }
}
