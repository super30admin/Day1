// Approach: Instead of directly pushing the element onto the stack, I'm tracking the minimum
// element observed so far on the stack along with current element so that I can return the
// minimum element in O(1) time.
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Deque;
import java.util.LinkedList;
public class MinStack {
    Deque<StackNode> stack;
    class StackNode {
        int val;
        int minSoFar;

        StackNode(int v, int m) {
            val = v;
            minSoFar = m;
        }
    }

    MinStack() {
        stack = new LinkedList<>();
    }

    void push(int v) {
        if (stack.isEmpty()) {
            stack.push(new StackNode(v, v));
        } else {
            int min = stack.peek().minSoFar;
            stack.push(new StackNode(v, Math.min(min, v)));
        }
    }

    void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().val;
    }

    int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().minSoFar;
    }

    void printStack() {
        for (StackNode sn : stack) {
            System.out.println(sn.val);
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        System.out.println("Stack contents after pushing 10..");
        ms.push(10);
        ms.printStack();
        System.out.println("Stack contents after pushing 5..");
        ms.push(5);
        ms.printStack();
        System.out.println("Minimum element in stack.." + ms.getMin());
        System.out.println("Top element of stack.." + ms.top());
        System.out.println("Stack contents after pop operation..");
        ms.pop();
        ms.printStack();
        System.out.println("Minimum element in stack.." + ms.getMin());
    }
}