// Time Complexity : O(1) for all operations
// Space Complexity : O(n) as used two staks
// Did this code successfully run on Leetcode : yes
// Approach  : 
// Maintained two stacks - main stack stores values normally 
// and minstack maintains min value for each level of main stack
// a variable min will be having min value at all times. 

public class MinStack {
    public Stack<int> st; 
    public Stack<int> minSt;
    public int min;

    public MinStack() { 
        this.st = new Stack<int>();
        this.minSt = new Stack<int>();
        this.min = Int32.MaxValue; 
        minSt.Push(this.min);    
    }
    
    public void Push(int val) {
        this.min = Math.Min(this.min, val);
        this.st.Push(val);
        this.minSt.Push(this.min);
    }
    
    public void Pop() {
        this.st.Pop();
        this.minSt.Pop();
        this.min = this.minSt.Peek();
    }
    
    public int Top() {
        return st.Peek();
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