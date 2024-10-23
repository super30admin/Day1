//Problem-1 Hashset
// Time Complexity : O(1) for adding, deleting, contains
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Getting partial testcases correct for assigning 1 extra bucket for 
// secondary hash function. So added 1001 buckets in the global declaration of secondary buckets.


class MyHashSet {
    int primaryList;
    int secondaryList;
    boolean [][] storage;
    public MyHashSet() {
        this.primaryList=1000;
        this.secondaryList=1001;
        this.storage = new boolean[primaryList][];
    }
    private int primaryhash(int key)
    {
        return key % primaryList;
    }
    private int secondaryhash(int key)
    {
        return key / secondaryList;
    }
    public void add(int key) {
        int primarykey= primaryhash(key);
        if(storage[primarykey]==null)
        {
            
            storage[primarykey]= new boolean[secondaryList+1];
        }
        int secondarykey=secondaryhash(key);
        storage[primarykey][secondarykey]=true;

    }
    
    public void remove(int key) {
        int primarykey= primaryhash(key);
        if(storage[primarykey]==null)
        {
            return;
        }
        else
        {
            int secondarykey=secondaryhash(key);
            storage[primarykey][secondarykey]=false;
        }
        
    }
    
    public boolean contains(int key) {
        int primarykey= primaryhash(key);
        if(storage[primarykey]==null)
        {
            return false;
        }
        else
        {
            int secondarykey=secondaryhash(key);
            return storage[primarykey][secondarykey];
        }
        
    }
}

// Uses double hashing with primary hashing using a modulous and secondary hashing using a division operation.
// took 1000 buckets in each hashing by Sq. root of 10^6.
// used boolean instead of integers.

// Your code here along with comments explaining your approach


//Problem-2 Min Stack
// Time Complexity : O(1) for push, pop as operations on stack is O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        min=Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        min=Math.min(val,min);
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min=minStack.peek();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}


