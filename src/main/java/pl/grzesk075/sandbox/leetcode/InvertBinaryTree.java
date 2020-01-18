package pl.grzesk075.sandbox.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /**
     * DFS algorithm - Depth First Search.
     * Intuitive, fast and straightforward, but not robust solution.
     * Vulnerability is caused by recursion.
     */
    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        root.left = invertTreeDFS(right);
        root.right = invertTreeDFS(left);
        return root;
    }

    /**
     * BFS algorithm - Breadth First Search so called Level Order Traversal.
     * Scalable.
     */
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            final TreeNode node = nodes.poll();
            final TreeNode left = node.left;
            final TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) {
                nodes.offer(left);
            }
            if (right != null) {
                nodes.offer(right);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}