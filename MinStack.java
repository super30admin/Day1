import java.util.Stack;

//Time - O(1) for all operations
//Space - O(n) n is the number of push operations
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack();
        minstack = new Stack<>();
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minstack.push(Math.min(minstack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
