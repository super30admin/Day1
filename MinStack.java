
// Time Complexity : O(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Implementing Min Stack using two Stack objects.

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // check if the current push is less than min and then push the min to
        // min stack. Min stack now contains previous min.
        if (min >= val) {
            minStack.push(min);
            min = val;
        }
    }

    public void pop() {
        int poppedValue = stack.pop();
        if (poppedValue == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
