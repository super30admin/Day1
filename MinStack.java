/*
 * All operations(push(),pop(),getMin(),top()) : O(1);
 * Did this code successfully run on Leetcode :Yes
 */
import java.util.*;
class MinStack {
    private Stack<Integer> st;
    private int MIN;

    public MinStack() {
        st = new Stack<>();
        MIN = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        //when inserting see if current val is less than minimum.
        //if yes then insert older min and new min in stack and update the minimum
        if(val<=MIN){
            st.push(MIN);
            MIN = val;
            st.push(MIN);
        }
        //else only insert the element as it is
        else{
            st.push(val);
        }
    }
    
    public void pop() {
        //if popped element is the minimum then pop again update minimum value with second pop
        int val = st.pop();
        if(val==MIN){
            MIN = st.pop();
        }
    }
    
    public int top() {
        //return the top value of the stack as it is
        return st.peek();
    }
    
    public int getMin() {
        //return the min value
        return MIN;
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