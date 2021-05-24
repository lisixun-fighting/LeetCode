package may;

import org.junit.Test;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution227 {
    public int calculate(String s) {
        int res = 0;
        Pattern p = Pattern.compile("(\\d+)|[+-/*/]");
        Matcher matcher = p.matcher(s);
        Stack<String> stack = new Stack<>();
        stack.push("+");
        while (matcher.find()) {
            String inf = matcher.group();
            if (inf.equals("+") || inf.equals("-")) {
                res += handle(stack);
                stack.push(inf);
            }
            else if (inf.matches("\\d+")) {
                String operator = stack.pop();
                if (operator.equals("*")) {
                    String last = stack.pop();
                    int tmp = Integer.parseInt(last) * Integer.parseInt(inf);
                    stack.push(String.valueOf(tmp));
                }
                else if (operator.equals("/")) {
                    String last = stack.pop();
                    int tmp = Integer.parseInt(last) / Integer.parseInt(inf);
                    stack.push(String.valueOf(tmp));
                }
                else {
                    stack.push(operator);
                    stack.push(inf);
                }
            }
            else
                stack.push(inf);
        }
        res += handle(stack);
        return res;
    }
    private int handle(Stack<String> stack) {
        int tmp = Integer.parseInt(stack.pop());
        return stack.pop().equals("+") ? tmp : -tmp;
    }
    public static void main(String[] args) {
        Solution227 s = new Solution227();
        int res = s.calculate("2 + 2*2");
        System.out.println(res);
    }
}
