// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 *
 * TIme Complexity:
 * O(1) --> push(), pop(), top(), getMin()
 *
 * Space Complexity:
 * O(1) --> push(), pop(), top(), getMin()
 *
 */

import java.util.Stack;
class MinStack {
    private Stack<Integer> originalStack;
    private Stack<Integer> minStack;
    public MinStack() {
        originalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        originalStack.push(val);
        minStack.push((minStack.size()==0 || minStack.peek()>val)?val:minStack.peek());
    }

    public void pop() {
        originalStack.pop();
        minStack.pop();
    }

    public int top() {
        return minStack.size()==0 ? -1 :originalStack.peek();
    }

    public int getMin() {
        return minStack.size()==0 ? -1 :minStack.peek();
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