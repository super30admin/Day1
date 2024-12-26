// Time Complexity : O(1)
// Space Complexity : O(n) where n is number of consecutive push operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach.
/* Approach: Using another stack to store the min value. Min variable is initially assigned to infinity.
compare each value to min variable and push it to minStack, additionally pop as necessary. */

import java.util.Stack;

class MinStack {
    Stack<Integer> s;
    Stack<Integer> minstack;
    int min;

    public MinStack() {
        s = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
        minstack.push(min);
    }

    public void push(int val) {
        if(val<=min)
        {
            min = val;
        }
        minstack.push(min);
        s.push(val);
    }

    public void pop() {
        s.pop();
        minstack.pop();
        min = minstack.peek();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
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
