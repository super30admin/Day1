/*
    Leetcode problem 155: Min Stack
    T.C: push() - O(1), pop() - O(1), top - O(1), getMin() - O(1)
    S.C: O(n) - O(n) + O(n) = O(2n) (Approach 1), O(n) - O(n + c) (worst case c = n - Approach 2)

    Approach 1: Solved using 2 stacks - the first stack maintains the LIFO order operations
    and the minStack maintains the corresponding min element for the existing stack

    Approach 2: Solved using 1 stack - maintain a min variable and if the element being pushed
    onto the stack is lesser than min variable, push the current min first and then the pushed
    element on top, while poping if the poped element is equal to min then pop twice and assign
    the last poped value to min
*/

class MinStack {
    
    Stack<Integer> stack;
    //Stack<Integer> minStack;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        //minStack = new Stack<>();
        //minStack.push(min);
        
        stack.push(min);
    }
    
    public void push(int val) {
        //min = Math.min(min, val);
        //stack.push(val);
        //minStack.push(min);

        if (min >= val) {            
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        //stack.pop();
        //minStack.pop();

        if (min == stack.pop()) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       //return minStack.peek();

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