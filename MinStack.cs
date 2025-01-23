#TC:O(1)
public class MinStack {

    private Stack<int> st;
    private Stack<int> minSt;
    private int min;

    public MinStack() {
        this.min = int.MaxValue;
        this.st = new Stack<int>();
        this.minSt = new Stack<int>();
        this.minSt.Push(this.min);
    }

    public void Push(int val) {
        min = Math.Min(min, val);
        st.Push(val);
        minSt.Push(min);
    }

    public void Pop() {
        st.Pop();
        minSt.Pop();
        min = minSt.Peek();
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