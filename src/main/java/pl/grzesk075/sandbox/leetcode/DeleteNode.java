package pl.grzesk075.sandbox.leetcode;

/**
 * 237. Delete Node in singly Linked List.
 * O(1), no tail node will be sent as an argument.
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
