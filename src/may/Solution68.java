package may;

import org.junit.Test;

import java.util.*;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        sb.append(" ");
        int tmp = words[0].length() + 1;

        for (int i = 1; i < words.length; i++) {
            if (i < words.length-1 && tmp + words[i].length() < maxWidth &&
                    tmp + words[i].length() + words[i+1].length() + 1 > maxWidth){
                while (++tmp + words[i].length() < maxWidth)
                    sb.append(" ");
                sb.append(" ");
            }
            if(tmp == maxWidth) {
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(words[i]);
                tmp = words[i].length();
            }
            else {
                sb.append(words[i]);
                tmp += (words[i].length());
            }
            if(tmp < maxWidth) {
                sb.append(" ");
                tmp++;
            }
            if (i < words.length-1 && tmp < maxWidth && tmp + words[i+1].length() > maxWidth){
                while (++tmp < maxWidth)
                    sb.append(" ");
                sb.append(" ");
            }
        }
        while (tmp++ < maxWidth)
            sb.append(" ");
        res.add(sb.toString());
        return res;
    }

    @Test
    public void test() {
        List<String> res = fullJustify("This is an example of text justification.".split(" "), 16);
        System.out.println(res);
    }
}
