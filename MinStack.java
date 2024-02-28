import java.util.Stack;

class MinStack {
    // Time Complexity : O(1)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : NA
    Stack<Integer> myStack;
    Stack<Integer> myMinStack;
    int min;

    public MinStack() {
        this.myStack = new Stack<>();
        this.myMinStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.myMinStack.push(min);
    }

    public void push(int val) {
        // Time Complexity : O(1)
        // approach to save some space
        this.myStack.push(val);
        // Insert only if min value is greater than or equal to current value
        if(min >= val){
            this.min = Math.min(val, min);
            this.myMinStack.push(min);

        }
    }

    public void pop() {
        // Time Complexity : O(1)
        int popped = this.myStack.pop();
        if(popped == min){ // pop only if min value equal to current value
            this.myMinStack.pop();
        }
        this.min = myMinStack.peek();
    }

    public int top() { // return top of stack, only show not pop
        // Time Complexity : O(1)
        return this.myStack.peek();
    }

    public int getMin() { // get the min value
        // Time Complexity : O(1)
        return this.min;
    }
}


class Main {
    public static void main(String args[]){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(-0);
        obj.pop();
        obj.push(-3);

        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }
}

