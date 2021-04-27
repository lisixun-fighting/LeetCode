package feburary;

import org.junit.Test;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;
        StringBuffer ss = new StringBuffer(s).reverse();
        StringBuffer pp = new StringBuffer(p).reverse();
        for (int i = 0; i < plen; i++){
            char ch = pp.charAt(i);
            for (int j = 0; j < slen; j++) {
                if (ch == '.')
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i][j];
                else if (ch >= 'a' && ch <= 'z')
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] || (dp[i][j] && ss.charAt(j) == ch);
                else {
                    dp[i + 2][j] = dp[i + 2][j] || dp[i][j];
                    if (pp.charAt(i + 1) == '.')
                        dp[i + 2][j + 1] = dp[i + 2][j + 1] || dp[i][j] || dp[i + 2][j];
                    else
                        dp[i + 2][j + 1] = (ss.charAt(j) == pp.charAt(i+1) && dp[i + 2][j]) || dp[i + 2][j + 1];
                }
            }
            if(ch == '*') {
                dp[i+2][slen] = dp[i+2][slen] || dp[i][slen];
                i++;
            }
        }
        return dp[plen][slen];
    }

    @Test
    public void test() {
        String s = "aab";
        String p = "a*c*b";
        System.out.println(isMatch(s, p));
    }
}
