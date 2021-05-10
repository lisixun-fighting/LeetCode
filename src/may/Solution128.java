package may;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> dp = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            if(dp.get(i) != null) continue;
            Integer tmp1 = dp.get(i-1);
            Integer tmp2 = dp.get(i+1);
            tmp1 = tmp1 == null ? 0 : tmp1;
            tmp2 = tmp2 == null ? 0 : tmp2;
            dp.put(i, 1 + tmp1 + tmp2);
            dp.put(i-tmp1, tmp1+1+tmp2);
            dp.put(i+tmp2, tmp1+1+tmp2);
        }

        for (Integer key : dp.keySet()) {
            res = Math.max(res, dp.get(key));
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }
}
