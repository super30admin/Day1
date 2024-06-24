// Time Complexity : Amortized Time = O(1)
// Space Complexity :O(bucket)
// Did this code successfully run on Leetcode :28/33 testcases passed. It passes the initial cases but submission is not happening dont know the reason
// Any problem you faced while coding this : Confusing when creating a Array of Linkedlist to implement linear chaining.

//Also the time Complexity for parsing the LinkedList will be more than doing a double binding so I felt like only advantage of doing this is non contiguous memory location.


// Your code here along with comments explaining your approach

// 1. Used Linear chaining instead of Double hashing.
// 2.Hash function is used to store the keys into the parent array.
// 3.Same as double hashing but in linear hashing we create a linkedlist instead of a dynamic arraylist. We then append elements into arraylist by navigating to correct bucket in primary array.
// 4. While for removing we go to the respective index and remove the key and if the bucket is empty we then make them null.
// 5.Then for contains. We see if there is any linkedlist existing in the bucket then we return true else we return false.
import java.util.LinkedList;
import java.util.Stack;

class MyHashSet {
    private final LinkedList<Integer>[] hSet;
    private final int bucket=1000;

    public MyHashSet() {
        this.hSet=new LinkedList[this.bucket];
    }
    
    public int hashfunction(int key){
        return key % this.bucket;
    }
    
    public void add(int key) {
        int index= hashfunction(key);
        if(hSet[index]==null){
            hSet[index]=new LinkedList<>();
        if(!hSet[index].contains(key))
            hSet[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hashfunction(key);
        if (hSet[index] != null) {
            hSet[index].remove((Integer) key);
            if (hSet[index].isEmpty()) {
                hSet[index] = null;
            }
        }

    }
    
    public boolean contains(int key) {
        int index=hashfunction(key);
        if(hSet[index]==null)
            return false;
        else if(hSet[index].contains(key))
            return true;
        else
            return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



// Time Complexity : Amortized Time = O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Created two stack Stack and Minstack and had an temp variable to store the min values as they pushed into minstack and while popping the elements from both stack updating the maxi variable to store the minimum of 
// the entire stack. Returning this maxi variable for the getMin().

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int maxi;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
        this.maxi=Integer.MAX_VALUE;
        this.minStack.push(maxi);
    }
    
    public void push(int val) {
        stack.push(val);
        maxi=Math.min(maxi,val);
        minStack.push(maxi);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        maxi=minStack.peek();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return maxi;
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