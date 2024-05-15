import java.util.*;
class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> minimumStack;
    int min;

    public MinStack() {
        this.stack1 = new Stack<>();
        this.minimumStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minimumStack.push(min);
        
    }
    
    public void push(int val) {
        min = Math.min(val,min);
        stack1.push(val);
        minimumStack.push(min);
    }
    
    public void pop() {
        stack1.pop();
        minimumStack.pop();
        min = minimumStack.peek();
        
    }
    
    public int top() {
        return stack1.peek();
        
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
