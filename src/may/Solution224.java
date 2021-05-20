package may;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution224 {
    public int calculate(String s) {
        int res = 0;
        Pattern p = Pattern.compile("(\\d+)|[+-/*/)(]");
        Matcher matcher = p.matcher(s);
        Stack<String> stack = new Stack<>();

        boolean start = true;

        while (matcher.find()) {
            String inf = matcher.group();
            if(start && !inf.equals("+") && !inf.equals("-")) {
                stack.push("+");
            }
            if (inf.equals(")")) {
                int tmp = 0;
                while (!stack.peek().equals("("))
                    tmp += handle(stack);
                stack.pop();
                if (stack.pop().equals("-"))
                    tmp = -tmp;
                stack.push(tmp > 0 ? "+" : "-");
                stack.push(String.valueOf(Math.abs(tmp)));
            }
            else if(inf.equals("(")) {
                stack.push(inf);
                start = true;
            }
            else {
                stack.push(inf);
                start = false;
            }
        }
        while (!stack.isEmpty())
            res += handle(stack);
        return res;
    }

    private int handle(Stack<String> stack) {
        int tmp = Integer.parseInt(stack.pop());
        return stack.pop().equals("+") ? tmp : -tmp;
    }

    public static void main(String[] args) {
        Solution224 sol = new Solution224();
        int res = sol.calculate("(1+(-4+5+2)-3)+(6+8)");
        System.out.println(res);
    }
}
