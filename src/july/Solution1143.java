package july;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        char[] lchars;
        char[] schars;
        if (chars1.length > chars2.length) {
            lchars = chars1;
            schars = chars2;
        } else {
            lchars = chars2;
            schars = chars1;
        }
        int[] dp = new int[lchars.length];

        for (char c : schars) {
            int last = 0;
            for (int i = 0; i < dp.length; i++) {
                last = Math.max(dp[i], last);
                if (lchars[i] == c) {
                    dp[i] = last + 1;
                    last = 0;
                }
            }
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }

        return res;
    }
}
