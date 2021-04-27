package janurary;

import java.util.*;

public class Solution139 {
    /**
     * dynamic planning
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        if(wordDict.contains(s.substring(0,1))) dp[0] = true;
        for (int i = 1; i <= dp.length-1; i++) {
            if(wordDict.contains(s.substring(0,i+1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        boolean result = wordBreak("applength", List.of("app", "apple", "ngth"));
    }
}
