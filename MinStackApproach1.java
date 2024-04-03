// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

public class MinStackApproach1 {

    Stack<Integer> stack1;
    Stack<Integer> minStack;

    public MinStackApproach1() {
        stack1 = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        int minVal = Math.min(val, minStack.peek());

        stack1.push(val);
        minStack.push(minVal);

    }

    public void pop() {

        stack1.pop();
        minStack.pop();
    }

    public int top() {
        return stack1.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}
