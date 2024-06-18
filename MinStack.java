/*
    1. Time Complexity : For operations push, pop, top, getMin - O(1)
    2. Space Complexity : O(2n) => O(n)  
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Implemented minstack using linked list.
 * Each node consists data, min as member variables. 'min' represents the current mininum value in the stack at that node.
 */

public class MinStack {
    Node head;

    class Node {
        int data;
        int min;
        Node next;
        Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        int min = (head == null) ? val : Math.min(val, head.min);
        Node n = new Node(val, min, head);
        head = n;
    }

    public void pop() {
        Node n = head;
        head = head.next;
        n.next = null;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {
        MinStack s =  new MinStack();
        s.push(2);
        s.push(1);
        s.push(3);
        s.push(4);
        s.push(0);
        System.out.println("Min: " + s.getMin());
        s.pop();
        System.out.println("Top: " + s.top());
        System.out.println("Min: " + s.getMin());
    }
} 
