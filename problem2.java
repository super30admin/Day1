// Time Complexity :  O(1) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes



class MinStack {
    Stack<Integer>st = new Stack<>();
    int min = Integer.MAX_VALUE;

public MinStack() {

}

public void push(int val) {
    if(val<=min)
    {
        st.push(min);
        min=val;
    }
    st.push(val);
    
}

public void pop() {
    int popped = st.pop();
    if(popped==min){
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

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(val);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/