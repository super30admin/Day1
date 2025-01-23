// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Approach: I am using 2 stacks. One stack is used to store the elements and the other stack is used to store the minimum element at that point. I am pushing the element to the stack and also pushing the minimum element to the minStack. If the element is removed from the stack, I am removing the element from the stack and also removing the element from the minStack. If the minStack is empty, I am setting the min value to Integer.MAX_VALUE. If the minStack is not empty, I am setting the min value to the top element of the minStack.

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        min = Math.min(val, min);
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
        if(!minStack.isEmpty()){
            minStack.pop();
        }
        if(!minStack.isEmpty()){
            min = minStack.peek();
        }else{
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
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