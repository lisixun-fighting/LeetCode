package march;

import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[2][2][k+1];

        Arrays.fill(dp[0][1], Integer.MIN_VALUE);
        dp[0][1][1] = -prices[0];

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[1][1][j] = Math.max(dp[0][1][j], dp[0][0][j-1]-prices[i]);
                dp[1][0][j] = Math.max(dp[0][0][j], dp[0][1][j]+prices[i]);
                res = Math.max(res, dp[1][0][j]);
            }
            dp[0] = dp[1];
        }
        return res;
    }
}
