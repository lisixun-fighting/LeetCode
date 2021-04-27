package march;

import org.junit.Test;

import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjacency.get(pre[1]).add(pre[0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if(!dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjacency.get(pre[1]).add(pre[0]);
            degrees[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < degrees.length; j++) {
            if(degrees[j] == 0) queue.add(j);
        }
        while(!queue.isEmpty()) {
            Integer p = queue.poll();
            degrees[p]--;
            for (Integer j : adjacency.get(p)) {
                if(--degrees[j] == 0) queue.add(j);
            }
            numCourses--;
        }
        return numCourses == 0;
    }

    @Test
    public void test() {
        int[][] prerequisites = new int[][]{{0,1},{2,3},{1,2},{3,0},{5,5}};
        System.out.println(canFinish(4, prerequisites));
    }
}
