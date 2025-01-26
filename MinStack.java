// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {
    Stack s1;
    Stack s2;
    
    /**
     * Initialise 2 stacks in constructor.
     * First stack inputs all elements.
     * Second stack inputs minimum elements.
     */
    public MinStack() {
        s1=new Stack();
        s2=new Stack();
    }
    
    /**
     * Push value in first stack. If this value is less than top value of stack2 then push into stack2 as well.
     * 
     * @param val
     */
    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty() || s2.peek()>=val){
            s2.push(val);
        }
    }
    
    /**
     * removes top element of first stack. If this element is equal to top element of stack2 then remove that as well.
     */
    public void pop() {
        if(!s1.isEmpty()){
            int top=s1.peek();
            s1.pop();
            if(s2.peek()==top){
                s2.pop();
            }
        }
        
    }
    
    /**
     * returns top element of stack1
     * @return
     */
    public int top() {
	if(s1.isEmpty()) {
	    return -1;
	}
        return s1.peek();
    }
    
    /**
     * returns top element of stack2
     * @return
     */
    public int getMin() {
	if(s2.isEmpty()) {
	    return -1;
	}
        return s2.peek();
    }
    
 // Driver code 
    public static void main(String[] args) 
    { 

	 // MinStack object will be instantiated and called as such:
	 MinStack obj = new MinStack();
	 obj.push(1);
	 obj.pop();
	 int param_3 = obj.top();
	 int param_4 = obj.getMin();
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