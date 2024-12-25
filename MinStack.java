class MinStack {
    Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        int min = head != null ? Math.min(head.min, val) : val;
        Node node = new Node(val, min);
        node.next = head;
        head = node;
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

    class Node {
        int val;
        int min;
        Node next;
        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
