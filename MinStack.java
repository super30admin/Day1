// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    Stack<Integer> s;
    int min;
    
    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        if(min == s.pop())
            min = s.pop();
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
