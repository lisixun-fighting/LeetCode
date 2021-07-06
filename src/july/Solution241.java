package july;

import org.junit.Test;

import java.util.*;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
                nums.add(tmp);
                tmp = 0;
            } else {
                int n = c - '0';
                tmp = tmp * 10 + n;
            }
        }
        nums.add(tmp);
        System.out.println(nums);
        System.out.println(operators);

        Stack<Integer> numStack = new Stack<>();
        numStack.push(nums.get(0));

        List<Integer> res = new LinkedList<>();

        dfs(new Stack<>(), numStack, 1, operators, nums, res);
        return res;
    }

    public void dfs(Stack<Character> opStack, Stack<Integer> numStack, int index,
            List<Character> opList, List<Integer> numList, List<Integer> res) {

        if (index == numList.size() ) {
            if (numStack.size() == 1)
                res.add(numStack.pop());
            return;
        }

        numStack.push(numList.get(index));
        opStack.push(opList.get(index-1));

        dfs(newStack(opStack), newStack(numStack), index+1, opList, numList, res);

        while (!opStack.isEmpty()) {
            Character op = opStack.pop();
            Integer n2 = numStack.pop();
            Integer n1 = numStack.pop();
            int num;
            switch (op) {
                case '+':
                    num = n1 + n2;
                    break;
                case '-':
                    num = n1 - n2;
                    break;
                case '*':
                    num = n1 * n2;
                    break;
                default:
                    throw new RuntimeException();
            }
            System.out.println(n1 + "" + op + n2);
            numStack.push(num);
            dfs(newStack(opStack), newStack(numStack), index+1, opList, numList, res);
        }
    }

    private static <T> Stack<T> newStack(Stack<T> origin) {
        Stack<T> newStack = new Stack<>();
        for (T t : origin) {
            newStack.push(t);
        }
        return newStack;
    }

    @Test
    public void test() {
        List<Integer> res = diffWaysToCompute("2*3-4*5+6");
        System.out.println(res);
    }

}
