// Time Complexity : O(N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class MinStack {

    // List<Integer> ls;
    // int size = 0;
    Stack<Integer> st;  // Stack to store the elements
    Stack<Integer> minSt; // Stack to store the corresponding minimum elements of the stack elements
    int min;    // minimum

    public MinStack() {
        // ls = new ArrayList<>();
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(this.min); // push to the minimum stack, the maxium integer value to compare with other integer values
    }

    public void push(int val) {
        // ls.add(size++, val);
        st.push(val);
        min = Math.min(min, val);   //Compare the current element with the previous minimum value
        minSt.push(min);
    }

    public void pop() {
        // ls.remove(--size);
        st.pop();
        minSt.pop();    // pop the minimum value
        min = minSt.peek();
    }

    public int top() {
        // return ls.get(size - 1);
        return st.peek();   // returns value at the top of the stack
    }

    public int getMin() {
        // int min = Integer.MAX_VALUE;
        // for(int item: ls){
        //     if(item < min){
        //         min = item;
        //     }
        // }
        // return min;

        return min; // returns minimum value
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