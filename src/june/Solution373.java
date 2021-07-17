package june;

import java.util.*;

public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();
        int m = nums1.length;
        int n = nums2.length;
        boolean[][] used = new boolean[m][n];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            int sum1 = nums1[o1.get(0)] + nums2[o1.get(1)];
            int sum2 = nums1[o2.get(0)] + nums2[o2.get(1)];
            return Integer.compare(sum1, sum2);
        });
        pq.add(List.of(0,0));
        used[0][0] = true;
        while (k-- > 0 && !pq.isEmpty()) {
            List<Integer> tmp = pq.poll();
            int i = tmp.get(0);
            int j = tmp.get(1);
            res.add(List.of(nums1[i], nums2[j]));
            if (i+1 < m && j < n && !used[i+1][j]) {
                pq.add(List.of(i+1, j));
                used[i+1][j] = true;
            }
            if (i < m && j+1 < n && !used[i][j+1]) {
                pq.add(List.of(i,j+1));
                used[i][j+1] = true;
            }
        }
        return res;
    }
}
