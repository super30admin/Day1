 // Time Complexity : push() : O(1), pop() : O(1), top() : O(1), getMin() : O(1)
 // Space Complexity : O(2N) => O(N) (As we are using 2 stacks)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : Ran into EmptyStackException as minStack was not initialzed with min value and was trying to use peek()

 // Approach: Used 2 stacks and 1 variable to store the minimum value. The second array with store the min values.
 class MinStack {

     Stack<Integer> s;
     Stack<Integer> minStack;
     int min;

     public MinStack() {
         this.s = new Stack<Integer>();
         this.minStack = new Stack<Integer>();
         this.min = Integer.MAX_VALUE;
         minStack.push(min);
     }

     public void push(int val) {
         if (val <= min)
             min = val;
         s.push(val);
         minStack.push(min);

     }

     public void pop() {
         if (!s.isEmpty()) {
             int popped = s.pop();
             minStack.pop();
             min = minStack.peek();
         }
     }

     public int top() {
         return s.peek();
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

// Time Complexity : push() : O(1), pop() : O(1), top() : O(1), getMin() : O(1)
// Space Complexity : O(2N) => O(N) (As we are storing the values twice)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Ran into EmptyStackException as minStack was not initialzed with min value and was trying to use peek()

/**
 * Approach 2: Used 1 stack and 1 variable to store the minimum value. In this approach if in push() min value changes; we will push the existing min and push the new value.
 * In pop, if the element to be popped is same as min then pop twice, the second popped value will be stored in min variable
 */
class MinStack {

    Stack<Integer> s;
    int min;

    public MinStack() {
        this.s = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);

    }

    public void pop() {
        if (!s.isEmpty()) {
            int popped = s.pop();
            if(popped == min){
                min = s.pop();
            }
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
