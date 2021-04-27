package april;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Offer58 {
    public String reverseWords(String s) {
        Queue<String> queue = new LinkedList<>();
        Matcher m = Pattern.compile("\\S+").matcher(s);
        while (m.find())
            queue.add(m.group());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
            sb.append(queue.poll()).append(" ");
        return sb.substring(0, sb.length()-1);
    }

    @Test
    public void test() {
        String res = reverseWords("the sky is blue!");
        System.out.println(res);
    }
}
