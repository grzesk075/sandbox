package pl.grzesk075.sandbox.amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrioInGraphTest {

    @Test
    public void getBiggestSum5() {
        int numberOfNodes = 9;
        int[] fromNodes = new int[]{0, 1, 1, 2, 2, 2, 3, 3, 6, 7};
        int[] toNodes = new int[]{1, 2, 3, 3, 6, 7, 4, 5, 7, 8};
        assertEquals(5, TrioInGraph.getBiggestSum(numberOfNodes, fromNodes, toNodes));
    }

    @Test
    public void getBiggestSum_1() {
        int numberOfNodes = 10;
        int[] fromNodes = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 5, 6, 4};
        int[] toNodes = new int[]{1, 7, 2, 3, 4, 5, 4, 7, 9, 8, 6};
        assertEquals(-1, TrioInGraph.getBiggestSum(numberOfNodes, fromNodes, toNodes));
    }
}