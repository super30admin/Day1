// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * In this problem I used two stacks, one to store the elements and another to track the minimum value at each level.
 * Every time a new element is pushed, the minimum value is updated and stored in the second stack.
 * In the pop method, Popped the top element from the stack and updated the minimum from minStack.
 */ 
class MinStack {

    // Main stack to hold the elements
    Stack<Integer> st;
    // Secondary stack to track the minimum value at each level of the stack
    Stack<Integer> minStack;
    // Variable to hold the current minimum value
    int min;

    // Constructor to initialize the stacks and set the initial minimum value to Integer.MAX_VALUE
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    // Push a new value onto the stack and update the minStack with the current minimum
    public void push(int val) {
        // If the new value is smaller than or equal to the current minimum, update min
        if(val <= min) {
            min = val;
        }
        st.push(val); // Push the value onto the main stack
        minStack.push(min); // Push the current minimum onto the minStack

    }
    
    // Pop the top element from the stack and update the minimum from minStack
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    // Return the top element of the stack without removing it
    public int top() {
        return st.peek();
    }
    
     // Return the current minimum value from the stack
    public int getMin() {
        return min;
    }
}

