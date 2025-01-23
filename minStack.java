import java.util.Stack;

public class minStack {
     Stack <Integer> st;
    Stack <Integer> minst;
    int min;
    public minStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minst = new Stack<>();
       /* this.minst.push(this.min);*/
    }
    
    public void push(int val) {
        if(min >= val){
            minst.push(min);
            min = val;
        }
       /* min = Math.min(min,val);
        minst.push(min);*/
        st.push(val);
        
    }
    
    public void pop() {
        
        int popped = st.pop();
        if(popped ==  min){
           min = minst.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}
