//using 2 stacks
//Time complexity: o(1)
//space complexity:o(n)

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE;
        minSt.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minSt.push(min);
    }

    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }

}


//Using one stack
//Time complexity :o(1)
//space complexity : worst case o(n)


class MinStack {
    private Stack<Integer> st;
    private int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
        st.push(min);
    }

    public void push(int val) {
        if(val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        if(st.pop() == min) {
            min = st.pop();
        }

    }

    public int top() {
        return st.peek();
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

/**
 *
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
