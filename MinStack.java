// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;


/**
 * Using 2 stacks storing the corresponding min value for each stack entry in the minStack
 *
 * Time Complexity: O(1) (push, pop, peek, top, getMin)
 * Space Complexity: O(n)
 */
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);
        minStack.push(minStack.empty()? val:Math.min(val, minStack.peek()));
    }

    public void pop() {


        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */