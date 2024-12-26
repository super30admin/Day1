// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where number of elements to push
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Handling data type

// Your code here along with comments explaining your approach
// 1. I have taken a min variable and also a stack to store a difference between min and value to be pushed at a particular instance.
// 2. When I have to push(), I will deduct value from current min and then I will push that difference value to the stack. While pushing, if the stack is empty, I will put INFINITY(greater than constraints) in the stack and value in the min to maintain consistency.
// 3. Next time, when i have to pop(), I will check if the value at the top of the stack is +ve or -ve. If +ve, min has to be updated now because, In the last operation when lastMin - lastPushedvalue > 0 => lastMin > lastPushedval -> we must have updated min at this last instance. Else, no updation of min needed. (i.e., If lastMin < lastPushedVal, we would not have updated the min)
// 4. Incase of top(), we have to check if top ele is -ve, If yes, lastMin - lastPushedVal = diff => lastPushedVal = lastMin-diff (since its -ve, lastMin = currentMin) => lastPushedVal = currentMin-diff.
// 5. Incase of getMin(), return min.

import java.util.Stack;

public class MinStack {
    long min;
    Stack<Long> diffStack;

    public MinStack() {
        diffStack = new Stack<Long>();
    }

    public void push(int val) {
        if (diffStack.isEmpty()) {
            diffStack.push(Long.MAX_VALUE);
            min = val;
        } else {
            diffStack.push(min - val);
            if (val < min)
                min = val;
        }
    }

    public void pop() {
        long diff = diffStack.pop();
        if (diff == Long.MAX_VALUE) {
            return;
        }
        if (diff > 0) {
            min = diff + min;
        }
    }

    public int top() {
        long diff = diffStack.peek();
        if (diff == Long.MAX_VALUE || diff > 0) {
            return (int) min;
        }
        return (int) (min - diff);
    }

    public int getMin() {
        return (int) min;
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
