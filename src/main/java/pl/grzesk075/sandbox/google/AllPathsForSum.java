package pl.grzesk075.sandbox.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all paths for a sum.
 * <p>
 * Problem statement:
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 * DFS O(V) - Depth First Search - linear time complexity in function of vertices count.
 */
public class AllPathsForSum {

    public static List<List<Node>> findPathsWithSum(Node root, int S) {
        List<List<Node>> allPaths = new ArrayList<>();

        ArrayList<Node> path = new ArrayList<>(Arrays.asList(root));
        findPathsWithSum(root, S, root.value, path, allPaths);

        return allPaths;
    }

    private static void findPathsWithSum(Node node, int S, long pathSum,
                                         List<Node> path, List<List<Node>> allPaths) {

        if (node.left == null && node.right == null) {
            if (pathSum == S) {
                allPaths.add(path);
            }
            return;
        }

        applyFindPathsWithSumForSubnode(node.left, S, pathSum, path, allPaths);
        applyFindPathsWithSumForSubnode(node.right, S, pathSum, path, allPaths);
    }

    private static void applyFindPathsWithSumForSubnode(final Node subnode, final int S, final long pathSum,
                                                        final List<Node> path, final List<List<Node>> allPaths) {
        if (subnode != null) {

            ArrayList<Node> subnodePath = new ArrayList<>(path);
            subnodePath.add(subnode);
            long subnodeSum = pathSum + subnode.value;
            findPathsWithSum(subnode, S, subnodeSum, subnodePath, allPaths);
        }
    }

    /**
     * Binary tree node.
     */
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(final int value) {
            this.value = value;
        }
    }
}
