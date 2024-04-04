
// Time Complexity : ALl functions O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Add the last min value along with the current val;ue if the current value is the new minimum.
 */

import java.util.Stack;

class MinStack {
    int minValue;

    Stack<Integer> minSt;
    public MinStack() {
        this.minValue = Integer.MAX_VALUE;

        this.minSt = new Stack<>();
    }
    
    public void push(int val) {

        if(minValue>=val){
            minSt.push(minValue);
            minValue = val;
        }
        minSt.push(val);
    }
    
    public void pop() {
        if(minSt.pop() == minValue){
            minValue = minSt.pop();
        }
    }
    
    public int top() {
        return minSt.peek();
    }
    
    public int getMin() {
        return minValue;
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
