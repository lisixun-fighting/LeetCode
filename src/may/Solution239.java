package may;

import java.util.TreeMap;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                res[i-k] = map.lastKey();
                int val = map.get(nums[i-k]);
                if (val == 1)
                    map.remove(nums[i-k]);
                else
                    map.put(nums[i-k], val-1);
            }
            map.merge(nums[i], 1, Integer::sum);
        }
        res[res.length-1] = map.lastKey();
        return res;
    }
}
