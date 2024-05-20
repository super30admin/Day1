// Time Complexity : O(1) for all the operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Stack;
class MinStack {
    Stack<Integer> s;
    int min;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        //if the value is less than or equal to min, then push the min to stack and update min to the value
        if(val <= min){
            s.push(min);
            min = val;
        }
        //push the value to stack
        s.push(val);
    }
    
    public void pop() {
        //if the top of the stack is equal to min, then pop the top of the stack and update min to the next top of the stack
        if(s.pop() == min){
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