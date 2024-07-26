// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minst;
    private int min;

    public MinStack() 
    {
       this.st = new Stack();
       this.minst = new Stack();
       this.min = Integer.MAX_VALUE; 
    }
    
    public void push(int val) 
    {
        if(min >= val)
        {
            minst.push(min);
            min = val;

        }
        st.push(val);
    }
    
    public void pop() 
    {
        if(min == st.pop())
        {
            min = minst.pop();
        }
    }
    
    public int top() 
    {
        return st.peek();
    }
    
    public int getMin() 
    {
        return min;  
    }
}