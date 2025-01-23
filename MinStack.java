// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> minS1=new Stack<Integer>();
    int min;
    public MinStack() {
       min = Integer.MAX_VALUE;
       minS1.push(min); 
    }
    
    public void push(int val) {
         if(min > val || min == val ){
          minS1.push(min);
          min = val;
        }
         s1.push(val);
      
       
    }
    
    public void pop() {
        if(s1.peek() == min)
        {
            min = minS1.peek();
            minS1.pop();
        }
       
        s1.pop();
       
    }
    
    public int top() {
        return s1.peek();
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