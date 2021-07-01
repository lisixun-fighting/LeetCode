package june;

import org.junit.Test;

import java.util.*;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> adjacency = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacency.putIfAbsent(u, new HashSet<>());
            adjacency.putIfAbsent(v, new HashSet<>());
            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }
        int n = adjacency.keySet().size();
        for (int i = edges.length-1; i >= 0; i--) {
            int[] removedEdge = edges[i];
            if (dfs(1, adjacency, removedEdge, new boolean[n+1]) == n) {
                return removedEdge;
            }
        }
        return null;
    }

    private int dfs(int u, Map<Integer, Set<Integer>> adjacency, int[] removedEdge, boolean[] known) {
        known[u] = true;
        int n = 1;
        for (Integer v : adjacency.get(u)) {
            if (known[v]) {
                continue;
            }
            if ((u == removedEdge[0] && v == removedEdge[1]) || (u == removedEdge[1] && v == removedEdge[0])) {
                continue;
            }
            n += dfs(v, adjacency, removedEdge, known);
        }
        return n;
    }

    @Test
    public void test() {
        int[][] edges = {{1,2}, {2,3}, {3,1}, {1,4}};
        int[] res = findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }

}
