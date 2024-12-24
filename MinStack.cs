public class MinStack {

    Stack<int> stack, minStack;
    public MinStack() {
        stack = new Stack<int>();
        minStack = new Stack<int>();
    }
    
    public void Push(int val) {
        if(minStack.Count() > 0 && val <= minStack.Peek()){
            minStack.Push(val);
        }
        if(stack.Count() == 0 && minStack.Count() == 0)
        {
            minStack.Push(val);
        }
        stack.Push(val);
    }
    
    public void Pop() {
        if(stack.Count() == 0){
            return;
        }
        var number = stack.Pop();
        if(number == minStack.Peek()){
            minStack.Pop();
        }
    }
    
    public int Top() {
        return stack.Peek();
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