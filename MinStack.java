// Time complexity: O(1)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : tracking the old and new min value


// Your code here along with comments explaining your approach

import java.util.Stack;

public class MinStack {
    int min;
    Stack<Integer> stack;

    /**
     * Initialize stack and push the minimum value into the stack
     */
    public MinStack() {
        min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
        this.stack.push(min);
    }

    /**
     * If the value is smaller than min, push the current min to stack along with incoming val and update min
     * This is done to ensure the old minimum is available at all times if the current minimum is popped
     *
     * @param val value to push
     */
    public void push(int val) {
        if (val <= min) {
            this.stack.push(min);
            min = val;
        }
        this.stack.push(val);
    }

    /**
     * If the popped value is minimum value,
     * update min with old min value which lies right underneath the current min value
     */
    public void pop() {
        int val = this.stack.pop();
        if (val == min) {
            min = this.stack.pop();
        }
    }

    /**
     * In a stack top is always the last inserted value in stack.
     * So a peek is going to give us the top
     *
     * @return top value
     */
    public int top() {
        return this.stack.peek();
    }

    /**
     * Since the minimum is always the current minimum value from stack, return min
     *
     * @return minimum in the stack
     */
    public int getMin() {
        return this.min;
    }
}
