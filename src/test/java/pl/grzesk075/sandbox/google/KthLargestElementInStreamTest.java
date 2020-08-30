package pl.grzesk075.sandbox.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementInStreamTest {

    @Test
    public void shouldCreateEmptyInstanceAndAddNumbers() {
        final KthLargestElementInStream kthLargestElementInStream = new KthLargestElementInStream(new int[0], 1);
        final int num0 = -10;
        assertEquals(num0, kthLargestElementInStream.add(num0));
        assertEquals(num0, kthLargestElementInStream.add(num0));
        final int num1 = 0;
        assertEquals(num1, kthLargestElementInStream.add(num1));
        final int num2 = Integer.MAX_VALUE;
        assertEquals(num2, kthLargestElementInStream.add(num2));
        assertEquals(num2, kthLargestElementInStream.add(num1));
        assertEquals(num2, kthLargestElementInStream.add(num0));
    }

    @Test
    public void shouldCreateInstanceAndAddNumbers() {
        final int num = -19;
        final KthLargestElementInStream kthLargestElementInStream =
                new KthLargestElementInStream(new int[]{0, 0, 0, 3, 3, 3, -10, num, 9, 24}, 7);
        final int num0 = -100;
        assertEquals(num0, kthLargestElementInStream.add(num0));
        assertEquals(num0, kthLargestElementInStream.add(num0));
        final int num1 = 0;
        assertEquals(num0, kthLargestElementInStream.add(num1));
        final int num2 = Integer.MAX_VALUE;
        assertEquals(num, kthLargestElementInStream.add(num2));
        assertEquals(num, kthLargestElementInStream.add(num2));
    }
}