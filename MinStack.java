import java.util.*;
class MinStack {

    // List<Integer> ls;
    // int size = 0;
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        // ls = new ArrayList<>();
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(this.min);
    }

    public void push(int val) {
        // ls.add(size++, val);
        st.push(val);
        min = Math.min(min, val);
        minSt.push(min);
    }

    public void pop() {
        // ls.remove(--size);
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top() {
        // return ls.get(size - 1);
        return st.peek();
    }

    public int getMin() {
        // int min = Integer.MAX_VALUE;
        // for(int item: ls){
        //     if(item < min){
        //         min = item;
        //     }
        // }
        // return min;

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