package march;

import java.util.*;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = new char[26];
        int res = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < len; j++) {
                if(ch[j] == s.charAt(i)) {
                    len -= (j+1);
                    System.arraycopy(ch,  j+1, ch, 0, len);
                    break;
                }
            }
            ch[++len] = s.charAt(i);
            res = Math.max(res, len);
        }
        return res;
    }
}
