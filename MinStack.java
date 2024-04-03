import java.util.*;
// Time Complexity : push - O(1), pop - O(1), top - O(1), getMin - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Implemented MinStack using two stacks in which one is used to store the elements and another is used to store the previous minimum
class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
    }
    
    //Adds the element in the stack
    public void push(int val) {
        st.push(val);
        if(min >= val) { //If current value is less than min, min is pushed into min stack
            minStack.push(min);
            min = val;//min is updated with element
        }
    }
    
    //Removes the top element in the stack
    public void pop() {
        if(min == st.peek()) { //If the top element is also the top element in min stack, we are removing it as well
            min = minStack.pop();
        }
        st.pop();
    }
    
    //Returns the top element in the stack
    public int top() {
        return st.peek();
    }
    
    //Returns the current minimum value in the stack
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