import java.util.Stack;

public class problem2 {

class MinStack{
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack(){
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        min= Integer.MAX_VALUE;
        minSt.push(min);
    }
    public void push(int x){
        min= Math.min(min, x);
        st.push(x);
        minSt.push(min);
    }
    public void pop(){
        st.pop();
        minSt.pop();
        min= st.peek();
    }
    public int top(){
        return st.peek();
    }
    public int getMin(){
        return min;
    }
}


}
