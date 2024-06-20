
// Time Complexity : O(1)
// Space Complexity : O(1) for pop top getMin operations
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.Stack;

class MinStack {
        private Stack<Integer> stack;
        private int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        stack.push(this.min);
    }
    
    public void push(int val) {
        if(val<=min){
        stack.push(min);
        min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String args[]){
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(2);
        obj.push(5);
        obj.push(9);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_4);
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