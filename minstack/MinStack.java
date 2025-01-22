package minstack;

// Time Complexity : add, removetop  O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes after adding a check min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek()
// https://leetcode.com/problems/min-stack/submissions/1517271931/
// Any problem you faced while coding this : in one case the MinStack was empty and we were trying to do peek() on it which threw error.


import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

//        Stack test = new Stack();
//        test.push(1);
//        error case
//        test.peek();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private int min;
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(val < min) {
            min = val;
        }

        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
