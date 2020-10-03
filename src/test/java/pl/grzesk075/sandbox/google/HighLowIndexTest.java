package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HighLowIndexTest {

    @Test
    public void findHighAndLowIndicesTest() {
        int[] a1 = new int[]{Integer.MIN_VALUE, -5, -4, 9, Integer.MAX_VALUE};
        int[] a2 = new int[]{Integer.MIN_VALUE, -5};
        int[] a3 = new int[]{Integer.MAX_VALUE};
        int[] a4 = new int[]{0};
        int[] a5 = new int[]{Integer.MIN_VALUE, -5, -4, 0, 9, Integer.MAX_VALUE};
        int[] a6 = new int[]{0, 0, 0, 0, 0};
        int[] a7 = new int[]{-1, 0, 0, 0, 0, 0, 9, 9, 9};
        int[] a8 = new int[]{0, 0, 0, 0, 0, 9, 9, 9};
        int[] a9 = new int[]{-3, -3, -3, 0, 0, 0, 0, 0};

        HighLowIndex.Indices highAndLowIndices = HighLowIndex.findHighAndLowIndices(a1, 0);
        assertEquals(-1, highAndLowIndices.low);
        assertEquals(-1, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a2, 0);
        assertEquals(-1, highAndLowIndices.low);
        assertEquals(-1, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a3, 0);
        assertEquals(-1, highAndLowIndices.low);
        assertEquals(-1, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a4, 0);
        assertEquals(0, highAndLowIndices.low);
        assertEquals(0, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a5, 0);
        assertEquals(3, highAndLowIndices.low);
        assertEquals(3, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a6, 0);
        assertEquals(0, highAndLowIndices.low);
        assertEquals(4, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a7, 0);
        assertEquals(1, highAndLowIndices.low);
        assertEquals(5, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a8, 0);
        assertEquals(0, highAndLowIndices.low);
        assertEquals(4, highAndLowIndices.high);
        highAndLowIndices = HighLowIndex.findHighAndLowIndices(a9, 0);
        assertEquals(3, highAndLowIndices.low);
        assertEquals(7, highAndLowIndices.high);
    }
}