// Time Complexity : O(1) for all operations push, pop, top, getmin
// Space Complexity : Average - O(n) - Worst - O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
import java.util.Stack;

class MinStack {
    // Declaring stack
    Stack<Integer> s;
    // Declaring minVal variable for maintaining the min value from stack
    int minVal;

    public MinStack() {
        // Initializing the stack
        s = new Stack<>();
        // Initializing minVal to max integer value
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // Before pushing, comparing it with the minval, if valueToPush<minval
        if (val <= minVal) {
            // pushing the old minval to stack
            s.push(minVal);
            // and then updating the minval
            minVal = val;
        }
        // Also, pushing the current value to the stack
        s.push(val);
    }

    public void pop() {
        // popping once and storing it to compare
        int popVal = s.pop();
        // comparing the popped value with minval and again popping if equal
        if (popVal == minVal) {
            minVal = s.pop();
        }
    }

    public int top() {
        // peek will give the top element from stack
        return s.peek();

    }

    public int getMin() {
        // minval will give the value that is mininum in stack
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