// java function to design Hashset
// Time Complexity - O(1)
//Space Complexity - O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : earlier did not handle the case of duplicates but corrected it later


import java.util.*;

class MinStack {
    List<Integer> stack;
    List <Integer> minStack;

    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new  ArrayList<Integer>();

    }

    public void push(int val) {
        stack.add(val);// push value into the main stack
        int newMin = val; // current  minimum value
        if(minStack.size() > 0){
            newMin = Math.min(minStack.get(minStack.size() - 1),newMin);

        } // compare the minimum value in stack with the last element in minStack
        minStack.add(newMin); // smaller of the 2 is pushed into the minstack
    }

    public void pop() {
        if(stack.size() != 0){
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
        }

    }

    public int top() {
        if(stack.size() != 0){
            return stack.get(stack.size() - 1);
        }
        return 0;

    }

    public int getMin() {
        if(minStack.size() != 0) {
            return minStack.get(minStack.size() - 1);
        }
        return 0;
    }

    public static void main (String []args){
        MinStack obj = new MinStack();

        // Pushing elements
        obj.push(5);
        obj.push(2);
        obj.push(2);
        obj.push(1);
        System.out.println("Top element: " + obj.top()); // Output: 1
        System.out.println("Minimum element: " + obj.getMin()); // Output: 1

        // Popping the top element
        obj.pop();
        System.out.println("Top element after pop: " + obj.top()); // Output: 2
        System.out.println("Minimum element after pop: " + obj.getMin()); // Output: 2

        // Pushing more elements
        obj.push(0);
        System.out.println("Top element: " + obj.top()); // Output: 0
        System.out.println("Minimum element: " + obj.getMin()); // Output: 0

        // Popping again
        obj.pop();
        System.out.println("Top element after pop: " + obj.top()); // Output: 2
        System.out.println("Minimum element after pop: " + obj.getMin()); // Output: 2
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