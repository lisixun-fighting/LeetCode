package april;

import java.util.*;

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i])
                queue.removeLast();
            queue.add(i);
            if(i-k+1 >= 0)
                res[i-k+1] = nums[queue.getFirst()];
            if(queue.getFirst() == i-k+1)
                queue.removeFirst();
        }
        return res;
    }
}
