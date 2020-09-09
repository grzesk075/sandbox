package pl.grzesk075.sandbox.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy linked list with arbitrary pointer.
 * <p/>
 * Problem statement:
 * You are given a linked list where the node has two pointers. The first is the regular ‘next’ pointer.
 * The second pointer is called ‘arbitrary_pointer’ and it can point to any node in the linked list.
 * Your job is to write code to make a deep copy of the given linked list.
 * Here, deep copy means that any operations on the original list (inserting, modifying and removing)
 * should not affect the copied list.
 */
public class CopyLinkedList {

    private CopyLinkedList() {
    }

    public static Node deepCopyLinkedList(Node head) {
        Map<Node, Node> originalNodeToCopiedNode = new HashMap<>();
        Node copyHead = null;
        Node copyNode = null;
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.value);
            originalNodeToCopiedNode.put(node, newNode);
            if (copyHead == null) {
                copyHead = newNode;
                copyNode = newNode;
            } else {
                copyNode.next = newNode;
                copyNode = newNode;
            }
            node = node.next;
        }
        node = head;
        while (node != null) {
            final Node copiedNode = originalNodeToCopiedNode.get(node);
            final Node copiedNodeArbitraryPointer = originalNodeToCopiedNode.get(node.arbitrary_pointer);
            copiedNode.arbitrary_pointer = copiedNodeArbitraryPointer;
            node = node.next;
        }
        return copyHead;
    }

    public static class Node {
        Node next;
        Node arbitrary_pointer;
        int value;

        public Node(final int value) {
            this.value = value;
        }
    }
}
