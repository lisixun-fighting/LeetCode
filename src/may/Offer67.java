package may;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Offer67 {
    public int strToInt(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        if(index == s.length())
            return 0;

        boolean flag = true;
        if(s.charAt(index) == '-') {
            flag = false;
            index++;
        } else if(s.charAt(index) == '+') {
            index++;
        }
        long res = 0;
        while (index < s.length() && s.charAt(index) <= '9'
                && s.charAt(index) >= '0') {
            res *= 10;
            if(flag) {
                res += (s.charAt(index) - '0');
                if(res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            } else {
                res -= (s.charAt(index) - '0');
                if(res < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int)res;
    }

    @Test
    public void test() {
        strToInt(" abc 123 ");
    }
}
