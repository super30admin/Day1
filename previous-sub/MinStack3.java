
/*
Time Complexity: 0(1)
Space Complexity: 0(1)
Approach: Push two entries to the primary stack if you have a new minimum value. Use primary stack,
dont maintain min-stack.
*/

class MinStack {

    // data members
    private Stack<Integer> primaryStack;
    private int minValue;

    // constructor
    public MinStack() {
        // initialize stacks
        this.primaryStack = new Stack<Integer>();
        this.minValue = Integer.MAX_VALUE; // set minValue to +infinity
    }
    
    public void push(int val) {

        // compare minValue with the val
        if (minValue >= val){

            this.primaryStack.push(minValue); // initially infinity is the minValue
            this.primaryStack.push(val);

            this.minValue = val; // val is the new minVal now
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
            // pop another value from primary stack and update the minValue
            this.minValue = this.primaryStack.pop();
        }

        return;

    }
    
    public int top() {
        // this function will always be called on non-empty stack
        return this.primaryStack.peek();
    }
    
    public int getMin() {
        
        return this.minValue;
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
