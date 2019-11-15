package pl.grzesk075.sandbox.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class ReverseLinkedListTest {

    @Test
    public void shouldRevertLinkedList() {
        final LinkedList linkedList = new LinkedList(Arrays.asList(4, 3, 2, 1));
        ReverseLinkedList.solution(linkedList);
        assertEquals(Arrays.asList(1, 2, 3, 4), linkedList);

        final LinkedList linkedList1 = new LinkedList(Arrays.asList(4));
        ReverseLinkedList.solution(linkedList1);
        assertEquals(Arrays.asList(4), linkedList1);

        final LinkedList linkedList2 = new LinkedList(Arrays.asList(4,5));
        ReverseLinkedList.solution(linkedList2);
        assertEquals(Arrays.asList(5,4), linkedList2);

        final LinkedList linkedList3 = new LinkedList();
        ReverseLinkedList.solution(linkedList3);
        assertEquals(new LinkedList(), linkedList3);
    }
}