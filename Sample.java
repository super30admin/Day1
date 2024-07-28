// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : while adding and removing same element, example - 0,1,0, pop,pop


// Your code here along with comments explaining your approach


import java.util.Stack;;
class MinStack {
    Stack<Integer> st;
    Stack<Integer> mSt;
    int min;

    public MinStack() {
         //Initialize your constructor 
          min = Integer.MAX_VALUE;
          st = new Stack();
          mSt = new Stack();
    }
    
    public void push(int val) {
        if(min >= val){
            this.min = val;
            mSt.push(min);
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.peek() == min){

            mSt.pop();
        }

        if(mSt.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = mSt.peek();
        }   
        st.pop(); 
    }
    
    public int top() {
         return st.peek();
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