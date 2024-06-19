
    /*
    Time Complexity : O(1)
    Space Complexity : O(N) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    */
class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {

        /*
        1. push min
        2. compare value with min and update min
        */
        stack.push(min);
        stack.push(val);
        min = Math.min(val, min);
    }
    
    public void pop() {
        /*
        1. pop
        2. pop again and update min
        */
        stack.pop();
        int newMin = stack.pop();
        min = newMin;
    }
    
    public int top() {
        /*
        return top
        */
        return stack.peek();
    }
    
    public int getMin() {
        /*
        return min
        */
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