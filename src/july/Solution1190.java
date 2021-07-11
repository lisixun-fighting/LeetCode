package july;

import java.util.Arrays;
import java.util.Stack;

public class Solution1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = new char[s.length()];
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[i] = c;
            nums[i] = 1;
            if (c == ')') {
                int j = i;
                while (stack.pop() != '(') {
                    j -= nums[i];

                }
                int k = i-1;
                nums[i] = i-j+1;
                while (k > j) {
                    char tmp = chars[k];
                    chars[k] = chars[j];
                    chars[j] = tmp;
                    k--;
                    j++;
                }
            } else {
                stack.add(c);
            }
            System.out.println(Arrays.toString(chars));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '(' && c != ')')
                sb.append(c);
        }
        return sb.toString();
    }
}
