public class MinStack {
    private Stack<int> mainStack;
    private Stack<int> minStack;
    
    public MinStack() {
        this.mainStack = new Stack<int>();
        this.minStack = new Stack<int>();
    }
    
    public void Push(int val) {
        mainStack.Push(val);
        if(minStack.Count == 0 || val <= minStack.Peek()){
            minStack.Push(val);
        }
        return;
    }

    public void Pop() {
        if (mainStack.Count == 0) {
           return;
        }
        
        int popval = mainStack.Pop();
        if(popval == minStack.Peek()){  
          minStack.Pop();
        }
        return;
    }
    
    public int Top() {
            return mainStack.Peek();

    }
    
    public int GetMin() {   
           return minStack.Peek();

    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(val);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */