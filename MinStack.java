// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : This code ran successfully and passed all the test cases when it was submitted.
// Any problem you faced while coding this : Was mostly okay.


/*
    Notes for self: What a minstack does is when a number of elements are inserted in the stack we can get the minimum element always in O(1) time. SC: O(N)
    //Taking a single stack as my data structure here.
    //A min variable initialized to Max initially to keep track of the minimum.
*/

/*
    for push operation
    1. Check if the value being pushed in the stack is <= the min value.
        if Yes: push the min value first then assign the x as new min.
    2. Then must push x into the stack at the end.
*/
/*
    for pop operation
    1. check value peing popped is the minimum value.
    if yes: then store the next popped value as the new min
    
*/
/*For top operation we can just peek in the stack.*/


class MinStack {
    
    Stack<Integer> stack = new Stack<>();
    
    int min= Integer.MAX_VALUE;
    /** initialize my data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x<=min)
        {
            stack.push(min);
            min=x;
        }
        
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop()==min)
        {
            min = stack.pop();
        }
    }
    
    
    public int top() {
        return stack.peek();
    }
    //return the min variable.
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */