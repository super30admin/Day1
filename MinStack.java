// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class MinStack {

    final int MAX = 30001;

    //Maintain original stack
    int stack[];

    //Maintain stack which has the minimum value of the remaing elements
    int minStack[];
    
    int top;

    public MinStack() {
        stack = new int[MAX];
        minStack = new int[MAX];
        top = -1;
    }
    
    public void push(int val) {
        top++;
        stack[top] = val;
        if(top==0){
            minStack[top] = val;
        } else{
            minStack[top] = Math.min(val, minStack[top-1]);
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}