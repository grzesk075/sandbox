package pl.grzesk075.sandbox.google;

import java.util.*;

public class ShortestPathInGraph {
    public static List<Integer> getShortestPath(int startNode, int endNode, int[] fromNode, int[] toNode) {
        List<Integer> shortestPath = null;
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int i = 0; i < fromNode.length; i++) {
            Integer from = fromNode[i];
            Integer to = toNode[i];
            if (!adjacency.containsKey(from)) {
                adjacency.put(from, new LinkedList<>());
            }
            if (!adjacency.containsKey(to)) {
                adjacency.put(to, new LinkedList<>());
            }
            adjacency.get(from).add(to);
            adjacency.get(to).add(from);
        }
        Queue<Node> bfs = new LinkedList<>();
        Node start = new Node(startNode, new LinkedList<>());
        bfs.offer(start);
        while (!bfs.isEmpty()) {
            final Node n = bfs.poll();
            final List<Integer> next = adjacency.get(n.n);
            final List<Integer> path = n.path;
            if (next.contains(endNode)) {
                if (shortestPath == null || shortestPath.size() > path.size() + 1) {
                    shortestPath = new LinkedList<>(path);
                    shortestPath.add(endNode);
                }
                continue;
            }
            if (shortestPath != null && shortestPath.size() <= path.size()) {
                continue;
            }
            for (Integer nextNode : next) {
                if (!path.contains(nextNode)) {
                    bfs.offer(new Node(nextNode, path));
                }
            }
        }
        return shortestPath;
    }

    static class Node {
        Integer n;
        List<Integer> path;

        public Node(Integer n, List<Integer> path) {
            this.n = n;
            this.path = new LinkedList<>(path);
            this.path.add(n);
        }
    }
}
