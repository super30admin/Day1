/*
    TC - O(1)
    SC - O(1)
    Approach - I used the inbuilt stack class provided by java to implement the push, pop, top and getMin
*/

class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(val <= min){   
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min){
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