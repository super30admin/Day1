class MinStack {
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Approach: Using Single Stack and push value and Previous min into the stack. 
    // Dry Run : 5 9 4 4 11 pop pop pop pop pop  getMin
    Stack<Integer> stack;
    int currMin;
    public MinStack() {
        this.stack = new Stack<>();
        this.currMin = Integer.MAX_VALUE; // infinity
    }
    
    public void push(int val) {
        // if min changes before pushing
        // push the previous min and set the new min
        // currMin = infinity , 5 , 4 
        if(currMin >= val){
            stack.push(currMin);
            currMin = val;
        } 
        stack.push(val);
        // infinity , 5 , 9 , 5, 4 , 4 , 4, 11
    }
    
    public void pop() {
        // currMin - 4
        // infinity , 5 , 9 , 5, 4 , 4 , 4, 11
        if(currMin == stack.pop()){
            currMin = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return currMin;
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


class MinStack {
    // Time Complexity : O(1)
    // Space Complexity : O(n) # min stack
    // Approach : using two stacks and push value into stack and push minimum at every stage into minStack
    // Dry Run : 5 9 4 12 3 pop getMin
    int currMin;
    Stack<Integer> stack;
    Stack<Integer> minStck;
    public MinStack() {
        this.currMin = Integer.MAX_VALUE; 
        this.stack = new Stack<>(); 
        this.minStck = new Stack<>();
        minStck.push(currMin); 
    }
    
    public void push(int val) {
        currMin = Math.min(val,currMin); // infinity , 5,4,3
        stack.push(val);// 5 9 4 12 3
        minStck.push(currMin);// 5 5 4 4 3
    }
    
    public void pop() { // 3
        stack.pop(); // 5 4 9 12
        minStck.pop(); // 5 5 4 4
        currMin = minStck.peek(); // 4
    }
    
    public int top() {
        return stack.peek(); // 12
    }
    
    public int getMin() {
        return currMin; // 4
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