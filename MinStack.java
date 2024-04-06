// Time Complexity : Push O(1) Pop O(1) getMin - O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approach 1 - using 2 stacks. one stack is keeping track of values and other one is to keep track of min values
// Approach 2 - using only one stack
//
class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    /** T O(1)
     *  Check if min is greater than val. if so, then push min to the stack and also push val to the stack
     * @param val
     */
    public void push(int val) {
        if(min >= val) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    /**
     * T - O(1)
     *  check if min is equal to the pop element, then set min to pop
     * @param val
     */
    public void pop(int val) {
        if(min == st.pop()) {
            min = st.pop();
        }
    }

    /**
     * T - O(1)
     *  Return min
     * @return
     */
    public int getMin() {
        return min;
    }

    /**
     * T - O(1)
     * Return peek element
     * @return
     */
    public int top() {
        return st.peek();
    }
}