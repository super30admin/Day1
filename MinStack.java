import java.util.Stack;

class MinStack {
    private Stack<Integer> stack = new Stack<>();
/*
 * Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
 */
    public MinStack() {}

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        //TODO
    	return stack.peek();
    }
}