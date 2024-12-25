import java.util.Stack;

//TimeComplexity: O(1)
//SpaceComplexity: O(N+N) Since two stacks are initialized
class MinStackSolution1 {
    int min;
    Stack<Integer> s;
    Stack<Integer> miStack;
    public MinStackSolution1() {
        s = new Stack<>();
        miStack = new Stack<>();
        min = Integer.MAX_VALUE;
        miStack.push(min);
    }
    
    public void push(int val) {
        s.push(val);
        if(val <= min) {
            min = val;
        }
        miStack.push(min);
    }
    
    public void pop() {
        s.pop();
        miStack.pop();
        min =  miStack.peek();
       
        
    }
    
    public int top() {
        return s.peek();
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