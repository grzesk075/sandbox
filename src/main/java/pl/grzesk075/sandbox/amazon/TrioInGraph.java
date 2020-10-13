package pl.grzesk075.sandbox.amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Find cycles in graph containing 3 nodes (trio).
 * Count sum (amount) of nodes for each trio, that are directly connected with trio.
 * Return the biggest sum, otherwise return -1, if there are no trio in graph.
 * <p>
 * DFS Traversal of the undirected graph - time complexity is O(V+E), space complexity is O(V).
 * Graph is represented by adjacency list.
 */
public class TrioInGraph {
    public static int getBiggestSum(int numberOfNodes, int[] fromNodes, int[] toNodes) {
        LinkedList<Integer>[] adjacencyList = new LinkedList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < fromNodes.length; i++) {
            int n1 = fromNodes[i];
            int n2 = toNodes[i];
            adjacencyList[n1].add(n2);
            adjacencyList[n2].add(n1);
        }
        List<List<Integer>> trios = new LinkedList<>();
        for (int n = 0; n < adjacencyList.length; n++) {
            findTrios(trios, adjacencyList, n, n, -1, new LinkedList<Integer>());
        }
        int maxSum = -1;
        for (List<Integer> trio : trios) {
            int sum = 0;
            for (Integer n : trio) {
                sum += adjacencyList[n].size() - 2;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    private static void findTrios(List<List<Integer>> trios, LinkedList<Integer>[] adjacencyList,
                                  int startNode, int node, int parent, List<Integer> visited) {
        visited.add(node);
        List<Integer> neighbours = adjacencyList[node];
        if (visited.size() == 3) {
            if (neighbours.contains(startNode)) {
                trios.add(visited);
            }
            return;
        }
        for (Integer neighbour : neighbours) {
            if (neighbour == parent) {
                continue;
            }
            List<Integer> nextVisited = new LinkedList<>(visited);
            findTrios(trios, adjacencyList, startNode, neighbour, node, nextVisited);
        }
    }
}
