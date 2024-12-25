import java.util.Stack;

// Time Complexity : Push, Pop, Top, Min: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach



public class MinStack {
        Stack<Integer> st ;
        int min;

        public MinStack() {
            st = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if(val <= min){
                st.push(min);
                st.push(val);
                min = val;
                return;
            }
            st.push(val);
        }

        public void pop() {
            if(min == st.peek()){
                st.pop();
                min = top();
                st.pop();
                return;
            }
            st.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
}
