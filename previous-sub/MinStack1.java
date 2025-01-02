
/*
Time Complexity: 0(1)
Space Complexity: 0(1)
Approach: Maintain 2 stacks, primary stack and a minStack. Maintian 1-1 mapping between
both the stacks
*/

class MinStack {
    // data members
    private Stack<Integer> primaryStack;
    private Stack<Integer> minStack;

    // constructor
    public MinStack() {
        // initialize stacks
        this.primaryStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int val) {

        // case -- primaryStack is empty right now
        if (this.primaryStack.size() == 0){
            this.primaryStack.push(val);
            this.minStack.push(val);
            return;
        }

        int minValue = Math.min(val, this.getMin());
        this.primaryStack.push(val);
        this.minStack.push(minValue);

        return;

    }
    
    public void pop() {

        // this function will always be called on non-empty stack
        this.primaryStack.pop();
        this.minStack.pop();
        return;

    }
    
    public int top() {
        // this function will always be called on non-empty stack
        return this.primaryStack.peek();
    }
    
    public int getMin() {

        // base-case, primaryStack is empty
        if (this.primaryStack.size() == 0){
            // no element in the stack, return max integer value
            return Integer.MAX_VALUE;
        }

        return this.minStack.peek();
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
