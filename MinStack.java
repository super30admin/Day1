// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    private int min;


    public MinStack() {
        this.min=Integer.MAX_VALUE;
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.minStack.push(min);
    

        
    }
    
    public void push(int val) {

         min=Math.min(min,val);
        stack.push(val);
        minStack.push(min);
        
        
    }
    
    public void pop() {
        
        stack.pop();
        minStack.pop();
        min=minStack.peek();
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
