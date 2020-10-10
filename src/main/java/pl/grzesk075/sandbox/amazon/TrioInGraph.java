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
            int startPoint = n;
            int node = n;
            int parent = -1;
            List<Integer> visited = new LinkedList<>();

            findTrios(trios, adjacencyList, startPoint, node, parent, visited);
        }

        return -1;
    }

    private static void findTrios(List<List<Integer>> trios, LinkedList<Integer>[] adjacencyList,
                                  int startPoint, int node, int parent, List<Integer> visited) {
        visited.add(node);
        List<Integer> neighbours = adjacencyList[node];
        for (Integer neighbour : neighbours) {
            if (neighbour == parent) {
                continue;
            }
            visited.copy
        }
    }
}
