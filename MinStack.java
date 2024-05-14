// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;


/**
 * Using single stack storing the corresponding min value if the value to be pushed is smaller than the min
 *
 *
 * Time Complexity: O(1) (push, pop, peek, top, getMin)
 * Space Complexity: O(n)
 */
class MinStack {

    Stack<Integer> stack;
    int minVal;

    public MinStack() {
        minVal = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    /*
     *push the min value only when the current vale is equal or mininum
     */
    public void push(int val) {

        if(val<=minVal) {
            stack.push(minVal);
            minVal = val;
        }
        stack.push(val);

    }

    /*
    if the popped value is equal to the min value, the pointer is in the original place of the min      element, pop second time to get the min value for the value present in the stack and consider it as min
     */
    public void pop() {

        int poppedVal = stack.pop();
        if(poppedVal == minVal) {
            minVal = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal;
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
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */