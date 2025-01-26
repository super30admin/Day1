import java.util.Stack;

public class MinStack{
    Stack<Integer> mainSt;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        mainSt=new Stack<>();
        minSt=new Stack<>();
        min=Integer.MAX_VALUE;
        minSt.push(min);
    }

    public void push(int val) {
        mainSt.push(val);
        min=Math.min(min,val);
        minSt.push(min);
    }

    public void pop() {
        mainSt.pop();
        minSt.pop();
        min=minSt.peek();
    }

    public int top() {
        return mainSt.peek();
    }

    public int getMin() {
        return min;
    }
}


