package april;

import java.util.Arrays;

public class Solution44 {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len2+1][len1+1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            if (p.charAt(i-1) == '?')
                for (int j = 1; j <= len1; j++)
                    dp[i][j] = dp[i][j] || dp[i-1][j-1];
            else if (p.charAt(i-1) == '*') {
                for (int j = 0; j <= len1; j++)
                    if(dp[i-1][j]) {
                        for (int k = j; k <= len1; k++) {
                            dp[i][k] = true;
                        }
                    }
            }
            else
                for (int j = 1; j <= len1; j++)
                    if (p.charAt(i - 1) == s.charAt(j - 1))
                        dp[i][j] = dp[i][j] || dp[i-1][j-1];
        }
        return dp[len2][len1];
    }
}
