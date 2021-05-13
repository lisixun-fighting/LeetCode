package may;

import org.junit.Test;

import java.util.*;

public class Solution149 {
    public int maxPoints(int[][] points) {
        Map<double[], Set<int[]>> map = new HashMap<>();
        Set<int[]> set = new HashSet<>(Set.of(points[0]));
        for (int i = 1; i < points.length; i++) {
            Set<int[]> tmp = new HashSet<>(set);
            for (double[] line : map.keySet()) {
                if(check(points[i], line)) {
                    tmp.removeAll(map.get(line));
                    map.get(line).add(points[i]);
                }
            }
            for (int[] p1 : tmp) {
                map.put(newline(p1, points[i]), new HashSet<>(Set.of(p1, points[i])));
            }
            set.add(points[i]);
        }
        int res = 1;
        for (Map.Entry<double[], Set<int[]>> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue().size());
        }
        return res;
    }

    private boolean check(int[] point, double[] lines) {
        System.out.println(lines[0] * point[0] + lines[1] * point[1] + lines[2]);
        return Math.abs(lines[0] * point[0] + lines[1] * point[1] + lines[2]) < Math.pow(0.1, 5);
    }

    private double[] newline(int[] p1, int[] p2) {
        double[] params = new double[3];
        if (p2[0] == p1[0] && p1[0] == 0) {
            params[0] = 1;
            return params;
        }
        if (p2[1] == p1[1] && p2[1] == 0) {
            params[1] = 1;
            return params;
        }
        if ((p1[0] * p2[1] - p2[0] * p1[1]) == 0 || (p2[0] * p1[1] - p2[1] * p1[0]) == 0) {
            params[2] = 0;
            params[1] = -1;
            params[0] = (double) p2[1] / (double) p2[0];
            System.out.println(Arrays.toString(params));
            return params;
        }
        params[0] = (double) (-p2[1] + p1[1]) / (p1[0] * p2[1] - p2[0] * p1[1]);
        params[1] = (double) (-p2[0] + p1[0]) / (p2[0] * p1[1] - p2[1] * p1[0]);
        params[2] = 1;
        System.out.println(Arrays.toString(params));
        return params;
    }

    @Test
    public void test() {
        double[] line = new double[] {0.11060606060606061d, -0.022727272727272728d, 1.0};
        System.out.println(check(new int[]{-150,-686}, newline(new int[]{-105,-467}, new int[]{-90,-394})));
        newline(new int[]{-150,-686}, new int[]{-105,-467});
    }
}
