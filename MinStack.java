// Time Complexity : O(1)
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not Really


//1st Approach - Using Pairs and Single Stack

class MinStack {
    int min; // Variable to store the current minimum value in the stack
    ArrayList<Pair> stack; // ArrayList to store the elements of the stack along with their minimum value

    public MinStack() {
        this.min = Integer.MAX_VALUE; // Initialize the min to the maximum possible value
        stack = new ArrayList<>(); // Initialize the stack ArrayList
    }
    
    // Method to push a new element onto the stack
    public void push(int val) {
        min = Math.min(val, min); // Update the min to be the minimum of val and current min
        Pair<Integer, Integer> element = new Pair<>(val, min); // Create a Pair object with val and min
        stack.add(element); // Add the Pair object to the stack ArrayList
    }
    
    // Method to pop the top element from the stack
    public void pop() {
        stack.remove(stack.size() - 1); // Remove the top element from the stack
        if (!stack.isEmpty()) { // If the stack is not empty
            Pair<Integer, Integer> top = stack.get(stack.size() - 1); // Get the top element of the stack
            min = top.getValue(); // Update the min to be the min value of the new top element
        } else {
            min = Integer.MAX_VALUE; // If the stack is empty, reset min to the maximum possible value
        }
    }
    
    // Method to return the top element of the stack
    public int top() {
        Pair<Integer, Integer> top = stack.get(stack.size() - 1); // Get the top element of the stack
        return top.getKey(); // Return the key of the Pair (the element value)
    }
    
    // Method to return the current minimum value in the stack
    public int getMin() {
        Pair<Integer, Integer> top = stack.get(stack.size() - 1); // Get the top element of the stack
        return top.getValue() == Integer.MAX_VALUE ? Integer.MAX_VALUE : top.getValue(); // Return the min value of the Pair, or Integer.MAX_VALUE if the stack is empty
    }
}



// 2nd Approach - Using 2 stacks to keep history of minimums // I took 2 stacks instead of 1 because I found this one to more readable and easy to explain
class MinStack {
    Stack<Integer> originalStack; // Stack to store the original elements
    Stack<Integer> minStack; // Stack to store the minimum elements
    int currentMin; // Variable to keep track of the current minimum value in the stack

    public MinStack() {
        originalStack = new Stack();
        minStack = new Stack();
        this.currentMin = Integer.MAX_VALUE; // Initialize the currentMin to the maximum possible value
    }
    
    // Method to push a new element onto the stack
    public void push(int val) {
        if (val <= currentMin) { // If the new value is less than or equal to the current minimum
            minStack.push(currentMin); // Push the current minimum onto the minStack
            currentMin = val; // Update the current minimum to the new value
        }
        originalStack.push(val); // Push the new value onto the originalStack
    }
    
    // Method to pop the top element from the stack
    public void pop() {
        int val = originalStack.pop(); // Pop the top element from the originalStack
        if (val == currentMin) { // If the popped value is the current minimum
            currentMin = minStack.pop(); // Update the current minimum to the value from minStack
        }
    }
    
    // Method to return the top element of the stack
    public int top() {
        return originalStack.peek(); // Return the top element of the originalStack
    }
    
    // Method to return the current minimum value in the stack
    public int getMin() {
        return currentMin; // Return the current minimum value
    }
}
