// This implementation is of creating a minimum stack that would find the minimum element in the stack at any point of time in constant time. A stack and a global minimum is maintained. Whenever an element less than the minimum is pushed into the stack, the current minimum is pushed into stack before the element which would help us to track the minimum element. 
// All the operations implemented in this class are of O(1) tiem complexity. 
// Except for the required stack no other extra stacks or datastructures are used. hence the time complexity would be O(n)
// The submission is passed successfully in LeetCode.

class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            st.push(val);
            min = val;
        }
        else{
           st.push(val); 
        }
        
        
    }
    
    public void pop() {
        if(st.empty()) return;
        if(st.pop() == min) min = st.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}