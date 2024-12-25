// Time Complexity : O(1)
// Space Complexity : O(n) On an average | We're pushing 2 times only when the current value is less than min
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

//We can either use 2 stack(1: contains the value , 2 : contains the min).
//OR we can either use 1 stack (example below).
import java.util.Stack;
class MinStack {
    Stack<Integer> stack;
    int min; // it holds the minimum value at any point of time.
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE; // initalized it with infinite
    }

    public void push(int val) {
        //If the current value which is being pushed is <= current min, then we're gonna push the min at that time, change the current min to the value and push the value.
        //If the value ! <= min just push the value;
        if(val <= min){ // why <=? to handle duplicates.
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        //if the popped value is equal to the min value at that time , we're gonna pop 1 more time because the 2nd pop will contain the prev min.
        int poppedValue = stack.pop();
        if(poppedValue == min){
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