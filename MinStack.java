/*
Approach - using the pre-exisiting stack ds in java
and pushing the min whenever it is getting changed in the stack along with the value
for pop if the val is min we update the min at that point as well.
 */

/**
 * MinStack : MinStack
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 22, 2024)
 * @since : 1.0 (Oct 22, 2024)
 */
import java.util.*;

class MinStack {
	Stack<Integer> stack;
	int min;
	public MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int val) {
		if(val <= min){
			stack.push(min);
			min = val;
		}
		stack.push(val);
	}
	
	public void pop() {
		if(min == stack.pop()){
			min = stack.pop();
		}
	}
	
	public int top() {
		return stack.peek();
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