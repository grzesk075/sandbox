package pl.grzesk075.sandbox.leetcode;

import org.junit.Before;
import org.junit.Test;
import pl.grzesk075.sandbox.leetcode.ReverseLinkedList.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class ReverseLinkedListTest {

    private ListNode head_1_5;

    private ListNode head_1_2;

    private ListNode head_1;

    @Before
    public void setUp() throws Exception {
        head_1_5 = new ListNode(1);
        ListNode listNode = head_1_5;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        head_1 = new ListNode(1);
        head_1_2 = new ListNode(1);
        head_1_2.next = new ListNode(2);
    }

    @Test
    public void shouldRevertLinkedList() {
        final LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(4, 3, 2, 1));
        ReverseLinkedList.solution(linkedList);
        assertEquals(Arrays.asList(1, 2, 3, 4), linkedList);
        assertThat(linkedList).as("check %d sized integer list", 4).containsExactly(1, 2, 3, 4);
        assertThat(linkedList).filteredOn(i -> i < 2).containsOnly(1);
//        // nested properties are supported
//        assertThat(fellowshipOfTheRing).filteredOn("race.name", "Man")
//                .containsOnly(aragorn, boromir);
        assertThat(linkedList).extracting("MAX_VALUE", "MIN_VALUE").containsOnly(tuple(2147483647, -2147483648));

        final LinkedList linkedList1 = new LinkedList(Arrays.asList(4));
        ReverseLinkedList.solution(linkedList1);
        assertEquals(Arrays.asList(4), linkedList1);
        assertThat(linkedList1).containsExactly(4);

        final LinkedList linkedList2 = new LinkedList(Arrays.asList(4,5));
        ReverseLinkedList.solution(linkedList2);
        assertEquals(Arrays.asList(5,4), linkedList2);
        assertThat(linkedList2).containsExactly(5, 4);

        final LinkedList linkedList3 = new LinkedList();
        ReverseLinkedList.solution(linkedList3);
        assertEquals(new LinkedList(), linkedList3);
        assertThat(linkedList3).isEmpty();
    }

    @Test
    public void shoudThrowNPE() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
            ReverseLinkedList.solution(null);
        });
    }

    @Test
    public void testException() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            throw new Exception("boom!");
        })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();
    }

    @Test
    public void shouldRevertSinglyLinkedListIteratively() {
        checkRevertedHead_1_5(ReverseLinkedList.reverseListIteratively(head_1_5), 5);
        checkRevertedHead_1_5(ReverseLinkedList.reverseListIteratively(head_1_2), 2);
        checkRevertedHead_1_5(ReverseLinkedList.reverseListIteratively(head_1), 1);
        assertThat(ReverseLinkedList.reverseListIteratively(null)).isNull();
    }

    @Test
    public void shouldRevertSinglyLinkedListIteratively1() {
        checkRevertedHead_1_5(ReverseLinkedList.reverseListIteratively1(head_1_5), 5);
        checkRevertedHead_1_5(ReverseLinkedList.reverseListIteratively1(head_1_2), 2);
        checkRevertedHead_1_5(ReverseLinkedList.reverseListIteratively1(head_1), 1);
        assertThat(ReverseLinkedList.reverseListIteratively1(null)).isNull();
    }

    @Test
    public void shouldRevertSinglyLinkedListRecursively() {
        checkRevertedHead_1_5(ReverseLinkedList.reverseListRecursively(head_1_5), 5);
        checkRevertedHead_1_5(ReverseLinkedList.reverseListRecursively(head_1_2), 2);
        checkRevertedHead_1_5(ReverseLinkedList.reverseListRecursively(head_1), 1);
        assertThat(ReverseLinkedList.reverseListRecursively(null)).isNull();
    }

    private void checkRevertedHead_1_5(ListNode reverted, int size) {
        ListNode listNode = reverted;
        for (int i = size; i > 0; i--) {
            assertThat(listNode.val).isEqualTo(i);
            listNode = listNode.next;
        }
        assertThat(listNode).isNull();
    }
}