// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//The MinStack uses two stacks: one for normal values (stack) and another for tracking the current minimum (minSt). 
//Every time a value is pushed, the current minimum is updated and pushed onto the minSt. 
//When popping, the minSt ensures the minimum is always correctly tracked, 
//allowing GetMin to return the minimum in constant time.

public class MinStack {
    Stack<int> stack;
    Stack<int> minSt;
    int min;

    public MinStack() {
        stack = new Stack<int>();
        minSt = new Stack<int>();
        min = int.MaxValue;
        minSt.Push(min);
    }
    
    public void Push(int val) {
       min = Math.Min(min, val);
       stack.Push(val);
       minSt.Push(min);
    }
    
    public void Pop() {
        stack.Pop();
        minSt.Pop();
        min = minSt.Peek();
    }
    
    public int Top() {
        return stack.Peek();
    }
    
    public int GetMin() {
        return min;
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