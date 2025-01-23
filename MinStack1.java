// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Class MinStack1{
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

// Constructor to initialize the stack and minStack
public MinStack() {
    this.min = Integer.MAX_VALUE;
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
    this.minStack.push(this.min); // Push the initial min value to the minStack
}

// Push a value onto the stack and update the minStack
public void push(int val) {

    min = Math.min(min,val);
    stack.push(val);
    minStack.push(min);
}

// Pop a value from the stack and update the minStack
public void pop() {
    stack.pop();
    minStack.pop();
    min=minStack.peek();
}

// Get the top value of the stack
public int top() {
    return stack.peek();
}

// Get the minimum value from the minStack
public int getMin() {
    return min;
}

public static void main(String args[]) {
    // Create a MinStack object
    MinStack minStack = new MinStack();

    // Push values onto the stack
    minStack.push(10);
    minStack.push(20);
    minStack.push(5);
    minStack.push(15);

    // Get the current top value and min value
    System.out.println("Top: " + minStack.top());  // Should print 15
    System.out.println("Min: " + minStack.getMin());  // Should print 5

    // Pop a value from the stack
    minStack.pop();
    System.out.println("After pop, Top: " + minStack.top());  // Should print 5
    System.out.println("After pop, Min: " + minStack.getMin());  // Should still print 5

    // Pop another value from the stack
    minStack.pop();
    System.out.println("After another pop, Top: " + minStack.top());  // Should print 20
    System.out.println("After another pop, Min: " + minStack.getMin());  // Should print 10
}
}

