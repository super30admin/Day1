// Time Complexity : push, pop, top, getmin O(1)
// Space Complexity : O(n) where n is number of ele in stack but just 1 stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Based on learning

import java.util.Stack;

public class MinStackReducedSpaceComplexity {
    Stack<Integer> stack;
    int min;
    public MinStackReducedSpaceComplexity() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.stack.push(this.min);
    }

    /*
     If min is less than val just push val
     If min is greater than or equal to val push old min onto stack and update min. Now push actual val
     @param: val
     @return : None
     */

    public void push(int val) {
        if(val<=this.min){
            this.stack.push(this.min);
            this.min = val;
        }
        this.stack.push(val);
    }

    /*
      If stack is not empty and if min>=peek then pop old min and set new min as 2nd pop
      Else just pop
      @param: None
      @return : None
     */

    public void pop() {
        if(!this.stack.isEmpty()){
            if(this.min>=this.stack.peek()){
                this.stack.pop();
                this.min = this.stack.pop();
            } else {
                this.stack.pop();
            }
        }
    }

    /*
    @param:None
    @return: peek of stack
     */
    public int top() {
        return this.stack.peek();
    }

     /*
    @param:None
    @return: min variable
     */
    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        MinStackReducedSpaceComplexity minStack = new MinStackReducedSpaceComplexity();
        minStack.push(-2);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Get Min: " +minStack.getMin());
        minStack.pop();
        System.out.println("Top: " +minStack.top());
        System.out.println("Get Min: " +minStack.getMin());
    }
}
