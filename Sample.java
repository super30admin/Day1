// Problem 1 - Design HashSet

// Time Complexity : add - O(1), remove - O(1), contains - O(1)
// Space Complexity : Depends - If we are initializing the secondary array then add worst case scenario will be O(1000*1000) 
// and for remove and contains it's still O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially I was just thinking about creating a whole array and it would have been very much space expensive.

// Your code here along with comments explaining your approach
// First created 1000 length array of pointers with pointers initialized to null.
// Implemented double hashing and found out exact constant place for each element in the array.
// in add operation added the element in that place in remove operation removed the element from same location by setting it to false
// in contains operation checked the value at the computed location and returned the value
class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[1000][];
    }

    private int bucket (int key) {
        return key%buckets;
    }

    private int bucketItem (int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) return;

        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) {
            return false;
        }

        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


 // Problem 2 - Implement MinStack

// Time Complexity : all methods will have time complexity O(1)
// Space Complexity : as we do not consider input in space complexity, for this space complexity will be O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially while solving I did not think about the approach of performing all the operations using just one stack.
// When discussed in the class I realised the problem can be solved using just one stack as well.

// Your code here along with comments explaining your approach
// First initialize 2 stacks. Initialize min variable with maximum integer value.
// With every push operation push an element in first stack and if the element is less than or equal to current minimum then push it into min stack as well.
// In pop operation if the element popping out from first stack is current minimum then pop one element from min stack as well.
// We are storing current minimum in min variable so we can always return min in getMin method.
// In peek method we can just peek from main stack.
class MinStack {

    private Stack<Integer> st;
    // private Stack<Integer> minst;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        // this.minst = new Stack<>();
        this.min = Integer.MAX_VALUE;
        // minst.push(min);
    }
    
    public void push(int val) {
        // min = Math.min(min, val);
        // st.push(val);
        // minst.push(min);
        if(val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        // st.pop();
        // minst.pop();
        // min = minst.peek();
        if(st.pop() == min) {
            min = st.pop();
        }
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