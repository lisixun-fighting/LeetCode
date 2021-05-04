package may;

import org.junit.Test;

import java.util.*;

public class Solution132 {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = -1;
        dp[1] = 0;
        List<List<Integer>> partition = new ArrayList<>();
        partition.add(List.of(0));
        for (int i = 1; i < len; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            dp[i+1] = dp[i] + 1;
            if(s.charAt(i) == s.charAt(i-1)) {
                tmp.add(i-1);
                dp[i+1] = Math.min(dp[i-1]+1, dp[i+1]);
            }
            for (Integer last : partition.get(i-1)) {
                if(last > 0 && s.charAt(i) == s.charAt(last-1)) {
                    tmp.add(last-1);
                    dp[i+1] = Math.min(dp[last-1]+1, dp[i+1]);
                }
            }
            partition.add(tmp);
        }
        System.out.println(partition);
        System.out.println(Arrays.toString(dp));
        return dp[len];
    }

    @Test
    public void test() {
        System.out.println(minCut("cbbbcc"));
    }
}
