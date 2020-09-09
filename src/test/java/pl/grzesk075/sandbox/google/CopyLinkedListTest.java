package pl.grzesk075.sandbox.google;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.grzesk075.sandbox.google.CopyLinkedList.Node;

public class CopyLinkedListTest {

    @Test
    public void deepCopyLinkedListTest() {
        Node n0 = new Node(4);
        Node n1 = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(7);
        Node n4 = new Node(8);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n2.arbitrary_pointer = n0;
        n1.arbitrary_pointer = n3;
        n3.arbitrary_pointer = n3;

        final Node copiedLinkedList = CopyLinkedList.deepCopyLinkedList(n0);

        Node orig = n0;
        Node copy = copiedLinkedList;
        while (orig != null) {
            assertFalse(copy == orig);
            assertTrue(copy.value == orig.value);
            if (orig.arbitrary_pointer == null) {
                assertTrue(copy.arbitrary_pointer == null);
            } else {
                assertTrue(copy.arbitrary_pointer.value == orig.arbitrary_pointer.value);
                assertFalse(copy.arbitrary_pointer == orig.arbitrary_pointer);
            }
            orig = orig.next;
            copy = copy.next;
        }
    }
}