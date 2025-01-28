import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek() ){
            minStack.push(val);
        }

    }

    public void pop() {
        if(!mainStack.isEmpty() ){
            if( mainStack.peek().equals(minStack.peek()) ){
                minStack.pop();
            }
            mainStack.pop();
        }

    }

    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}


/*
Time Complexity -> O(1) for all functions
Space Complexity -> O(n)*/