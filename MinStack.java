// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;
class MinStack {
    Stack<Integer> s;
    // Stack<Integer> minStack;
    int min;
    public MinStack() {
        // s = new Stack<>();
        // minStack = new Stack<>();
        // min = Integer.MAX_VALUE;
        // minStack.push(min);

        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // if(val<min) {
        //     min = val;
        // }
        // s.push(val);
        // minStack.push(min);

        if(val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        // s.pop();
        // minStack.pop();
        // min = minStack.peek();

        int popped = s.pop();
        if(popped == min) {
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}