// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int currentMinimum;

    public MinStack() {
        currentMinimum = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push method adds a new value to the stack and updates the minStack with previous min value
    public void push(int val) {
        stack.push(val);
        if (currentMinimum >= val) {
            minStack.push(currentMinimum);
            currentMinimum = val;
        }
    }

    // Pop method removes the top element from the stack and updates the min stack if current minimum is popped
    public void pop() {
        if (stack.pop() == currentMinimum) {
            currentMinimum = minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return currentMinimum;
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