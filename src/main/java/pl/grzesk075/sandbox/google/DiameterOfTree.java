package pl.grzesk075.sandbox.google;

import java.util.LinkedList;
import java.util.List;

/**
 * Find diameter of a tree.
 *
 * O(n*n). One use case in tests doesn't work. Bad solution replaced with linear one.
 */
public class DiameterOfTree {

    public static class Node {
        List<Node> subnodes = new LinkedList<>();
    }

    public int getDiameter(Node n) {
        int diameter = 0;
        List<Node> longestPath = getLongestPath(n, null);
        while (longestPath.size() > 1) {

            List<Node> longestSubPath = getLongestPath(longestPath.get(0), longestPath);
            int d = longestPath.size() + longestSubPath.size() - 2;
            if (d > diameter)
                diameter = d;
            longestPath.remove(0);
        }
        return diameter;
    }

    static class Path {
        List<Node> path = new LinkedList<>();
    }

    List<Node> getLongestPath(Node n, List<Node> avoid) {
        Path longestPath = new Path();
        List<Node> path = new LinkedList<>();
        path.add(n);
        getLongestPath(n, avoid, path, longestPath);
        return longestPath.path;
    }

    void getLongestPath(Node n, List<Node> avoid, List<Node> path, Path lp) {

        if (n.subnodes.isEmpty()) {
            if (path.size() > lp.path.size()) {
                lp.path = path;
            }
            return;
        }
        for (Node sub : n.subnodes) {
            if (avoid != null && avoid.contains(sub))
                continue;
            List<Node> subpath = new LinkedList<>(path);
            subpath.add(sub);
            getLongestPath(sub, avoid, subpath, lp);
        }
    }
}
