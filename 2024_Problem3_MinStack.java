// 155. Min Stack - https://leetcode.com/problems/min-stack/description/

//Time Complexity: O(1) for all operations

class MinStack {

    Stack<Integer> stack ;
    Stack<Integer> minStack;
    int min ;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int x) {
        if(x < min){
            min = x;
        }
        minStack.push(min);
        stack.push(x);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}