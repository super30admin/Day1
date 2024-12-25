// Time Complexity : O(1)
// Space Complexity : O(n) where n is number of ele in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.Stack;

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
    }
    /*
        Every incoming value pushed to stack
        Min is derived from existing min stack.peek and newly inserted and that is pushed into min stack
        min stack only maintains curr min as top
        @param:incoming val
        @return: None
     */
    public void push(int val) {
        stack.push(val);
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    /*
       pops from both stack and min stack
       @param: none
       @return: none
     */
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    /*
     currently added val
      @param: none
      @return: none
    */

    public int top() {
        return stack.peek();
    }
    /*
    top of min stack
      @param: none
      @return: none
    */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Get Min: " +minStack.getMin());
        minStack.pop();
        System.out.println("Top: " +minStack.top());
        System.out.println("Get Min: " +minStack.getMin());
    }
}
