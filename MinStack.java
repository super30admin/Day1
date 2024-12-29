import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach

class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack() {

        this.stack= new Stack<>();
        min = Integer.MAX_VALUE;
     }
    
    public void push(int val) {
        if(val<=min){
           stack.push(min);
           min=val;
        }

        this.stack.push(val);
     }
    
    public void pop() {
        int x=this.stack.pop();
        if(x==min)
          min=this.stack.pop();
        
    }
    
    public int top() {
       return this.stack.peek();
        
    }
    
    public int getMin() {
        return this.min;
    }
}