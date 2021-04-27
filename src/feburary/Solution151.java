package feburary;

import java.util.Arrays;
import java.util.Collections;

public class Solution151 {
    public String reverseWords(String s) {
        String[] ls = s.split("\\s+");
        System.out.println(Arrays.toString(ls));
        StringBuilder sb = new StringBuilder();
        for (int i = ls.length-1; i >= 0; i--) {
            if(ls[i].length() > 0)
                sb.append(ls[i]).append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }

    public static void main(String[] args) {
        Solution151 sol = new Solution151();
        System.out.println(sol.reverseWords("   hello world!   "));
    }
}
