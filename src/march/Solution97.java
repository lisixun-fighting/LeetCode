package march;

public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        return (ch1.length+ch2.length==ch3.length) && dfs(ch1, 0, ch2, 0, ch3, 0);
    }

    private boolean dfs(char[] ch1, int i1, char[] ch2, int i2, char[] ch3, int i3) {
        if(i3 == ch3.length) return true;
        if(i1 < ch1.length && ch1[i1] == ch3[i3] && dfs(ch1, i1+1, ch2, i2, ch3, i3+1)) return true;
        return i2 < ch2.length && ch2[i2] == ch3[i3] && dfs(ch1, i1, ch2, i2 + 1, ch3, i3 + 1);
    }
}
