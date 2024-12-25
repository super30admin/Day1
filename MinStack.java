import java.util.Stack;

// Time Complexity: O(1) as all the operations included here takes constant time for execution
// Space Complexity: O(n) as Stack is used
// While pushing a new value, I tried to push value first and then minimum(in contrast to the taught approach), 
// it doesn't work for getMin and top retrieval. So switched back to the min and then val.
class MinimumStack {
    Stack<Integer> stack;
    int min;

    public MinimumStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        stack.push(min);
    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int popped = stack.pop();
        if (popped == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

public class MinStack {

    public static void main(String[] args) {
        MinimumStack obj = new MinimumStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }
}
