// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
//problem 1 //T= O(1),s=O(n)
class MyHashSet {
    private boolean[][] storage;
    private int bucket;
    private int bucketItems;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }

    private int bucket(int key) {
        return key % bucket;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
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
        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        return storage[bucket] != null && storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


// Your code here along with comments explaining your approach

//Problem 2
class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;
    public MinStack() {
        this.st = new Stack <>();
        this.minSt = new Stack <>();
        this.min = Integer.MAX_VALUE;
        this.minSt.push(this.min);
    }
    
    public void push(int val) { 
        st.push(val);
        this.min = Math.min(minSt.peek(),val);
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();

    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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