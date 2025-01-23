// Overall Time Complexity : O(1) . The operations push, pop, top and getMin have time complexity of O(1).
// Overall Space Complexity : O(n) . The space complexity of storing the stack values and the corresponding minimum values is O(n+n) i.e. O(2n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The Min Stack problem below uses two stacks to retrieve the minimum element in the stack at any point.
// The first stack acts as main stack to hold the elements pushed on to the stack and the second stack holds the minimum values
// The min is updated whenever a new minium value is pushed onto the stack and when pop happens if the element popped is the current minimum element 
// then the second stack is popped and the current minimum is updated

import java.util.*;
public class MinStack {
    private Stack<Integer> st ;
    private Stack<Integer> st_min;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        this.st = new Stack<>();
        this.st_min = new Stack<>();
        this.st_min.push(min);  
    }
    
    public void push(int val) {
        if(min >= val){
            st_min.push(min);
            min = val;
        }
        st.push(val);
        
        
    }
    
    public void pop() {
        int popped_value = st.pop();
        if(popped_value == min){
            min = st_min.pop();
        }
        
        
        
        
        
    }
    
    public int top() {
        return st.peek();
       
        
    }
    
    public int getMin() {
        return min;
       
        
    }
}