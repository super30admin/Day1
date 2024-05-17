import java.util.Stack;

// Time Complexity :
// push() - O(1)
// pop() - O(1) - O(n) - Amortization
// peek() - O(1) - O(n) - Amortization
// isEmpty() - O(1)
// Space Complexity :O(2n) - O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Designed using two stacks in and out.
// push() - push directly into in stack
// pop() - check out stack if its empty, if not remove from the top.
// If empty transfer from instack and then remove top element.
// peek() - same as pop() but for wont remove.
// is empty() - check if both stacks are empty.


public class ImplementQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public void MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    public void push(int x) {
        in.push(x);

    }

    public int pop() {
        peek();
        return out.pop();

    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();

    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();

    }

}
