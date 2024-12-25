//Problem 2

// Time Complexity : O(1) for all push, pop, top, getMin methods
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// keeping one stack,
// on push, if value is less than current minimum, then pushing current min and input value both & update current min
// on pop if top is the current min, then popping twice, and updating current min with second pop

import java.util.Objects;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Integer min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        stack.push(min);
    }

    public void push(int val) {
        if (val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (Objects.equals(stack.peek(), min)){
            stack.pop();
            min = stack.pop();
        }else stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
