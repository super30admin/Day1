// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    public void push(int val) {
        min = Math.min(val, min);
        st.push(val);
        minSt.push(min);
    }
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return min;
    }
}




