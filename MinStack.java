
// Time Complexity :O(1) for all functions
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
import java.util.Arrays;
import java.util.Stack;

class MinStack {
    int min;
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);

    }

    public void push(int val) {
        min = Math.min(min, val);
        minStack.push(min);
        stack.push(val);
        printvalues(minStack);
        printvalues(stack);
       
    }

    public void pop() {
        minStack.pop();
        stack.pop();
        min = minStack.peek();
        printvalues(minStack);
        printvalues(stack);
        System.out.println("----------POP-------------------");
    }

    public int top() {
        return minStack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }

    public static void main(String[] args) {
        MinStack st = new MinStack();
        int k = 0;
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println("----------PUSH END-------------------");
        st.getMin(); // return -3

        st.pop();

        st.top(); // return 0

        st.getMin(); // return -2

    }

    private void printvalues(Stack<Integer> s) {
        System.out.println("Stack values:");
        for (int i = s.size() - 1; i >= 0; i--) {
            System.out.print(s.get(i) + " ");
        }
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