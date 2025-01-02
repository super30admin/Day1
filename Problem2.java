// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// S30 ID: Sawan Chakraborty_RN69DEC2024
// Your code here along with comments explaining your approach
import java.util.Stack;
class MinStack {

    Stack<Integer> s;
    int min;

    public MinStack() {
        this.s = new Stack<>();
        this.min = Integer.MAX_VALUE; // setting as max value
    }
    
    public void push(int val) {
        if(val<=min){ // pushing old min and new val
            s.push(min);
            min=val;
        }
        s.push(val);
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped==min){ // popping val and fetching new min if min is updated
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