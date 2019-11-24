package pl.grzesk075.sandbox.leetcode;

import java.util.LinkedList;

public class ReverseLinkedList {

    private ReverseLinkedList(){

    }
    /**
     * For regular {@link LinkedList}.
     */
    public static void solution(final LinkedList linkedList) {
        for (int i = 0; i < linkedList.size() - 1; i++) {
            linkedList.add(i, linkedList.removeLast());
        }
    }


    /*Definition for singly-linked list.*/
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    /**
     * This solution doesn't modify original list.
     */
    public static ListNode reverseListIteratively(ListNode head) {
        ListNode reversedList = null;
        ListNode listNode = head;
        while (listNode != null) {
            final ListNode newListNode = new ListNode(listNode.val);
            if (reversedList == null) {
                reversedList = newListNode;
            } else {
                newListNode.next = reversedList;
                reversedList = newListNode;
            }
            listNode = listNode.next;
        }
        return reversedList;
    }

    /**
     * This solution does modify original list.
     */
    public static ListNode reverseListIteratively1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode oldHead = head.next;
        newHead.next = null;
        while (oldHead != null) {
            final ListNode previousNewHead = newHead;
            newHead = oldHead;
            oldHead = oldHead.next;
            newHead.next = previousNewHead;
        }
        return newHead;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode oldHead = head.next;
        newHead.next = null;
        return moveNode(newHead, oldHead);
    }

    private static ListNode moveNode(ListNode newHead, ListNode oldHead) {
        if (oldHead == null) {
            return newHead;
        }
        final ListNode previousNewHead = newHead;
        newHead = oldHead;
        oldHead = oldHead.next;
        newHead.next = previousNewHead;
        return moveNode(newHead, oldHead);
    }
}
