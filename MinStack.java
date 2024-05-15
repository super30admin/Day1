// Time Complexity : 0(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a Stack and min value and intailze min val to Maximum Value. While pushing compare with min value if its less then push old min val to stack. then push the val to stack and then update new min.
// While poping check if pooped val is equal to min val if yes then pop and update the min val

class MinStack {

    Stack<Integer> s;
    int min;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<min)
        {
            s.push(min);
            min = val;
        }
         s.push(val);
    }
    
    public void pop() {
       int popped = s.pop();
       if(popped == min)
       {
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
