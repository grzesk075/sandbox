package pl.grzesk075.sandbox.google;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class BinaryTreeTest {

    private Node root;

    private BinaryTree binaryTree;

    @Before
    public void prepareBinaryTree() {
        root = new Node(5);
        root.l = new Node(-1);
        root.r = new Node(1);
        root.l.l = new Node(8);
        root.l.r = new Node(4);
        root.r.l = new Node(7);
        root.r.r = new Node(3);
        root.l.l.l = new Node(20);
        root.r.r.r = new Node(30);

        binaryTree = new BinaryTree();
    }

    @Test
    public void copyBinaryTreeDFS() {
        final Node copy = binaryTree.copyBinaryTreeDFS(root);
        assertCopiedBinaryTree(copy);
    }

    private void assertCopiedBinaryTree(Node copy) {

        assertNotSame(root, copy);
        assertNotSame(root.l, copy.l);
        assertNotSame(root.r, copy.r);
        assertNotSame(root.l.l, copy.l.l);
        assertNotSame(root.l.r, copy.l.r);
        assertNotSame(root.r.l, copy.r.l);
        assertNotSame(root.r.r, copy.r.r);
        assertNotSame(root.l.l.l, copy.l.l.l);
        assertNotSame(root.r.r.r, copy.r.r.r);

        assertEquals(root.v, copy.v);
        assertEquals(root.l.v, copy.l.v);
        assertEquals(root.r.v, copy.r.v);
        assertEquals(root.l.l.v, copy.l.l.v);
        assertEquals(root.l.r.v, copy.l.r.v);
        assertEquals(root.r.l.v, copy.r.l.v);
        assertEquals(root.r.r.v, copy.r.r.v);
        assertEquals(root.l.l.l.v, copy.l.l.l.v);
        assertEquals(root.r.r.r.v, copy.r.r.r.v);
    }

    @Test
    public void copyBinaryTreeBFS() {
        final Node copy = binaryTree.copyBinaryTreeBFS(root);
        assertCopiedBinaryTree(copy);
    }

    @Test
    public void invertBinaryTreeDFS() {
        final Node inverted = binaryTree.invertBinaryTreeDFS(root);
        assertInvertedTree(inverted);
    }

    @Test
    public void invertBinaryTreeBFS() {
        final Node inverted = binaryTree.invertBinaryTreeBFS(root);
        assertInvertedTree(inverted);
    }

    private void assertInvertedTree(Node inverted) {
        assertEquals(5, inverted.v);
        assertEquals(1, inverted.l.v);
        assertEquals(-1, inverted.r.v);
        assertEquals(3, inverted.l.l.v);
        assertEquals(7, inverted.l.r.v);
        assertEquals(4, inverted.r.l.v);
        assertEquals(8, inverted.r.r.v);
        assertEquals(30, inverted.l.l.l.v);
        assertEquals(20, inverted.r.r.r.v);
    }

    @Test
    public void sumBinaryTreeDFS() {
        assertEquals(77L, binaryTree.sumBinaryTreeDFS(root));
    }

    @Test
    public void sumBinaryTreeBFS() {
        assertEquals(77L, binaryTree.sumBinaryTreeBFS(root));
    }
}