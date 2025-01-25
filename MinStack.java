// Time Complexity : Push = O(1), Pop = O(1), top = O(1), getMin = O(1)
// Space Complexity : O(n) where n = number of elements in the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MinStack {

    int min;
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        
        this.min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        
        //If we get a new value which is smaller than current min
        //We will save it as current min. But we also save previous min because we need it if we pop current min in future
        //Even if new val == min we save it
        if(min >= val) {
            minStack.push(min);
            min = val;
        }

        stack.push(val);
    }
    
    public void pop() {

        int popped = stack.pop();
        
        //If we are popping the minimum value then our minimum will be previous min
        if(popped == min) {
            //Store prev min in min
            min = minStack.pop();
        }
    }
    
    public int top() {
        
        //get the top element from stack
        return stack.peek();
    }
    
    public int getMin() {
        
        //we store current minimum in min
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