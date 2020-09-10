package pl.grzesk075.sandbox.google;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static pl.grzesk075.sandbox.google.DeleteNode.Node;
import static pl.grzesk075.sandbox.google.DeleteNode.deleteNode;

import org.junit.Before;
import org.junit.Test;

public class DeleteNodeTest {

    public static final int FIRST_KEY = 4;
    public static final int MIDDLE_KEY = 5;
    public static final int LAST_KEY = 6;

    private Node head = null;
    private Node n1 = null;
    private Node n2 = null;

    @Before
    public void setUp() throws Exception {
        head = new Node(FIRST_KEY);
        n1 = new Node(MIDDLE_KEY);
        n2 = new Node(LAST_KEY);
        head.next = n1;
        n1.next = n2;
    }

    @Test
    public void shouldDeleteFirstNode() {
        final Node result = deleteNode(head, FIRST_KEY);
        assertSame(n1, result);
        assertSame(n2, result.next);
        assertNull(result.next.next);
    }

    @Test
    public void shouldDeleteMiddleNode() {
        final Node result = deleteNode(head, MIDDLE_KEY);
        assertSame(head, result);
        assertSame(n2, result.next);
        assertNull(result.next.next);
    }

    @Test
    public void shouldDeleteLastNode() {
        final Node result = deleteNode(head, LAST_KEY);
        assertSame(head, result);
        assertSame(n1, result.next);
        assertNull(result.next.next);
    }

    @Test
    public void shouldNotDeleteNode() {
        final Node result = deleteNode(head, 134151345);
        assertSame(head, result);
        assertSame(n1, result.next);
        assertSame(n2, result.next.next);
        assertNull(result.next.next.next);
    }
}