import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES. in pop(), I was directly popping and comparing with min, the soultion didnt work.
// I assigned first popped value to variable then compared with min walue. then it worked. line 28-32.


// Your code here along with comments explaining your approach
//push()
// Initially start by assinging the min value to inter.MAX_VALUE.
// start pushing elements, while comparing to current min value. if new value to be pushed is less than
// or equal to current min, push current min to stack, update min value, then push the value to stack.
//pop()
//pop() the value and store i na variable.
// compare the variable with min value, if it equals min, pop another value.
// top()
// USed inbuilt peek()
//min() returns the min value maintained at any point.

// Reasons for this approach.
// Earlier I had two stack approach in the leetcode. After today's class, I understood the ease of one stack and benifit and
// most importantly, we should provide the most optimal solution we know.
// Also pushing two stack approach that I had orginally coded.
public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
            System.out.println("min is" + min);
        }
        stack.push(val);
        System.out.println("pushed val is" + val);
    }

    public void pop() {
        int s = stack.pop();
        System.out.println("popped value is " + s);
        if (s == min)
            min = stack.pop();
        System.out.println("new min value is " + min);

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        System.out.println("final min is " +min);
        return min;
    }

}
