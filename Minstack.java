// Time Complexity : O(1) for all operations

// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import static java.lang.Integer.valueOf;
import static java.util.Collections.lastIndexOfSubList;

// Approach 1 : Two stack
// class MinStack {
//     Stack<Integer> st;
//     Stack<Integer> minSt;
//     int min;

//     public MinStack() {
//         this.st = new Stack<>();
//         this.minSt = new Stack<>();
//         this.min = Integer.MAX_VALUE;
//         minSt.push(min); // Do it because the stack will be empty after poping the last element so add infinity in the stack.
//     }
    
//     public void push(int val) {
//         min = Math.min(val, min);
//         st.push(val);
//         minSt.push(min);
//     }
    
//     public void pop() {
//         st.pop();
//         minSt.pop();
//         min = minSt.peek();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         return min;
//     }
// }


// Approach 2 : Single Stack
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (min >= val){
            st.push(min);
            min = val;
        }
        st.push(val);
    }


    // Approach 1:
    // // We have to pop two times
    // public void pop() {
    //     // if(min == st.pop()){  //1st pop here
    //     //   min = st.pop(); // 2nd pop here
    //     // }
    //     if (min == st.peek()){
    //         st.pop();
    //         min = st.peek();
    //     }
    //     st.pop();
    // }

    
    // Approach 2:
    public void pop() {
        if(min == st.pop()){  // 1st pop here
          min = st.pop(); // 2nd pop here
        }
    }
    public int top() {
        return st.peek();
    }
    
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