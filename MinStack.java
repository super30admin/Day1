// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :

import java.util.Stack;

class MinStack {

    Stack<Integer> st; //Created a stack to store keys
    Stack<Integer> minst; //Created a stack to store minimum keys
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minst = new Stack<>();
        this.min = Integer.MAX_VALUE; //min variable initiated with infinity
        minst.push(min); //Push the minimum key into the min stack
    }

    public void push(int val) {
        min = Math.min(val, min); //Comparing between min and val to store into the min variable
        st.push(val); //Add the value into the stack
        minst.push(min); //Add the min val to the min stack
    }

    public void pop() {
        st.pop(); //Pop from stack
        minst.pop(); //Pop the simulatenously value in min stack
        min = minst.peek(); //The top key of the min stack is stored in min as it is the current minimum value

    }

    public int top() {
        return st.peek(); //Returns the top most key of stack

    }

    public int getMin() {
        return minst.peek(); //Returns minimum value

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