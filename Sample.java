//Problem 1: Design HashSet (https://leetcode.com/problems/design-hashset/)
// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage; // 2D array to store the keys
    int buckets; // Number of buckets in the array
    int bucketItems; // Size of each bucket

    // Constructor to initialize the storage array
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    // Primary hash function to calculate the bucket index
    private int primaryHashFunction(int key) {
        return key % buckets;
    }

    // Secondary hash function to calculate the index within the bucket
    private int secHashFunction(int key) {
        return key / bucketItems;
    }

    /*
     * To add a key, the primaryHashFunction is used to find the bucket index.
     * If the bucket is null, indicating it is empty, a new boolean array of size
     * bucketItems is created for that bucket.
     * The secHashFunction is then used to find the index within the bucket, and the
     * value at that index is set to true, indicating that the key is present.
     */
    public void add(int key) {
        int hash1 = primaryHashFunction(key);
        if (storage[hash1] == null) {
            if (hash1 == 0) {
                storage[hash1] = new boolean[bucketItems + 1];
            } else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        int hash2 = secHashFunction(key);
        storage[hash1][hash2] = true;
    }

    /*
     * To remove a key, the primaryHashFunction is used to find the bucket index.
     * If the bucket is null, the key is not present, so we return.
     * The secHashFunction is then used to find the index within the bucket, and the
     * value at that index is set to false, indicating that the key is no longer
     * present.
     */
    public void remove(int key) {
        int hash1 = primaryHashFunction(key);
        if (storage[hash1] == null) {
            return;
        }
        int hash2 = secHashFunction(key);
        storage[hash1][hash2] = false;
    }

    /*
     * To check if a key is present, the primaryHashFunction is used to find the
     * bucket index.
     * If the bucket is null, the key is not present, so we return false.
     * The secHashFunction is then used to find the index within the bucket, and the
     * value at that index is returned, indicating whether the key is present or
     * not.
     */
    public boolean contains(int key) {
        int hash1 = primaryHashFunction(key);
        if (storage[hash1] == null) {
            return false;
        }
        int hash2 = secHashFunction(key);
        return storage[hash1][hash2];
    }
}

// Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)
// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st; // Stack to store the elements
    Stack<Integer> min; // Stack to store the minimum element at we have seen so far

    public MinStack() {
        this.st = new Stack<>();
        this.min = new Stack<>();
        min.push(Integer.MAX_VALUE); // Pushing the maximum value to the min stack initially
    }

    /*
     * The push method adds a new element to the st stack.
     * If the new element is less than or equal to the current minimum (top of the
     * min stack), it's also added to the min stack. This ensures that min always
     * contains the minimum element up to that point.
     */
    public void push(int val) {
        st.push(val);
        if (min.peek() >= val)
            min.push(val);
    }

    /*
     * The pop method removes the top element from the st stack. If the element
     * being removed is the same as the current minimum (top of the min stack), it's
     * also removed from the min stack, as the next minimum element needs to be
     * recalculated.
     */
    public void pop() {
        int val = st.pop();
        if (min.peek() == val)
            min.pop();
    }

    // The top method returns the top element of the st stack.
    public int top() {
        return st.peek();
    }

    // The getMin method returns the top element of the min stack, which is the
    // minimum element in the stack.
    public int getMin() {
        return min.peek();
    }
}
