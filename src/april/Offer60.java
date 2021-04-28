package april;

import java.util.*;

/**
 * dynamic planning
 */
public class Offer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[n*6+1];
        Arrays.fill(dp, 1, 7, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i*6; j >= i ; j--) {
                dp[j+1] += dp[j];
                dp[j+2] += dp[j];
                dp[j+3] += dp[j];
                dp[j+4] += dp[j];
                dp[j+5] += dp[j];
                dp[j+6] += dp[j];
                dp[j] = 0;
            }
        }
        double sum = Math.pow(6,n);
        double[] res = new double[n*6];
        int flag = 0;
        for (double v : dp)
            if (v != 0)
                res[flag++] = v / sum;
        return Arrays.copyOf(res, flag);
    }
}
