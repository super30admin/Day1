import java.util.Stack;

/*
Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
 */
public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }

    public void push(int val) {
        min = Math.min(val,min);
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
        return minSt.peek();
    }
}

 class MinStack2 {
     Stack<Integer> st;
     int min;
     public MinStack2() {
         this.st = new Stack<>();

         this.min = Integer.MAX_VALUE;

     }

     public void push(int val) {
         if(min>=val){
             st.push(min);
         }
         min = Math.min(val,min);
         st.push(val);
     }

     public void pop() {
         if(st.pop() == min ){
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
