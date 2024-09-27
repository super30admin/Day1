// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : push had issues with ordering and fixed it


//Approach to solve this problem is to only push the old minimum value when the current minimum value changes after pushing the new value.
// if pop operation could result in the changing of the current minimum value, pop twice and change the current minimum value to the last minimum value.
class MinStack {
    Stack<Integer> stack;
    int minimum;

    public MinStack() {
        this.stack=new Stack<>();
        this.minimum=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
// only push the old minimum value when the current 
// minimum value changes after pushing the new value val
        if(val <= minimum){          
            stack.push(minimum);
            minimum=val;
        }
        stack.push(val);
    }

    public void pop() {
// if pop operation could result in the changing of the current minimum value, 
// pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == minimum) minimum=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
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