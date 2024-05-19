// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was not sure about why can't I set the sentennial 
//                                           value to be something like -1, why is Integer.MAX_VALUE 
//                                           the only value with which my Leetcode passed all tests?

class MinStack {
    Stack<Integer> primary;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.primary = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        primary.push(val);
        if(val <= min){
            min = val;
        }
        minStack.push(min);
    }
    
    public void pop() {
        primary.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return primary.peek();
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