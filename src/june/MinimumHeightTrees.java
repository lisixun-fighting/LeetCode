package june;

import org.junit.Test;

import java.util.*;

public class MinimumHeightTrees {

    private static class Vertex {
        int id;
        public Vertex(int id) {
            this.id = id;
        }
        Map<Vertex, Integer> adjacency = new HashMap<>();
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int[] edge : edges) {
            Vertex v = vertices[edge[0]];
            Vertex u = vertices[edge[1]];
            v.adjacency.put(u,0);
            u.adjacency.put(v,0);
        }
        int[] counts = new int[n];
        int res = n;
        for (int i = 0; i < n; i++) {
            counts[i] = dfs(vertices[i], new boolean[n]);
            res = Math.min(res, counts[i]);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == res)
                list.add(i);
        }
        return list;
    }

    private int dfs(Vertex v, boolean[] known) {
        int deep = 0;
        known[v.id] = true;
        for (Vertex w : v.adjacency.keySet()) {
            if (known[w.id])
                continue;
            if (v.adjacency.get(w) == 0) {
                int deepW = dfs(w, known);
                v.adjacency.put(w, deepW);
            }
            deep = Math.max(v.adjacency.get(w), deep);
        }
        return deep+1;
    }

    @Test
    public void test() {
        int[][] edges = {{3,0},{3,2},{1,3},{3,4},{5,4}};
        List<Integer> list = findMinHeightTrees(6, edges);
        System.out.println(list);
    }
}
