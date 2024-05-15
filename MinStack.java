// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wrong Answer. Was pushing val instead of min.


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> s;
    int min;

    public MinStack() {

        // initilize the stack s and min with infinity.
        s= new Stack<>();
        min = Integer.MAX_VALUE;

    }

    public void push(int val) {

        // when val <= min then push the min and val into the stack
        //else push only the val into stack.

        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);

    }

    public void pop() {

        // pop the 1st element. only if popped value == min then we pop
        // the second element and we change the min to 2nd popped value.

        int popped = s.pop();
        if(popped == min){
            min = s.pop();
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