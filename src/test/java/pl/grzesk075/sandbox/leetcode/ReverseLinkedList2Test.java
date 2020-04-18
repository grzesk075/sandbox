package pl.grzesk075.sandbox.leetcode;

import org.junit.Before;
import org.junit.Test;
import pl.grzesk075.sandbox.leetcode.ReverseLinkedList2.ListNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseLinkedList2Test {

    private static ListNode head;

    @Before
    public void assignHead() {
        head = new ListNode(1);
        ListNode listNode = head;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
    }

    @Test
    public void reverseBetween23() {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        final ListNode actual = reverseLinkedList2.reverseBetween(head, 2, 3);
        final int[] expected = {1, 3, 2, 4, 5};
        assertResult(expected, actual);
    }

    @Test
    public void reverseBetween11() {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        final ListNode actual = reverseLinkedList2.reverseBetween(head, 1, 1);
        final int[] expected = {1, 2, 3, 4, 5};
        assertResult(expected, actual);
    }

    @Test
    public void reverseBetween12() {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        final ListNode actual = reverseLinkedList2.reverseBetween(head, 1, 2);
        final int[] expected = {2, 1, 3, 4, 5};
        assertResult(expected, actual);
    }

    @Test
    public void reverseBetween45() {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        final ListNode actual = reverseLinkedList2.reverseBetween(head, 4, 5);
        final int[] expected = {1, 2, 3, 5, 4};
        assertResult(expected, actual);
    }

    @Test
    public void reverseBetween24() {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        final ListNode actual = reverseLinkedList2.reverseBetween(head, 2, 4);
        final int[] expected = {1, 4, 3, 2, 5};
        assertResult(expected, actual);
    }

    @Test
    public void reverseBetween15() {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        final ListNode actual = reverseLinkedList2.reverseBetween(head, 1, 5);
        final int[] expected = {5, 4, 3, 2, 1};
        assertResult(expected, actual);
    }

    private void assertResult(int[] expected, ListNode actual) {
        for (int v : expected) {
            assertEquals(v, actual.val);
            actual = actual.next;
        }
        assertNull(actual);
    }
}