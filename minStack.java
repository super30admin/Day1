import java.util.Stack;
public class minStack{

    Stack<Integer> stack;
    int min;



    public static void main(String args[]){
        minStack minstack = new minStack();
        minstack.push(10);
        minstack.push(5);
        minstack.pop();
        System.out.println(minstack.getMin());
    }   
    
    public minStack(){
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            stack.push(x);
            min = x;
        }
        stack.push(x);

    }
    
    public void pop() {
        int popElement = stack.pop();
        if(min == popElement){
            min = stack.pop();
        }   
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}