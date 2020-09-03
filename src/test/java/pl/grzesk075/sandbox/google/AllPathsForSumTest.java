package pl.grzesk075.sandbox.google;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class AllPathsForSumTest {

    @Test
    public void shouldFindPathsWithSum0() {
        final AllPathsForSum.Node root = new AllPathsForSum.Node(0);
        final List<List<AllPathsForSum.Node>> pathsWithSum = AllPathsForSum.findPathsWithSum(root, 0);
        assertEquals(1, pathsWithSum.size());
        assertEquals(1, pathsWithSum.get(0).size());
        assertSame(root, pathsWithSum.get(0).get(0));
    }

    @Test
    public void shouldFindPathsWithSum1() {
        final AllPathsForSum.Node root = new AllPathsForSum.Node(0);
        final AllPathsForSum.Node left = new AllPathsForSum.Node(1);
        final AllPathsForSum.Node right = new AllPathsForSum.Node(2);
        root.left = left;
        root.right = right;

        final List<List<AllPathsForSum.Node>> pathsWithSum = AllPathsForSum.findPathsWithSum(root, 2);
        assertEquals(1, pathsWithSum.size());
        assertEquals(2, pathsWithSum.get(0).size());
        assertSame(root, pathsWithSum.get(0).get(0));
        assertSame(right, pathsWithSum.get(0).get(1));
    }

    @Test
    public void shouldFindPathsWithSumEmpty() {
        final AllPathsForSum.Node root = new AllPathsForSum.Node(-1);
        final AllPathsForSum.Node left = new AllPathsForSum.Node(1);
        final AllPathsForSum.Node right = new AllPathsForSum.Node(2);
        root.left = left;
        root.right = right;

        final List<List<AllPathsForSum.Node>> pathsWithSum = AllPathsForSum.findPathsWithSum(root, 2);
        assertTrue(pathsWithSum.isEmpty());
    }
}