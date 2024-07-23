// Problem 155: MinStack
// Time Complexity : O(1) (push, pop, top, getMin)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
I have used two array. The first array is used to maintain stack and second array is used to track minimum element.
I have used one int to maintain top element.
When pushing value we will check with the current minStack value to compare min value and store the minimum value.
*/

class MinStack {
    private final int cap = 10001;
    private int[] stack;
    private int[] min;
    private int top;

    public MinStack() {
        stack = new int[cap];
        min = new int[cap];
        top = -1;
    }

    public void push(int val) {
        top++;
        stack[top] = val;
        if(top == 0){
            min[top] = val;
        }else{
            min[top] = Math.min(val, min[top-1]);
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return min[top];
    }
}
