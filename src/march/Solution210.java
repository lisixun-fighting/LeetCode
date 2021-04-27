package march;

import org.junit.Test;

import java.util.*;

public class Solution210 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] res = new int[numCourses];
        int[] degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjacency.get(pre[1]).add(pre[0]);
            degrees[pre[0]]++;
        }
        System.out.println(adjacency);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if(degrees[i] == 0) queue.add(i);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            System.out.println(p);
            res[i] = p;
            for (Integer j : adjacency.get(p)) {
                if(--degrees[j] == 0)
                    queue.add(j);
            }
            i++;
        }
        System.out.println(queue);
        return i == numCourses ? res : null;
    }

    @Test
    public void test() {
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        findOrder(4, prerequisites);
    }

}
