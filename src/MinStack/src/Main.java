// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



import java.util.Stack;

public class Main {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;
    Main(){
        this.st=new Stack<>();
        this.minSt=new Stack<>();
        this.min=Integer.MAX_VALUE;
        this.minSt.push(this.min);

    }
    public void push(int x){
        st.push(x);
        this.min=Math.min(this.min,x);
        this.minSt.push(this.min);
    }
    public void pop(){
        st.pop();
        minSt.pop();
        this.min=this.minSt.peek();

    }
    public int top(){
        return st.peek();
    }
    public int getMin(){
        return this.min;
    }
    public static void main(String[] args) {

        Main main=new Main();
        main.push(-2);
        main.push(0);
        main.push(-3);
        main.getMin(); // return -3
        main.pop();
        main.top();    // return 0
        main.getMin(); // return -2
//       System.out.println("Min is:"+main);
    }
}