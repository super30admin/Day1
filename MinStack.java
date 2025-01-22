// Time Complexity : O(1) - push, pop, peek operations are O(1)
// Space Complexity : O(N) - N elements pushed onto the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
push - add a pair of elements onto the stack (x,y)
x: incoming value to be added to the stack
y: min of (incoming value , previous min value on top of the stack if present )
pop, peek are the same as the normal stack operations
 */
class MinStack {
    Stack<int[]> stack;

    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val,val});
            return;
        }
        stack.push(new int[]{val,Math.min(val,stack.peek()[1])});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
