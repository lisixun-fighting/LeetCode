package march;

import java.util.LinkedList;
import java.util.Queue;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        if(newInterval[1] < intervals[0][0]) {
            q1.add(newInterval[0]);
            q2.add(newInterval[1]);
        }
        int[] nums = merge(intervals[0], newInterval);
        q1.add(nums[0]);
        q2.add(nums[1]);
        for (int[] interval : intervals) {
            nums = merge(interval, newInterval);
            if(q2.getLast() < newInterval[0] && nums[0] > newInterval[1]) {
                q1.add(newInterval[0]);
                q2.add(newInterval[1]);
            }
            if(nums[0] > q2.getLast()) {
                q1.add(nums[0]);
                q2.add(nums[1]);
            }else {
                q2.add(Math.max(q2.removeLast(), nums[1]));
            }

        }
        if(newInterval[0] > q2.getLast()) {
            q1.add(newInterval[0]);
            q2.add(newInterval[1]);
        }
        int[][] res = new int[q2.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = q1.removeFirst();
            res[i][1] = q2.removeFirst();
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        if((nums2[0] <= nums1[1] && nums2[0] >= nums1[0]) || (nums2[1] <= nums1[1] && nums2[1] >= nums1[0])
                || (nums2[0] <= nums1[0] && nums1[1] <= nums2[1])) {
            nums1[0] = Math.min(nums1[0], nums2[0]);
            nums1[1] = Math.max(nums1[1], nums2[1]);
        }
        return nums1;
    }
}
