// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Problem 1:(https://leetcode.com/problems/design-hashset/)

// Your code here along with comments explaining your approach
/*
 * Since we did not need to store the values and we could just a boolean array
 */
class MyHashSet {
    boolean[] arr;
    public MyHashSet() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key]=true;
    }
    
    public void remove(int key) {
        arr[key]=false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}

//Design MinStack (https://leetcode.com/problems/min-stack/)
//## Problem 2:
//Design MinStack (https://leetcode.com/problems/min-stack/)
// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*
 * I used two stacks
 */
class MinStack {
    int min; 
    Stack<Integer> stack;
    Stack<Integer> minst;
    public MinStack() {
        stack = new Stack<>();
        minst = new Stack<>();
        min=Integer. MAX_VALUE ;
    }
    
    public void push(int val) {
        if(val<min)
        {
            min=val;
            minst.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
         int item = stack.pop();
         if(item==min)
         {
            minst.pop();
            min=minst.peek();
         }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
