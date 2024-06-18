import java.util.Objects;
import java.util.Stack;

 /*
 Time Complexity : O(1)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Using stack to solve this was comparatively easier
 but was only better than 10% of the submissions in leetcode. Would love to know any better
 submission with explanation.


 Implemented two stacks to solve the problem. One stack is used to push and pop all the elements
 but the other minStack is only pushed if the element is minimum than earlier and also popped if
 it matches the popped element from the regular stack. This way the top element from the minStack
 is always the minimum value from both stacks.
  */

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.empty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if(Objects.equals(stack.peek(), minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
       System.out.println("Top " + stack.peek());
       return stack.peek();
    }

    public int getMin() {
        System.out.println("Min " + minStack.peek());
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        minStack1.getMin();
        minStack1.pop();
        minStack1.top();
        minStack1.getMin();
    }
}
