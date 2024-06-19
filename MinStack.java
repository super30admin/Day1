/*
Time Complexity :
push : O(1)
pop : O(1)
top : O(1)
getmin : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
*/ 

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    int currentMin;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        currentMin = Integer.MAX_VALUE;
        minStack.push(currentMin);
    }
    
    public void push(int val) {
        currentMin = Math.min(val, currentMin);
        stack.push(val);
        minStack.push(currentMin);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        currentMin = minStack.peek();
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

