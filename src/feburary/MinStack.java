package feburary;

import java.util.*;

public class MinStack {
    Stack<Integer> stack;
    SortedMap<Integer,Integer> sortedMap;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        sortedMap = new TreeMap<Integer, Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(!sortedMap.containsKey(x))
            sortedMap.put(x, 1);
        else
            sortedMap.put(x, sortedMap.get(x)+1);

    }

    public void pop() {
        Integer p = stack.pop();
        int v = sortedMap.get(p);
        if(v > 1)
            sortedMap.put(p, v-1);
        else
            sortedMap.remove(p);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return sortedMap.firstKey();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(-1);
        minStack.push(2);
        minStack.push(-1);
        System.out.println(minStack.sortedMap);
        int min = minStack.getMin();
        System.out.println(min);
        int top = minStack.top();
        System.out.println(top);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
