// Time Complexity : push: O(1)
//                   pop: O(1)
//                   getMin:O(1)
//                   top: O(1)
// Space Complexity :Constructor O(n)
//                   add: O(1)
//                   remove: O(1)
//                   contains:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

class MinStack {
    Stack<Integer> stk;
    int min;

    public MinStack() {
        this.stk=new Stack<>();
        this.min = Integer.MAX_VALUE;
        stk.push(min);
    }

    public void push(int val) {
        if(val<=min){
            stk.push(min);
            min = val;
        }
        stk.push(val);
    }

    public void pop() {
        if(min==stk.pop()){
            min = stk.pop();
        }
    }

    public int top() {
       return stk.peek();
    }

    public int getMin() {
            return min ;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(10);
        s.push(5);
        s.push(20);
        s.push(25);
        s.push(30);
        s.pop();
        System.out.println(s.top() + " is top element of the stack");
        System.out.println(s.getMin() + " is minimum element of the stack");
    }
}
