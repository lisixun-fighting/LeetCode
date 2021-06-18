package june;

import org.junit.Test;

import java.util.*;

public class Solution394 {
    public String decodeString(String s) {
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> tmpStack = new Stack<>();
        Queue<Character> tmpQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                while (mainStack.peek() != '[') {
                    tmpStack.push(mainStack.pop());
                }
                mainStack.pop();
                int rep = 0;
                int idx = 1;
                while (!mainStack.isEmpty() &&
                        mainStack.peek() >= '0' && mainStack.peek() <= '9') {
                    rep += (idx * (mainStack.pop() - '0'));
                    idx *= 10;
                }
                while (!tmpStack.isEmpty()) {
                    tmpQueue.add(tmpStack.pop());
                }
                while (rep-- > 0) {
                    for (Character ch : tmpQueue) {
                        mainStack.push(ch);
                    }
                }
                tmpQueue.clear();
            } else {
                mainStack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!mainStack.isEmpty()) {
            tmpStack.push(mainStack.pop());
        }
        while (!tmpStack.isEmpty()) {
            sb.append(tmpStack.pop());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String res = decodeString("2[abc]300[cd]ef");
        System.out.println(res);
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < 10; i++) {
//            stack.push(i);
//        }
//        for (Integer integer : stack) {
//            System.out.println(integer);
//        }
    }
}
