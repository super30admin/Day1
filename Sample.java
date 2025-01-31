// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);  
    }
    
    public void push(int val) {
        if(val<=min) {
            min = val;
        }
        minStack.push(min);
        s.push(val);
    }
    
    public void pop() {
        minStack.pop();
        s.pop();
        min = minStack.peek();    
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}
