// Implement MinStack
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Initially, I haven't pushed the MAX_VALUE to stack. So whenever I do a pop, I am updating min but when my minStack is empty, it gave EmptyStackException.
// I want to understand how this.minStack.push(min) in constructor is updating my min to MAX_VALUE whenever stack is empty(my stack becoming empty after doing some pop operarions).

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        this.stack = new Stack();
        this.minStack = new Stack();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(min);
    }
    
    public void push(int val) {
        stack.push(val);
        if(val<=min) {
            min = val;
            minStack.push(val);
        } else{
            minStack.push(min);
        }
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