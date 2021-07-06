package july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution743 {

    private static class Vertex {
        private int id;

        private Map<Vertex, Integer> delay = new HashMap<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void traversal(int[] delayTimes) {
            int now = delayTimes[id];
            for (Vertex v : delay.keySet()) {
                if (delayTimes[v.id] < 0) {
                    delayTimes[v.id] = now + delay.get(v);
                    v.traversal(delayTimes);
                } else if (delayTimes[v.id] > (now + delay.get(v))){
                    delayTimes[v.id] = now + delay.get(v);
                    v.traversal(delayTimes);
                }
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Vertex[] vertices = new Vertex[n+1];
        for (int i = 1; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int[] group : times) {
            Vertex u = vertices[group[0]];
            Vertex v= vertices[group[1]];
            u.delay.put(v, group[2]);
        }
        int[] delayTimes = new int[n];

        Arrays.fill(delayTimes, -1);
        delayTimes[0] = 0;
        delayTimes[k] = 0;
        vertices[k].traversal(delayTimes);
        int res = 0;
        for (int delay : delayTimes) {
            if (delay < 0) {
                return -1;
            }
            res = Math.max(res, delay);
        }
        return res;
    }
}
