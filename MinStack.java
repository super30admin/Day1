// Time Complexity :
// push - O(1)
// pop - O(1)
// top - O(1)
// getMin - O(1)
// Space Complexity : O(n), where n is the input range (worst case)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

 class MinStack {
    Node head;
    int min;

    public MinStack() {
        // Initialize min Value to max Integer value and head to null
        this.min = Integer.MAX_VALUE;
        this.head = null;
    }

    public void push(int val) {
        // min value to be stored in each node = minimum of (new value, old minimum)
        min = Math.min(val, min);

        if (head == null) {
            head = new Node(val, min);
        } else {
            Node node = new Node(val, min);
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head == null)
            return;
        head = head.next;
        // if stack is empty, assign min value back to max integer value
        // else it takes the value of min value stored in head after doing pop operation
        if (head == null) {
            min = Integer.MAX_VALUE;
        } else
            min = head.min;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class Node {
    int val;
    Node next;
    int min;

    public Node(int val, int min) {
        this.val = val;
        this.next = null;
        this.min = min;
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