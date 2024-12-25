import java.util.Stack;

//Time COmplexity -> O(1)
//SpaceComplexity (O(N)) -> Average Case Instead of pushing on every element we are pushing the min elemnet only if the val <= min
class MinStackSolution2 {
    int min;
    Stack<Integer> s;
    Stack<Integer> miStack;
    public MinStackSolution2() {
        s = new Stack<>();
        miStack = new Stack<>();
        min = Integer.MAX_VALUE;
        miStack.push(min);
    }
    
    public void push(int val) {
        s.push(val);
        if(val <= min) {
            min = val;
            miStack.push(min);
        }
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped == min) {
           miStack.pop();
           min = miStack.peek(); 
        }
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