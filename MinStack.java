class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack();
    Stack<Integer> minValue =  new Stack();


    public void push(int val) {
        if(minValue.isEmpty() || val <= minValue.peek()){
            minValue.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.peek().equals(minValue.peek())){
            minValue.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}