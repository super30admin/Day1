//TC: Add, Remove, Contains : O(1)
//SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// * ORIGINAL APPROACH */

// class Node{
//     int data;
//     int min;
//     Node next;

//     public Node(int val, int minV){
//         this.data = val;
//         this.min = minV;
//         this.next = null;
//     }
// }

// class MinStack {

//     Node head;

//     public MinStack() {
//         head = null;
//     }

//     public void push(int val) {
//         if(head == null){
//             head = new Node(val, val);
//         } else {
//             Node ptr = new Node(val, Math.min(val, head.min));
//             ptr.next = head;
//             head = ptr;
//         }
//     }

//     public void pop() {

//         if(head != null){
//             Node ptr = head;
//             head = head.next;
//             ptr.next = null;
//         }
//     }

//     public int top() {
//         if(head == null)
//             return -1;
//         else{
//             return head.data;
//         }
//     }

//     public int getMin() {
//         if(head == null)
//             return -1;
//         else{
//             return head.min;
//         }
//     }
// }

// * CLASS APPROACH */

import java.util.Stack;

class Pair{
    int val;
    int min;

    public Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    Stack<Pair> minStack;
    int min;

    public MinStack() {
        minStack = new Stack<Pair>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Math.min(val, min);
        Pair obj = new Pair(val, min);
        minStack.push(obj);
    }

    public void pop() {
        minStack.pop();
        min = !minStack.isEmpty() ? minStack.peek().min : Integer.MAX_VALUE;
    }

    public int top() {
        return minStack.peek().val;
    }

    public int getMin() {
        return minStack.peek().min;
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