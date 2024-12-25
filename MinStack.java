import java.util.Stack;

/**
 * Time Complexity
 * Push: O(1)
 * Pop: O(1)
 * Top: O(1)
 * Get Min: O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Had some confusion around popping
 * value from stack.
 */
class MinStack {

  Stack<Integer> stack; // We use inbuilt stack as the problem statement doesn't restrict it.
  int min;

  public MinStack() {
    stack = new Stack<>(); // Initialize stack
    min = Integer.MAX_VALUE; // Initialize min
  }

  // Check if value to be pushed is <= existing min.
  // If yes, we push the old min value and update the min with the new value.
  // <= condition is used to handle duplicates in the input
  public void push(int val) {
    if (val <= min) {
      stack.push(min);
      min = val;
    }
    stack.push(val);
  }

  // We pop the value and check if the poppedValue = min.
  // If yes, we pop one more value and update the min with old min.
  public void pop() {
    int poppedValue = stack.pop();
    if (poppedValue == min) {
      min = stack.pop();
    }
  }

  // Return top of the stack.
  public int top() {
    return stack.peek();
  }

  // Return min value
  public int getMin() {
    return min;
  }
}