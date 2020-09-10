package pl.grzesk075.sandbox.google;

/**
 * Delete node with given key.
 * <p>
 * Problem statement:
 * You are given the head of a linked list and a key. You have to delete the node that contains this given key.
 */
public class DeleteNode {

    private DeleteNode() {
    }

    public static Node deleteNode(Node head, int key) {
        if (head.key == key) {
            return head.next;
        }
        Node previousNode = head;
        Node node = head.next;
        while (node != null) {
            if (node.key == key) {
                previousNode.next = node.next;
                break;
            }
            previousNode = node;
            node = node.next;
        }
        return head;
    }

    public static class Node {
        Node next;
        int key;

        public Node(final int value) {
            this.key = value;
        }
    }
}
