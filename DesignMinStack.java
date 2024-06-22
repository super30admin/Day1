// Time Complexity : push() - O(1), pop() - O(1), top() - O(1), getMin() - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

  // Initialise two stacks
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  // Constructor
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  // Pushing into stack, pushing into minstack only if value is lesser than the one pushed previously.
  public void push(int val) {
    stack.push(val);
    if(minStack.isEmpty() || val<=minStack.peek()) {
      minStack.push(val);
    }
  }

  // Popping from stack, popping from minstack only if the value equals the one being popped from main stack.
  public void pop() {
    if(minStack.peek().equals(stack.peek())) {
      minStack.pop();
    }
    stack.pop();
  }

  // Return the last element pushed.
  public int top() {
    return stack.peek();
  }

  // Return the last element pushed onto minStack.
  public int getMin() {
    return minStack.peek();
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