// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack;
    int minimum = Integer.MAX_VALUE;

    public MinStack() {
        stack= new Stack<Integer>();
    }
    
    public void push(int val) {
         if(val <= minimum){          
            stack.push(minimum);
            minimum=val;
        }
        stack.push(val);
        
    }
    
    public void pop() {
        if(stack.pop() == minimum) 
            minimum=stack.pop();
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minimum;
    }
}
