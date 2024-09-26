import java.util.Stack;

//All the operations implemented in this class are of O(1) tiem complexity. 

class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;

    }

    public void push(int val) {
        if(val <= min){
            st.push(min);
            st.push(val);
            min = val;
        }
        else{
           st.push(val); 
        }


    }

    public void pop() {
        if(st.empty()) return;
        if(st.pop() == min) min = st.pop();

    }

    public int top() {
        return st.peek();

    }

    public int getMin() {
        return min;

    }
}
