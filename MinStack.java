// Time Complexity : O(1), push, pop, peek, getMin
// Space Complexity : O(n)


import java.util.Stack;

// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.empty()) {
            if(minStack.peek() > val) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        if(!stack.empty()) {
            return stack.peek();
        }
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if(!minStack.empty()) {
            return minStack.peek();
        }
        return Integer.MIN_VALUE;
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