// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> minstack;
    int min;
    public MinStack() {
        minstack = new Stack<>();
        min=Integer.MAX_VALUE; //setting a default min value to infinity
    }
    
    public void push(int val) {
        if(val<=min){
            minstack.push(min); //pushing prev min in stack when we get new min to access it after we pop this min value
            min = val;
        }
        minstack.push(val);
    }
    
    public void pop() {
        if(minstack.pop()==min){
            min=minstack.pop(); //if min value is poped we get the prev min value
        }
    }
    
    public int top() {
        return minstack.peek();
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
