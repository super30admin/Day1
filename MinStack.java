import java.util.Stack;

/**
 * Time Complexity
 * Push,Pop,Top,Get Min: O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

public class MinStack {
	Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;


	public MinStack() {
		stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
	public void push(int val) {
        if(val <= min){
            min = val;
        }
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
    	stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

}
