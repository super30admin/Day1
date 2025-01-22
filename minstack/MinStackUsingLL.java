package minstack;

// Time Complexity : add, removetop  O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes after adding a check min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek()
// https://leetcode.com/problems/min-stack/submissions/1517271931/
// Any problem you faced while coding this : in one case the MinStack was empty and we were trying to do peek() on it which threw error.


import java.util.Stack;

public class MinStackUsingLL {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

//        Stack test = new Stack();
//        test.push(1);
//        error case
//        test.peek();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    class Node
    {
        private int val;
        private int min;
        private Node next;

        public Node(int val, int min, Node next)
        {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStackUsingLL() {
        head = null;
    }

    public void push(int val) {

        if(head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
