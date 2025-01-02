
/*
Time Complexity: 0(1)
Space Complexity: 0(1)
Approach: Only add to minStack if its the new minimum. No need to maintain 1-1 mapping.
Done using 2 stacks
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

        // compare minValue with the val
        if (minValue >= val){
            this.primaryStack.push(val);
            this.minStack.push(minValue); // val is the new minVal now
        }
        else{
            // minVal is unchanged
            this.primaryStack.push(val);
        }

        return;

    }
    
    public void pop() {

        // this function will always be called on non-empty stack
        int ele = this.primaryStack.pop();

        // to check if ele is the minValue only
        if (ele == this.getMin()){
            // pop from minStack because it might be the minimum
            this.minStack.pop();
        }

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
