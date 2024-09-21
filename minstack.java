// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by pushing the min element along with keeping track of the previous min element with a variable
 */
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
       if(min >= val)
       {
            st.push(min);
            min = val;
       }
       st.push(val);
    }
    
    public void pop() {
        int temp = st.pop();
        if(temp == min)
        {
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}