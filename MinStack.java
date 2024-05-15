import java.util.Stack;
class MinStack {
    Stack <Integer> s;
    int min;
    public MinStack() {
        s= new Stack<Integer>();
        min=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val<=min)
        {
            s.push(min); // operations will be performed on non empty stack so will push integer max value;
            min=val;
        }
        s.push(val);
    }

    public void pop()
    {
        int popped= s.pop();
        if(min== popped)
        {
            min=s.pop();
        }
    }

    public int top()
    {
        return s.peek();
    }

    public int getMin()
    {
        return min;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        int popped = minStack.top();
        int min = minStack.getMin();
        System.out.println(min);
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