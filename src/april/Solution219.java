package april;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> queue = map.get(nums[i]);
            if(queue == null)
                queue = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer t1, Integer t2) {
                        return Integer.compare(t1,t2);
                    }
                });
            queue.offer(i);
            map.put(nums[i], queue);
        }
        for (Integer key : map.keySet()) {
            PriorityQueue<Integer> queue = map.get(key);
            Integer val = queue.poll();
            if(val == null)
                continue;
            while (!queue.isEmpty()) {
                if(Math.abs(val - queue.peek()) <= k)
                    return true;
                val = queue.poll();
            }
        }
        return false;
    }
}
