package april;

import java.util.*;

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>(Long::compare);

        for (int i = 0; i < nums.length; i++) {
            long tmp = nums[i];
            if(!set.add(tmp))
                return true;

            Long higher = set.higher(tmp);
            if(higher != null && higher <= tmp+t)
                return true;

            Long lower = set.lower(tmp);
            if(lower != null && lower >= tmp-t)
                return true;

            if(set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
