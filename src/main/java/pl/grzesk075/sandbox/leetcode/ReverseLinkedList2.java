package pl.grzesk075.sandbox.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 92. Reverse Linked List II from position m to n.
 * O(N).
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }
        ListNode newHead = (m != 1) ? head : null;
        Deque<ListNode> revertNodes = new ArrayDeque<>();
        ListNode lastNode = null;
        ListNode currentNode = head;
        for (int i = 1; i <= n; i++) {
            if (i == m - 1) {
                lastNode = currentNode;
            }
            if (i >= m) {
                revertNodes.push(currentNode);
            }
            currentNode = currentNode.next;
        }
        if (newHead == null) {
            newHead = revertNodes.pop();
            lastNode = newHead;
        }
        while (!revertNodes.isEmpty()) {
            lastNode.next = revertNodes.pop();
            lastNode = lastNode.next;
        }
        lastNode.next = currentNode;

        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
