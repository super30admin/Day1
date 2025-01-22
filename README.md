Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)
class MyHashSet {
    private boolean[][] storage;  // Two-dimensional boolean array for storing hash set data
    private int buckets;          // Number of buckets (rows)
    private int bucketitems;      // Number of items per bucket (columns)

    // Constructor
    public MyHashSet() {
        this.bucketitems = 1000;  // Size of each bucket
        this.buckets = 1000;      // Total number of buckets
        this.storage = new boolean[buckets][];  // Initialize the storage (2D array)
    }

    // Hash function to determine the bucket index
    private int bucket(int key) {
        return key % buckets;  // Hash function for determining the bucket index
    }

    // Hash function to determine the bucket item index
    private int bucketitem(int key) {
        return key % bucketitems;  // Hash function for determining the item index within the bucket
    }

    // Add an element to the set
    public void add(int key) {
        int bucketIndex = bucket(key);  // Get the bucket for the given key
        if (storage[bucketIndex] == null) {  // If the bucket is empty
            // Initialize the bucket's array based on whether it's the first bucket or not
            if (bucketIndex == 0) {
                storage[bucketIndex] = new boolean[bucketitems + 1];  // Adding extra space for bucket 0
            } else {
                storage[bucketIndex] = new boolean[bucketitems];
            }
        }
        
        // Get the index for the item within the bucket
        int bucketItemIndex = bucketitem(key);
        storage[bucketIndex][bucketItemIndex] = true;  // Mark the item as added (true)
    }

    // Remove an element from the set
    public void remove(int key) {
        int bucketIndex = bucket(key);  // Get the bucket for the given key
        if (storage[bucketIndex] == null) return;  // If the bucket is empty, nothing to remove

        int bucketItemIndex = bucketitem(key);  // Get the index for the item within the bucket
        storage[bucketIndex][bucketItemIndex] = false;  // Mark the item as removed (false)
    }

    // Check if an element exists in the set
    public boolean contains(int key) {
        int bucketIndex = bucket(key);  // Get the bucket for the given key
        if (storage[bucketIndex] == null) return false;  // If the bucket is empty, the key does not exist

        int bucketItemIndex = bucketitem(key);  // Get the index for the item within the bucket
        return storage[bucketIndex][bucketItemIndex];  // Return whether the item is present (true) or not (false)
    }
}




## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack {
     Stack<Integer> st;
    Stack<Integer> minst;
    int min;
    public MinStack() {
      this.min = Integer.MAX_VALUE;
      this.st = new Stack<>();
      this.minst = new Stack<>();
      this.minst.push(this.min);
      
    }
    
    public void push(int val) {
       min = Math.min(min,val);
        st.push(val);
        minst.push(min); 
    }
    
    public void pop() {
        st.pop();
       minst.pop(); 
       min = minst.peek(); 
    }
    
    public int top() {
     return st.peek();   
    }
    
    public int getMin() {
        return min; 
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

