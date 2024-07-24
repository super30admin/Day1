// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class DesignMinStack {
    private Stack<Integer> actualStack;
    private Stack<Integer> minStack;

    //Constructor
    public DesignMinStack(){
        this.actualStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    //Push data to both regular stack and compare the minimum element with the existing min stack top element and add it to min stack
    public void push(int data){
        actualStack.push(data);
        if(minStack.isEmpty() || data <= minStack.peek()){
            minStack.push(data);
        }
    }

    //pops the actualStack element and compare if the value with minStack top element and pops accordingly
    public void pop(){
        int val = actualStack.pop();
        if(val==minStack.peek()){
            minStack.pop();
        }
    }

    //top element from the actual/original stack
    public int top(){
        return actualStack.peek();
    }

    //min top element from the min stack
    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        DesignMinStack designMinStack = new DesignMinStack();
        designMinStack.push(1);
        designMinStack.push(5);
        designMinStack.push(6);
        designMinStack.pop();
        designMinStack.getMin();
        System.out.println("Min: " + designMinStack.getMin());
    }

}
