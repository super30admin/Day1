class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minSt;
    int min;


    public MinStack() {
         this.min = Integer.MAX_VALUE;
        this.stack= new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        this.minSt.push(min);
        this.stack.push(val);
        
    }
    
    public void pop() {
        this.stack.pop();
        this.minSt.pop();
        min = minSt.peek();        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
        
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