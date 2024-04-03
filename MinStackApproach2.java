// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I had to go through the video once to understand this approach.

import java.util.Stack;

public class MinStackApproach2 {

    Stack<Integer> stack1;
    int minVal;

    public MinStackApproach2() {
        stack1 = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (minVal >= val) {
            stack1.push(minVal); // Add previous value ; or new min found so add current min to stack
            minVal = val;
        }
        stack1.push(val);
    }

    public void pop() {
        if (minVal == stack1.pop()) {
            minVal = stack1.pop(); // Set the previous value as current min
        }

    }

    public int top() {
        return stack1.peek();

    }

    public int getMin() {
        return minVal;

    }
}
