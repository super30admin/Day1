// Time Complexity: All operations are O(1)
// Space Complexity : 2*O(N) --> O(N) space complexity where N is the number of elements 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't remember the optimal approach properly, had to go back to the video


// Your code here along with comments explaining your approach

class MinStack {
    private Stack<Integer> stack = new Stack <> ();
    int min = Integer.MAX_VALUE;
    public MinStack() {

    }
    
    public void push(int val) {
        if (min >= val){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        int x = stack.pop();
        if (min == x){
            min = stack.pop();
        }
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
