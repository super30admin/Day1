// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Explanation: In this approach we are taking only one stack, but when we encounter a minimum value, we tend to push the previous minimmum value along with it. And if 
// we pop the minimum value, we run the pop function twice.

import java.util.Stack;

class MinStack {
    Stack<Integer> s;

    int min;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);

    }

    public void pop() {
        int popped = s.pop();
        if(popped == min){
            min = s.pop();
        } 
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