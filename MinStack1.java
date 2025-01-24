/**
 * Using MinSTack to track corresponding min values at every push/pop
 * Time Complexity : O(1)
 * Space Complexity : O(N)
 * Did this code successfully run on Leetcode : Yes
 */
class MinStack {

    Integer[] stack;
    Integer[] minStack;
    Integer n = 10000;
    Integer size = 0;

    public MinStack() {
        stack = new Integer[n];
        minStack = new Integer[n];
    }
    
    public void push(int val) {
        stack[size] = val;
        if(size == 0 || val < minStack[size-1]){
            minStack[size] = val;
        }
        else{
            minStack[size] = minStack[size - 1];
        }
       size++;
    }
    
    public void pop() {
        if(size == 0){return;}
        else{
          stack[size - 1] = null;
          minStack[size - 1] = null;
        }
        size--;
    }
    
    public int top() {
        return stack[size - 1];
    }
    
    public int getMin() {
        return minStack[size - 1];
    }
}

