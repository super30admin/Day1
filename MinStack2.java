// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Class MinStack2{
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

public MinStack() {
    this.min = Integer.MAX_VALUE;
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
}

// Pushes a value onto the stack and updates the min stack if necessary
// If the current value is smaller than or equal to the current min, push the old min to minStack
// and update the min to the new value
public void push(int val) {
    if(min>=val){
        minStack.push(min);
        min=val;
    }
    stack.push(val);

}

// Pops the top value from the stack and updates the min stack if necessary
// If the popped value is the current minimum, pop the min value from the minStack
// and restore the previous minimum value
public void pop() {
    int poppedVal = stack.pop();
    if(poppedVal == min) {
        min = minStack.pop();
    }
}
//Get the top value of the stack
public int top() {

    return stack.peek();
}

//Get the minimum value from the minStack
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