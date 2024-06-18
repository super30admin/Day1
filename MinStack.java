// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack() {
        // Initialising stack and min value
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // if val is less than min value, assign min to val.
        if(val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        // if the popped value is equal to min value then assign min to popped value
        int popped = stack.pop();
        if(min == popped) {
            min = stack.pop();
        }
    }

    public int top() {
        int topElement = stack.peek();
        return topElement;
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