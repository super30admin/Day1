import java.util.Stack;

//TimeComplexity: O(1)
//SpaceComplexity: O(N) Using the Single Hash


class MinStackSolution3 {
    int min;
    Stack<Integer> s;
    public MinStackSolution3() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped == min) {
            min = s.peek();
            s.pop();
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